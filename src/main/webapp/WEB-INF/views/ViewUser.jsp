<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
</head>
<body>
	<h2>View Users</h2>
	
	First Name: ${users.firstName }
	<br>
	Last Name: ${users.lastName }
	<br>
	Email: ${users.email }
	<br>
	Gender: ${users.gender }
	<br>
	Created At: ${users.createdAt }
	<br>
	Role: ${users.role }
	<br>
</body>
</html>