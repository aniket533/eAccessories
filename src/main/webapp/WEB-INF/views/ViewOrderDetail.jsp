<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order Detail</title>
</head>
<body>
	Quantity: ${orderDetail.quantity }
	<br>
	Price: ${orderDetail.price }
	<br>
	Status: ${orderDetail.status }
	<br>
	Order Detail ID: ${orderDetail.orderDetailId }
	<br>
	Order ID: ${orderDetail.orderId }
	<br>
	Product ID: ${orderDetail.productId }
	<br>
</body>
</html>