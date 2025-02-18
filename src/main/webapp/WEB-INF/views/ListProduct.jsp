<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Product</title>
</head>
<body>
	<h2>List Product</h2>
	<table border="1">
		<c:forEach items="${productList}" var="m">
		
			<tr>
			<td>${m.productName }</td>
			<td>${m.basePrice }</td>
			<td>${m.offerPrice }</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>