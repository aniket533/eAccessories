<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	<h2>Order</h2>
	<form action="saveorder" method="post">
		<label for="status">Status(Pending, Shipped, Delivered, Cancle, etc): </label>
		<input type="text" id="status" name="status">
		<br><br>
		
		<label for="totalAmount">Total Amount: </label>
		<input type="text" id="totalAmount" name="totalAmount">
		<br><br>
		
		<input type="submit" value="Save Order">
	</form>
</body>
</html>