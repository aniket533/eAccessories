<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart List</title>
</head>
<body>
	<h2>Cart List</h2>
	
	<table border="1">
		<tr>
			<th>Quantity</th>
		</tr>
		<c:forEach items="${cartList}" var="c">
			<tr>
				<td>${c.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>