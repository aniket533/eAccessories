<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Orders</title>
</head>
<body>
	<h2>View Orders</h2>
	
	Status: ${order[0][2] }
	<br>
	Total Amount: ${order[0][3] }
	<br>
	Created At: ${order[0][1] }
	<br>
	Order ID: ${order[0][0] }
	<br>
	First Name: ${order[0][5] }
	<br>
	Last Name: ${order[0][6] }
	<br>
</body>
</html>