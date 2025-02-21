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
			<th>Action</th>
		</tr>
		<c:forEach items="${cartList}" var="c">
			<tr>
				<td>${c.quantity}</td>
				<td><a href="viewcart?cartId=${c.cartId }">View</a> | <a href="deletecart?cartId=${c.cartId }">Delete</a> | Edit</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>