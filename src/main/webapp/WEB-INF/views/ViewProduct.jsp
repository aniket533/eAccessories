<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Product</title>
</head>
<body>
	<h2>View Product</h2>
	
	Product Name: ${product.productName }
	<br>
	Product ID: ${product.productId }
	<br>
	Category ID: ${product.categoryId }
	<br>
	Sub Category ID: ${product.subCategoryId }
	<br>
	Base Price: ${product.basePrice }
	<br>
	Offer Price: ${product.offerPrice }
	<br>
	Offer Percentage: ${product.offerPercentage }
	<br>
	Product Detail: ${product.productDetail }
	<br>
	Product Image1: <img src="${product.productImageURL1}"  height="50px" width="50px"/>
	<br>
	Product Image2: <img src="${product.productImageURL2}"  height="50px" width="50px"/>
	<br>
	Product Image3: <img src="${product.productImageURL3}"  height="50px" width="50px"/>
	<br>
	Quantity: ${product.quantity }
	<br>
	Created At: ${product.createdAt }
</body>
</html>