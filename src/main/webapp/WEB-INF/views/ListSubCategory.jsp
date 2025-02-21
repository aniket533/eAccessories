<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sub Category List</title>
</head>
<body>
	<h2>Sub Category List</h2>
	
	<table border="1">
		<tr>
			<th>Sub Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${subCategoryList }" var="a">
			<tr>
				<td>${a.subCategoryName }</td>
				<td><a href="viewsubcategory?subCategoryId=${a.subCategoryId }">View</a> | <a href="deletesubcategory?subCategoryId=${a.subCategoryId }">Delete</a> | Edit</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>