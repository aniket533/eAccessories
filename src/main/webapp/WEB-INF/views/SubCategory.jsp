<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sub Category</title>
</head>
<body>
	<h2>Sub Category</h2>
	<form action="savesubcategory" method="post">
		<label for="subCategoryName">Category Name: </label>
		<input type="text" id="subCategoryName" name="subCategoryName">
			<br><br>
		<input type="submit" value="Save Sub Category">
	</form>
</body>
</html>