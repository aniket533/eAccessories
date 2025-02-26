<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
	<h2>Admin Dashboard</h2>
	
	Welcome, ${user.firstName }
	<br>
	<a href="newstate">Add State</a>
	
	<br>
	<a href="newcity">Add City</a>
	
	<br>
	<a href="logout">Logout</a>
</body>
</html>