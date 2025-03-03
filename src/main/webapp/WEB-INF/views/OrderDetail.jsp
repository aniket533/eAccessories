<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Detail</title>
</head>
<body>
	<h2>Order Detail</h2>
	<form action="saveorderdetail" method="post">
	 	
	 	<label for="productName">Product Name: </label>
		<select name="productId">
			<option>Select Product</option>
			<c:forEach items="${allProduct }" var="p">
				<option value="${p.productId }">${p.productName }</option>
			</c:forEach>
		</select>
		<br><br>	 	
	 	
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