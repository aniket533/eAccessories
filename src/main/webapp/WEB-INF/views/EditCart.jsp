<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Cart</title>
</head>
<body>
	<form action="updatecart" method="post">
			
		<label for="productName">Product: </label>
		<input type="text" id="productName" name="productName" value="${cart.productId}">
										
		<label for="quantity">Quantity: </label>
		<input type="text" id="quantity" name="quantity" value="${cart.quantity }">
		<br><br>
		<input type="hidden" name="cartId" value="${cart.cartId }">
		<input type="submit" value="Save to Cart">
	</form>
</body>
</html>