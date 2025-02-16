<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State</title>
</head>
<body>
	<h2>State</h2>
	<form action="savestate" method="post">
		<label for="stateName">Enter your state</label>
		<input type="text" id="stateName" name="stateName">
		<br><br>
		<input type="submit" value="Save state">
	</form>
	
</body>
</html>