<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	
	<title>D&amp;D 5e Magic Items</title>
	
	<link type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/checkItem.css" /> 

</head>

<body>

	<div id="wrapper">
	
		<p>
			<a href="${pageContext.request.contextPath}/items/list">Back to List</a>
		</p>
	
		<div id="header">
			<h1>${item.itemName}</h1>
		</div>
		
		<div id="pageContext">
			${item.descr_top}
			<br><br>
			${item.descr_down}
		</div>
		
		<br>
		<h1>Attributes</h1>
		<div id="pgAttributes">
			<div id="ItCat">
				Category: ${item.equipCategory}
			</div>
			<div id="ItRar">
				Item Rarity: ${item.rarity}
			</div>
		</div>
		
		<c:url var="updateLink" value="/items/itemFormForUpdate">
			<c:param name="itemId" value="${item.id}"></c:param>
		</c:url>
		
		<br>
		<!-- Botão para dar update no item -->
		<input type="button" value="Update Item"
				onclick="window.location.href='${updateLink}'; return false"
				class="update-button">
		
	</div>
</body>

</html>