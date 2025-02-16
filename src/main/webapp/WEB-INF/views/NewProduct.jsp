<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<h2>Product</h2>
	<form action="saveproduct" method="post">
		<label for="productName">Product Name: </label>
		<input type="text" id="productName" name="productName">
		<br><br>
		
		<label for="basePrice">Base Price: </label>
		<input type="text" id="basePrice" name="basePrice">
		<br><br>
		
		<label for="offerPrice">Offer Price: </label>
		<input type="text" id="offerPrice" name="offerPrice">
		<br><br>
		
		<label for="offerPercentage">Offer Percentage: </label>
		<input type="text" id="offerPercentage" name="offerPercentage">
		<br><br>
		
		<label for="productDetail">Product Detail: </label>
		<input type="text" id="productDetail" name="productDetail">
		<br><br>
		
		<label for="productImageURL1">Product Image URL1: </label>
		<input type="text" id="productImageURL1" name="productImageURL1">
		<br><br>
		
		<label for="productImageURL2">Product Image URL2: </label>
		<input type="text" id="productImageURL2" name="productImageURL2">
		<br><br>
		
		<label for="productImageURL3">Product Image URL3: </label>
		<input type="text" id="productImageURL3" name="productImageURL3">
		<br><br>
		
		<label for="quantity">Quantity: </label>
		<input type="text" id="quantity" name="quantity">
		<br><br>
		
		<input type="submit" value="Save Product">
	</form>
</body>
</html>