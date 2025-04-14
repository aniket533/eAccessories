<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart</title>
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
		<h1 class="text-center text-white display-6">Cart</h1>
		<ol class="breadcrumb justify-content-center mb-0">
			<li class="breadcrumb-item"><a href="userhome">Home</a></li>
			<li class="breadcrumb-item"><a href="#">Pages</a></li>
			<li class="breadcrumb-item active text-white">Cart</li>
		</ol>
	</div>
	<!-- Single Page Header End -->

	<!-- Cart Page Start -->

	<div class="container-fluid py-5">
		<div class="container py-5">
			<div class="table-responsive">
				<table class="table">

					<tbody>
					<thead>
						<tr>
							<th scope="col">Products</th>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Total</th>
							<th scope="col">Handle</th>
						</tr>

					</thead>
					<c:forEach var="item" items="${cartItems}">
						<tr>
							<th scope="row">
								<div class="d-flex align-items-center">
									<img src="${item[5]}" class="img-fluid me-5 rounded-circle"
										style="width: 80px; height: 80px;" alt="">
								</div>
							</th>
							<td><p class="mb-0 mt-4">${item[1]}</p></td>
							<td><p class="mb-0 mt-4">&#8377; ${item[2]}</p></td>
							<td>
								<form action="update-cart-quantity" method="post">
									<input type="hidden" name="productId" value="${item[0]}" />
									<div class="input-group quantity mt-4" style="width: 100px;">
										<div class="input-group-btn">
											<button type="submit" name="quantity" value="${item[3]-1}"
												class="btn btn-sm btn-minus rounded-circle bg-light border">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="text"
											class="form-control form-control-sm text-center border-0"
											value="${item[3]}" readonly>
										<div class="input-group-btn">
											<button type="submit" name="quantity" value="${item[3]+1}"
												class="btn btn-sm btn-plus rounded-circle bg-light border">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</form>
							</td>

							<td><p class="mb-0 mt-4">&#8377; ${item[4]}</p></td>
							<td>
								<form action="remove-from-cart" method="post">
									<input type="hidden" name="productId" value="${item[0]}" />
									<button class="btn btn-md rounded-circle bg-light border mt-4">
										<i class="fa fa-times text-danger"></i>
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="mt-5">
				<input type="text"
					class="border-0 border-bottom rounded me-5 py-3 mb-4"
					placeholder="Coupon Code">
				<button
					class="btn border-secondary rounded-pill px-4 py-3 text-primary"
					type="button">Apply Coupon</button>
			</div>
			<div class="row g-4 justify-content-end">
				<div class="col-8"></div>
				<div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
					<div class="bg-light rounded">
						<div class="p-4">
							<h1 class="display-6 mb-4">
								Cart <span class="fw-normal">Total</span>
							</h1>
							<div class="d-flex justify-content-between mb-4">
								<h5 class="mb-0 me-4">Subtotal:</h5>
								<p class="mb-0">&#8377;${subtotal}</p>
								<!-- Subtotal -->
							</div>
							<div class="d-flex justify-content-between">
								<h5 class="mb-0 me-4">Shipping</h5>
								<div class="">
									<p class="mb-0">Flat rate:&#8377; 50.00</p>
								</div>
							</div>
							<p class="mb-0 text-end">Shipping to India.</p>
						</div>
						<div
							class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
							<h5 class="mb-0 ps-4 me-4">Total</h5>
							<!-- Grand total -->
						</div>
						<form id="checkoutForm" action="/cart/checkout" method="post">
							<button
								class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4"
								type="submit">Proceed Checkout</button>
						</form>


					</div>
				</div>
			</div>
			<c:if test="${not empty param.successAlert}">
				<div class="alert alert-success">${param.successAlert}</div>
			</c:if>

		</div>
	</div>
	<!-- Cart Page end -->

	<jsp:include page="UserFooter.jsp"></jsp:include>
	<jsp:include page="UserJS.jsp"></jsp:include>


</body>
</html>