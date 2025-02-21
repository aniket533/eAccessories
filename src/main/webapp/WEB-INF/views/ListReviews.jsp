<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>
</head>
<body>
	<h2>Review List</h2>
	
	<table border="1">
		<tr>
			<th>Review</th>
			<th>Rating</th>
			<th>Created At</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${reviewsList }" var="r">
			<tr>
				<td>${r.reviewText }</td>
				<td>${r.rating }</td>
				<td>${r.createdAt }</td>
				<td><a href="viewreview?reviewId=${r.reviewId }">View</a> | <a href="deletereview?reviewId=${r.reviewId }">Delete</a> | Edit</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>