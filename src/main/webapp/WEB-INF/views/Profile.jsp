
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>eAccessories | Profile</title>
<!-- Head meta & css Start -->
<jsp:include page="UserCss.jsp"></jsp:include>
<!-- Head meta & css End -->
</head>

<body>

	<!-- Spinner Start -->
	<div id="spinner" class="w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->
	
	<jsp:include page="UserHeader.jsp"></jsp:include>


	<!-- Profile Section Start -->
	<main id="main" class="main">
		<section class="section">
			<div
				class="container d-flex justify-content-center align-items-center ">
				<div class="profile-container text-center">

					<!-- Success and Error Messages -->
					<%
					if (request.getAttribute("success") != null) {
					%>
					<div class="alert alert-success">
						<%=request.getAttribute("success")%>
					</div>
					<%
					}
					%>

					<%
					if (request.getAttribute("error") != null) {
					%>
					<div class="alert alert-danger">
						<%=request.getAttribute("error")%>
					</div>
					<%
					}
					%>

					<!-- Profile Image -->
					<img src="${user.profilePicPath}" class="profile-img"
						alt="Profile Image">

					<!-- Profile Update Form -->
					<form class="row g-3 needs-validation" action="updateprofile"
						method="post" enctype="multipart/form-data" novalidate>

						<input type="hidden" name="userId" value="${user.userId}">

						<!-- First Name -->
						<div class="col-12">
							<label for="firstName" class="form-label">First Name</label> <input
								type="text" name="firstName" value="${user.firstName}"
								class="form-control" id="firstName" required>
						</div>

						<!-- Last Name -->
						<div class="col-12">
							<label for="lastName" class="form-label">Last Name</label> <input
								type="text" name="lastName" value="${user.lastName}"
								class="form-control" id="lastName" required>
						</div>

						<!-- Email -->
						<div class="col-12">
							<label for="yourEmail" class="form-label">Your Email</label> <input
								type="email" name="email" value="${user.email}"
								class="form-control" id="yourEmail" required>
						</div>

						<!-- Gender -->
							<div class="col-12">
							    <label for="gender" class="form-label">Gender</label>
							    <select class="form-select" name="gender" id="gender">
							        <option value="male" ${user.gender == 'male' ? 'selected' : ''}>Male</option>
							        <option value="female" ${user.gender == 'female' ? 'selected' : ''}>Female</option>
							    </select>
							</div>
							
						<!-- <div class="col-12">
							<label for="gender" class="form-label">Gender</label>
							<div class="d-flex justify-content-center">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" value="male"
										name="gender" id="gender-male"
										${user.gender == 'male' ? 'checked' : ''}> <label
										class="form-check-label" for="gender-male">Male</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" value="female"
										name="gender" id="gender-female"
										${user.gender == 'female' ? 'checked' : ''}> <label
										class="form-check-label" for="gender-female">Female</label>
								</div>
							</div>
						</div> -->

						<!-- Contact Number -->
						<div class="col-12">
							<label for="contactNum" class="form-label">Contact Number</label>
							<input type="tel" class="form-control" name="contactNum"
								value="${user.contactNum}" required>
						</div>

						<!-- Upload Profile Image -->
						<div class="col-12">
							<label for="profilePic" class="form-label">Upload New
								Profile Picture</label> <input type="file" class="form-control"
								name="profilePic">
						</div>

						<!-- Submit Button -->
						<div class="col-12">
							<button class="btn btn-primary w-100" type="submit">Update
								Profile</button>
						</div>
					</form>

				</div>
			</div>
		</section>
	</main>
	<!-- Profile Section End -->

	<jsp:include page="UserFooter.jsp"></jsp:include>
	<jsp:include page="UserJS.jsp"></jsp:include>
</body>

</html>
