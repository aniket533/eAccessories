<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Report User</title>
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
	
	<!-- Report Button CSS File -->
	<link href="https://cdn.datatables.net/buttons/3.2.2/css/buttons.dataTables.css" rel="stylesheet" />

</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Report- User</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item active">Report- User</li>
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
										Users<span>/all</span>
									</h5>


									<table class="table datatable datatable-table table-hover" id="myTable">
										<thead>
											<tr>
												<th>FirstName</th>
												<th>LastName</th>
												<th>Email</th>
												<th>ContactNum</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach items="${activeUsers}" var="u">
												<tr>
													<td>${u.firstName}</td>
													<td>${u.lastName}</td>
													<td>${u.email}</td>
													<td>${u.contactNum}</td>
												</tr>
											</c:forEach>
										</tbody>

									</table>



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
	
	<!-- Report Generation Scripts -->
	<script src="https://cdn.datatables.net/buttons/3.2.2/js/dataTables.buttons.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.dataTables.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.html5.min.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.print.min.js"></script>

	<script type="text/javascript">

	$( document ).ready(function() {
		//let table = new DataTable('#myTable');
		
		new DataTable('#myTable', {
 	 	    layout: {
 	 	        topStart: {
 	 	            buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
 	 	        }
 	 	    }
 	 	});
	});
	</script>

</body>
</html>