<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wishlist</title>
</head>
<body>
	<h2>Wishlist</h2>
	
	<form action="savewishlist" method="post">
		<label for="productName">Product: </label>
			<select name="productId">
				<option>Select Product</option>
				
				<c:forEach items="${allProduct }" var="p">
					<option value="${p.productId }">${p.productName }</option>
				</c:forEach>
			</select>
		<br><br>
		
		<input type="submit" value="Save Wishlist">
	</form>
</body>
</html>