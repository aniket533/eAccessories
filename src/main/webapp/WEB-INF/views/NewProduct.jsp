<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Add Product</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
	
	<jsp:include page="AdminCss.jsp"></jsp:include>
	
	<!-- Template Table CSS File -->
	<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Add Product</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">Add Product</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 500px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Reports -->
						<div class="col-12">
							<div class="card">


								<div class="card-body">
									<h5 class="card-title">
										Products<span>/Add Product</span>
									</h5>


									<form action="saveproduct" method="post" encType="multipart/form-data">
										<label for="productName">Product Name: </label>
										<input type="text" id="productName" name="productName">
										<br><br>
										
										<label for="categoryName">Category: </label>
										<select id="categoryName" name="categoryId" required onchange="getSubCategory()">
											<option value="-1">Select Category</option>
											<c:forEach items="${allCategory }" var="ca">
												<option value="${ca.categoryId }">${ca.categoryName }</option>
											</c:forEach>
										</select>
										<br><br>
										
										<label for="subCategoryName">Category: </label>
										<select id="subCategoryName" name="subCategoryId">
											<option value="-1">Select Sub Category</option>
											<!--<c:forEach items="${allSubCategory }" var="sc">
												<option value="${sc.subCategoryId }">${sc.subCategoryName }</option>
											</c:forEach>-->
										</select>
										<br><br>
										
										<label for="basePrice">Base Price: </label>
										<input type="text" id="basePrice" name="basePrice">
										<br><br>
										
										<label for="offerPrice">Offer Price: </label>
										<input type="text" id="offerPrice" name="offerPrice">
										<br><br>
										
										<label for="offerPercentage">Offer Percentage: </label>
										<input type="text" id="offerPercentage" name="offerPercentage">
										<br><br>
										
										<label for="productDetail">Product Detail: </label>
										<input type="text" id="productDetail" name="productDetail">
										<br><br>
										
										<label for="productPic1">Product Pic 1: </label>
										<input type="file" id="productPic1" name="productPic1">
										<br><br>
										
										<label for="productPic2">Product Pic 2: </label>
										<input type="file" id="productPic2" name="productPic2">
										<br><br>
										
										<label for="productPic3">Product Pic 3: </label>
										<input type="file" id="productPic3" name="productPic3">
										<br><br>
										
										<label for="quantity">Quantity: </label>
										<input type="text" id="quantity" name="quantity">
										<br><br>
										
										<input type="submit" value="Save Product">
									</form>



								</div>

							</div>
						</div>
						<!-- End Reports -->

					</div>
				</div>
				<!-- End Left side columns -->

				

			</div>
		</section>

	</main>
	<!-- main content end  -->


	<jsp:include page="AdminFooter.jsp"></jsp:include>

	<jsp:include page="AdminJS.jsp"></jsp:include>
	
	

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

	<script type="text/javascript">

	$( document ).ready(function() {
		let table = new DataTable('#myTable');
	});
	</script>

	
	 <script type="text/javascript">

			function getSubCategory(){
				console.log("category Change");
				let categoryId = document.getElementById("categoryName").value;
				console.log(categoryId);	
				//url -> json REST 
				
				  $.get( "getallsubcategorybycategoryid/"+categoryId, function() {
					})
					  .done(function(data) {
					    console.log(data);
					    //fill the subcategory 
					    $('#subCategoryName').empty().append('<option selected="selected" value="-1">Select SubCategory</option>')
					    
					    for (var i = 0; i < data.length; i++) {
		      			  $('#subCategoryName').append('<option value="' + data[i].subCategoryId + '">' + data[i].subCategoryName + '</option>');
		   				 }
					    
					  })
					  .fail(function() {
					    alert( "error" );
					  })
					  
				
			}
		
		
	</script> 


</body>
</html>