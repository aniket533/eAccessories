<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
</head>
<body>
	<h2>Order List</h2>
	
	<table border="1">
		<tr>
			<th>Status</th>
			<th>Total Amount</th>
			<th>Created At</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${orderList }" var="o">
			<tr>
				<td>${o.status }</td>
				<td>${o.totalAmount }</td>
				<td>${o.createdAt }</td>
				<td><a href="vieworder?orderId=${o.orderId }">View</a> | <a href="deleteorder?orderId=${o.orderId }">Delete</a> | Edit</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>