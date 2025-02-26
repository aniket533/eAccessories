<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sub Category</title>
</head>
<body>
	<h2>Sub Category</h2>
	<form action="savesubcategory" method="post">
	
		<label for="categoryName">Category: </label>
		<select name="categoryId">
			<option>Select Category</option>
			<c:forEach items="${allCategory }" var="ca">
				<option value="${ca.categoryId }">${ca.categoryName }</option>
			</c:forEach>
		</select>
		<br><br>
	
		<label for="subCategoryName">Category Name: </label>
		<input type="text" id="subCategoryName" name="subCategoryName">
			<br><br>
		<input type="submit" value="Save Sub Category">
	</form>
</body>
</html>