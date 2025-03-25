<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit State</title>
</head>
<body>
	<form action="updatestate" method="post">
		<label for="stateName">Enter your state</label>
		<input type="text" id="stateName" name="stateName" value="${state.stateName }">
		<br><br>
		<input type="hidden" name="stateId" value="${state.stateId }">
		<input type="submit" value="Update state">
	</form>
</body>
</html>