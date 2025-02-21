<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Wishlist</title>
</head>
<body>
	<h2>List of your wishlist</h2>
	
	<table border="1">
		<tr>
			<th>Created At</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${wishlistList }" var="w">
			<tr>
				<td>${w.createdAt }</td>
				<td><a href="viewwishlist?wishlistId=${w.wishlistId }">View</a> | <a href="deletewishlist?wishlistId=${w.wishlistId }">Delete</a> | Edit</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>