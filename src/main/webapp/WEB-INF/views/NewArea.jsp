<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Area</title>
</head>
<body>
	<h2>New Area</h2>
	<form action="savearea" method="post">
		<label for="areaName">Area Name: </label>
		<input type="text" id="areaName" name="areaName">
		<br><br>
		<input type="submit" value="Save Area">
	</form>
</body>
</html>