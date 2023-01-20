<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

	<title>D&amp;D 5e Magic Items</title>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>D&amp;D 5e Magic Items</h2>
		</div>
	</div>
	
	<div>
		<h3>Save Magic Item</h3>
		
		<form:form action="saveItem" modelAttribute="item" method="POST">
		
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Item Name:</label></td>
						<td><form:input path="itemName" /></td>
					</tr>
					
					<tr>
						<td><label>Attributes:</label></td>
						<td><form:input path="descr_top" /></td>
					</tr>
					
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="descr_down" /></td>
					</tr>
					
					<tr>
						<td><label>Item Rarity:</label></td>
						<td><select name="rarity">
							<option>Common</option>
							<option>Uncommon</option>
							<option>Rare</option>
							<option>Very Rare</option>
							<option>Legendary</option>
							<option>Varies</option>
							<option>Artifact</option>
						</select></td>
					</tr>
					
					<tr>
						<td><label>Equipment Category:</label></td>
						<td><form:select path="equipCategory.id" items="${equip_list}" itemLabel="categoryName" itemValue="id"/>
						</td>
					</tr>
					
					<tr>
						<td><label>Source Book:</label></td>
						<td>
							<form:select path="sourceBook.id" items="${source_bookList}" itemLabel="bookName" itemValue="id"/>
    					</td>
					</tr>
					
					<tr>
						<td><label>Index Name:</label></td>
						<td><form:input path="indexName" /></td>
					</tr>
					
					<tr>
						<td><label>API Url:</label></td>
						<td><form:input path="url" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/items/list">Back to List</a>
		</p>
		
	</div>
</body>

</html>