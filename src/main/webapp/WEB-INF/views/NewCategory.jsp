<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>
	<h2>Category</h2>
	<form action="savecategory" method="post">
		<label for="categoryName">Category Name: </label>
		<input type="text" id="categoryName" name="categoryName">
			<br><br>
		<input type="submit" value="Save Category">
	</form>
</body>
</html>