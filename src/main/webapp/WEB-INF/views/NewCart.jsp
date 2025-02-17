<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<h2>Cart</h2>
		<form action="savecart" method="post">
			<label for="quantity">Quantity: </label>
			<input type="text" id="quantity" name="quantity">
			<br><br>
			<input type="submit" value="Save Quantity">
		</form>
</body>
</html>