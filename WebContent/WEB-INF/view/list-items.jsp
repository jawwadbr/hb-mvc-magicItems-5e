<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>D&amp;D 5e Magic Items</title>
	
	<link type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/style.css" /> 
			
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>D&amp;D 5e Magic Items</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Botão para adicionar item mágico -->
			<input type="button" value="Add Magic Item"
				onclick="window.location.href='formAddItems'; return false"
				class="add-button" />
			
			<form:form action="search" method="GET">
                Search Magic Items: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<div id="sortType">
				<form action="list" method="get">
					<label for="sortBy">Sort By:</label>
					<select name="sortBy" id="sortBy">
						<option value="none" ${sortSelected == "none" ? "selected" : ""}>None</option>
						<option value="itemName" ${sortSelected == "itemName" ? "selected" : ""}>Name</option>
						<option value="rarity" ${sortSelected == "rarity" ? "selected" : ""}>Rarity</option>
						<option value="equipCategory" ${sortSelected == "equipCategory" ? "selected" : ""}>Equipment Type</option>
						<option value="sourceBook" ${sortSelected == "sourceBook" ? "selected" : ""}>Source Book</option>
					</select>
					<input type="submit" value="Sort" class="add-button">
				</form>
			</div>
			
			<!-- HTML table para listar os items -->
			<table>
				<tr>
					<th>Name</th>
					<th>Rarity</th>
					<th>Equipment Type</th>
					<th>Source Book</th>
					<th>Action</th>
				</tr>
				
				<!-- For each to loop and print items -->
				<c:forEach var="tempItem" items="${magicItem}">
				
					<!-- opção de clicar no item para checar mais informações -->
					<c:url var="checkItem" value="/items/checkItem">
						<c:param name="itemId" value="${tempItem.id}"></c:param>
					</c:url>
					
					<!-- delete link with item id -->
					<c:url var="deleteLink" value="/items/delete">
						<c:param name="itemId" value="${tempItem.id}"></c:param>
					</c:url>
					
					<tr>
						<td>
							<a href=${checkItem }>${tempItem.itemName}</a>
						</td>
						<!--<td>${tempItem.itemName}</td>-->
						<td>${tempItem.rarity}</td>
						<td>${tempItem.equipCategory}</td>
						<td>${tempItem.sourceBook}</td>
						
						<td>
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete ${tempItem.itemName}?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
			
		</div>
	</div>
	
</body>

</html>