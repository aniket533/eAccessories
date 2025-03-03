<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews</title>
</head>
<body>
	<h2>Reviews</h2>
	<form action="savereviews" method="post">
		<label for="productName">Product: </label>
			<select name="productId">
				<option>Select Product</option>
				
				<c:forEach items="${allProduct }" var="p">
					<option value="${p.productId }">${p.productName }</option>
				</c:forEach>
			</select>
		<br><br>
		
		<label for="reviewText">Review: </label>
		<textarea rows="5" cols="25" id="reviewText" name="reviewText" placeholder="Write your review"></textarea>
		<br><br>
		
		<label for="rating">Rating: </label>
		<input type="text" id="rating" name="rating">
		<br><br>
		
		<input type="submit" value="Save Review">
	</form>
</body>
</html>