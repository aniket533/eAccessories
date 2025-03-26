<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Edit User</title>
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
 
 </head>
 <!-- Head & Style -->
 
 <body>
 	<!-- Header bar -->
 	<jsp:include page="AdminHeader.jsp"></jsp:include>
 	<!-- SideBar Manu -->
 	<jsp:include page="AdminSidebar.jsp"></jsp:include>
 	<!-- main body -->
 
 	<main id="main" class="main">
 
 		<div class="pagetitle">
 			<h1>Home</h1>
 			<nav>
 				<ol class="breadcrumb">
 					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
 					<li class="breadcrumb-item active">Profile</li>
 				</ol>
 			</nav>
 		</div>
 		<!-- End Page Title -->
 
 		<section class="section dashboard">
 			<div class="row">
 
 				<img src=" ${user.profilePicPath}"
 					style="height: 80px; width: 100%; max-width: 100px;"
 					alt="ProfileImg"
 					class="nav-profile  d-flex align-items-center pe-0 ">
 
 
 				<form class="row g-3 needs-validation" action="updateuser"
 					method="post" enctype="multipart/form-data" novalidate>
 					<div class="col-12">
 						<label for="firstName" class="form-label">First Name</label> <input
 							type="text" name="firstName" value="${user.firstName}"
 							class="form-control" id="firstName" required>
 
 					</div>
 					<div class="col-12">
 						<label for="lastName" class="form-label">Last Name</label> <input
 							type="text" name="lastName" value="${user.lastName}"
 							class="form-control" id="lastName" required>
 
 					</div>
 
 					<div class="col-12">
 						<label for="yourEmail" class="form-label">Your Email</label> <input
 							type="email" name="email" value="${user.email}"
 							class="form-control" id="yourEmail" required>
 
 					</div>
 					<input type="hidden" name="userId" value="${user.userId}" />
 					<div class="col-12">
 						<label for="yourPassword" class="form-label">Password</label> <input
 							type="password" name="password" value="${user.password}"
 							class="form-control" id="yourPassword" required>
 
 					</div>
 
 					<div class="col-12">
 						<label for="yourPassword" class="form-label">Confirm
 							Password</label> <input type="password" name="confirmPassword"
 							value="${user.password}" class="form-control"
 							id="confirmPassword" required>
 
 					</div>
 					
 					<div class="col-12">
                    	<label for="gender" class="form-label">Gender</label>
        				<select id="gender" name="gender" class="form-control" required>
            				<option value="">Select</option>
            				<option value="male">Male</option>
            				<option value="female">Female</option>
            				<option value="other">Other</option>
        				</select>                    	
                    </div>
 					
 					
 					<div class="col-12">
 						<label for="Contact no" class="form-label"> Mo</label> <input
 							type="tel" class="form-control" placeholder="ContactNum"
 							name="contactNum" value="${user.contactNum }" />
 					</div>
 					<div class="col-12">
 						<label for="profileImage" class="form-label"> Upload Image</label>
 						<input type="file" class="form-control" placeholder="profileImage"
 							name="profilePic" />
 					</div>
 
 					<div class="col-12">
 						<button class="btn btn-primary w-100" type="submit">Update
 							Account</button>
 					</div>
 				</form>
 
 
 			</div>
 		</section>
 
 	</main>
 
 	<jsp:include page="AdminFooter.jsp"></jsp:include>
 	<jsp:include page="AdminJS.jsp"></jsp:include>
 
 </body>
 </html>