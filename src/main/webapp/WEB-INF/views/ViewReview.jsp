<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Reviews</title>
</head>
<body>
	<h2>View Review</h2>
	
	Review: ${review.reviewText }
	<br>
	Rating: ${review.rating }
	<br>
	Created At: ${review.createdAt }
	<br>
	Review ID: ${review.reviewId }
	<br>
</body>
</html>