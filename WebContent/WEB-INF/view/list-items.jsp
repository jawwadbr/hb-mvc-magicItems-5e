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
			
			<!-- HTML table para listar os items -->
			<table>
				<tr>
					<th>Name</th>
					<th>Rarity</th>
					<th>Equipment Type</th>
					<th>Source Book</th>
				</tr>
				
				<!-- For each to loop and print items -->
				<c:forEach var="tempItem" items="${magicItem}">
				
					<!-- opção de clicar no item para checar mais informações -->
					<c:url var="checkItem" value="/items/checkItem">
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
					</tr>
				</c:forEach>
				
			</table>
			
		</div>
	</div>
	
</body>

</html>