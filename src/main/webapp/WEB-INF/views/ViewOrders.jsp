<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Orders</title>
</head>
<body>
	<h2>View Orders</h2>
	
	Status: ${order.status }
	<br>
	Total Amount: ${order.totalAmount }
	<br>
	Created At: ${order.createdAt }
	<br>
	Order ID: ${order.orderId }
	<br>
	User ID: ${order.userId }
	<br>
</body>
</html>