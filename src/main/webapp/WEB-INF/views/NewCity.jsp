<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New City</title>
</head>
<body>
	<h2>New City</h2>
	<form action="savecity" method="post">
		<label for="cityName">City Name: </label>
		<input type="text" id="cityName" name="cityName">
		<br><br>
		<input type="submit" value="Save City">
	</form>
</body>
</html>