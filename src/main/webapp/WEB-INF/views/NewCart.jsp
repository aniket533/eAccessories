<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<h2>Cart</h2>
		<form action="savecart" method="post">
			
			<label for="productName">Product: </label>
			<select name="productId">
				<option>Select Product</option>
				
				<c:forEach items="${allProduct }" var="p">
					<option value="${p.productId }">${p.productName }</option>
				</c:forEach>
			</select>
			
			<label for="quantity">Quantity: </label>
			<input type="text" id="quantity" name="quantity">
			<br><br>
			<input type="submit" value="Save Quantity">
		</form>
</body>
</html>