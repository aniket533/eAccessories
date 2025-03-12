<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Order</title>
</head>
<body>
	<form action="updateorder" method="post">
		<label for="status">Status(Pending, Shipped, Delivered, Cancle, etc): </label>
		<input type="text" id="status" name="status" value="${order.status }">
		<br><br>
		
		<label for="totalAmount">Total Amount: </label>
		<input type="text" id="totalAmount" name="totalAmount" value="${order.totalAmount }">
		<br><br>
		
		<input type="hidden" name="orderId"  value="${order.orderId}"/>
		
		<input type="submit" value="Update Order">
	</form>
</body>
</html>