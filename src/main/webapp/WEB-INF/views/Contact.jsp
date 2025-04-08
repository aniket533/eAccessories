<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Contact</title>
<jsp:include page="UserCss.jsp"></jsp:include>
</head>
<body>

	<!-- Spinner Start -->
	<div id="spinner"
		class="w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-grow text-primary" role="status"></div>
	</div>
	<!-- Spinner End -->

	<jsp:include page="UserHeader.jsp"></jsp:include>


	<!-- Single Page Header start -->
	<div class="container-fluid page-header py-5">
		<h1 class="text-center text-white display-6">Contact</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="home">Home</a></li>
			<li class="breadcrumb-item"><a href="#">Pages</a></li>
			<li class="breadcrumb-item active text-white">Contact</li>
		</ol>
	</div>
	<!-- Single Page Header End -->


	<!-- Contact Start -->
	<div class="container-fluid contact py-5">
		<div class="container py-5">
			<div class="p-5 bg-light rounded">
				<div class="row g-4">
					<div class="col-12">
						<div class="text-center mx-auto" style="max-width: 700px;">
							<h1 class="text-primary">Get in touch</h1>
							<p class="mb-4">
								The contact form is currently inactive. Get a functional and
								working contact form with Ajax & PHP in a few minutes. Just copy
								and paste the files, add a little code and you're done. <a
									href="https://htmlcodex.com/contact-form">Download Now</a>.
							</p>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="h-100 rounded">
							<iframe class="rounded w-100" style="height: 400px;"
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d11027.436180983537!2d72.55768556684514!3d23.03970913286066!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395e84f521640d4b%3A0x6853ee97a9a2996b!2sNavrangpura%2C%20Ahmedabad%2C%20Gujarat!5e0!3m2!1sen!2sin!4v1742897650621!5m2!1sen!2sin"
								loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
						</div>
					</div>
					<div class="col-lg-7">
						<form action="savecontact" method="post" class="">
							<input type="text" class="w-100 form-control border-0 py-3 mb-4"
								placeholder="Your Name" name="contactName"> <input type="email"
								class="w-100 form-control border-0 py-3 mb-4"
								placeholder="Enter Your Email" name="contactEmail">
							<textarea class="w-100 form-control border-0 mb-4" rows="5"
								cols="10" placeholder="Your Message" name="contactMessage"></textarea>
							<button
								class="w-100 btn form-control border-secondary py-3 bg-white text-primary "
								type="submit">Submit</button>
						</form>
					</div>
					<div class="col-lg-5">
						<div class="d-flex p-4 rounded mb-4 bg-white">
							<i class="fas fa-map-marker-alt fa-2x text-primary me-4"></i>
							<div>
								<h4>Address</h4>
								<p class="mb-2">Navarangpura, Ahmedabad</p>
							</div>
						</div>
						<div class="d-flex p-4 rounded mb-4 bg-white">
							<i class="fas fa-envelope fa-2x text-primary me-4"></i>
							<div>
								<h4>Mail Us</h4>
								<p class="mb-2">kk4766670@gmail.com</p>
							</div>
						</div>
						<div class="d-flex p-4 rounded bg-white">
							<i class="fa fa-phone-alt fa-2x text-primary me-4"></i>
							<div>
								<h4>Mobile</h4>
								<p class="mb-2">+91 8141103289</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->
	</body>
	</html>