<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	
	<title>${item.indexName}</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h1>${item.itemName}</h1>
		</div>
		<div id="pageContect">
			${item.descr_down}
		</div>
		
		<br>
		<h1>Attributes</h1>
		<div id="pgAttributes">
			<div>
				Category: ${item.equipCategory}
			</div>
			<div>
				Item Rarity: ${item.rarity}
			</div>
		</div>
	</div>
</body>

</html>