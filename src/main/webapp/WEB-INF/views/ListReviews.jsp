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
		<c:forEach items="${reviewsList }" var="r">
			<tr>
				<td>${r.reviewText }</td>
				<td>${r.rating }</td>
				<td>${r.createdAt }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>