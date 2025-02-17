<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Detail</title>
</head>
<body>
	<h2>Order Detail</h2>
	<form action="saveorderdetail" method="post">
	 	
	 	<label for="quantity">Quantity: </label>
		<input type="text" id="quantity" name="quantity">
		<br><br>
	 	
		<label for="price">Price: </label>
		<input type="text" id="price" name="price">
		<br><br>
	
		<label for="status">Status(Pending, Shipped, Delivered, Cancle, etc): </label>
		<input type="text" id="status" name="status">
		<br><br>
		
		<input type="submit" value="Save Order Detail">
	</form>
</body>
</html>