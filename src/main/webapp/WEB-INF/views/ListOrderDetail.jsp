<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Detail List</title>
</head>
<body>
	<h2>Order Detail List</h2>
	
	<table border="1">
		<tr>
			<th>Quantity</th>
			<th>Price</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${orderDetailList }" var="od">
			<tr>
				<td>${od.quantity }</td>
				<td>${od.price }</td>
				<td>${od.status }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>