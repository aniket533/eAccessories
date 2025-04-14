<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
<jsp:include page="UserCss.jsp" /> 
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	integrity="sha512-yZk9E4Pfu5A7R9sFkMJfG8Cm6bZxTfnh3ZFd+bTDcT6hRjN4Un0YlO/IKUSnKY2c9ZlHcmtA07o+gyA4ht9RgA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background: #f3f4f6;
}

.checkout-container {
	max-width: 1000px;
	margin: 100px auto;
	background: white;
	border-radius: 12px;
	padding: 2rem;
	box-shadow: 0 8px 30px rgba(0, 0, 0, 0.1);
}

.checkout-container h2 {
	text-align: center;
	font-weight: 600;
	color: #333;
	margin-bottom: 30px;
}

.form-section {
	display: flex;
	flex-wrap: wrap;
	gap: 2rem;
}

.form-left, .form-right {
	flex: 1 1 48%;
	min-width: 300px;
}

.form-group {
	margin-bottom: 1rem;
}

.form-group label {
	display: block;
	font-weight: 500;
	margin-bottom: 6px;
	color: #444;
}

.form-group input, .form-group textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 1rem;
}

.form-group textarea {
	resize: vertical;
}

.form-group small {
	color: red;
}

.credit-card-preview {
	background: linear-gradient(135deg, #2c3e50, #4ca1af);
	color: white;
	padding: 20px;
	border-radius: 12px;
	box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
	font-family: monospace;
	margin-bottom: 1.5rem;
}

.credit-card-preview .card-number {
	font-size: 1.3rem;
	letter-spacing: 2px;
}

.credit-card-preview .card-info {
	display: flex;
	justify-content: space-between;
	font-size: 0.9rem;
}

.credit-card-preview .card-brands {
	text-align: right;
	margin-top: 1rem;
}

.card-brands i {
	margin-left: 10px;
	transition: transform 0.3s ease;
}

.card-brands i:hover {
	transform: scale(1.1);
}

.submit-btn {
	margin-top: 2rem;
	background: #007bff;
	border: none;
	padding: 14px;
	color: white;
	font-size: 1.1rem;
	width: 100%;
	border-radius: 8px;
	transition: background 0.3s ease;
}

.submit-btn:hover {
	background: #0056b3;
}

.btn {
	padding: 10px 20px;
	border-radius: 5px;
	font-weight: 600;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 1rem;
	transition: background 0.3s;
	cursor: pointer;
}

.btn-primary {
	background-color: #007bff;
	color: #fff;
	border: none;
}

.btn-primary:hover {
	background-color: #0056b3;
}

.btn-outline-secondary {
	background-color: transparent;
	color: #6c757d;
	border: 1px solid #6c757d;
}

.btn-outline-secondary:hover {
	background-color: #6c757d;
	color: #fff;
}

@media ( max-width : 768px) {
	.form-section {
		flex-direction: column;
	}
}
</style>
</head>
<body>

	<div class="checkout-container">
		<h2>Checkout</h2>

		<form id="paymentForm" action="/checkout/payment" method="post"
			onsubmit="return validateForm()">
			<input type="hidden" name="amount" value="${finalTotal}" />

			<div class="form-section">

				<!-- Left: Shipping Details -->
				<div class="form-left">
					<h4>Shipping Information</h4>

					<div class="form-group">
						<label for="fullName">Full Name</label> <input type="text"
							name="name" id="fullName" value="${sessionScope.user.firstName}"
							required />
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="email" name="email"
							id="email" value="${sessionScope.user.email}" required readonly />
					</div>

					<div class="form-group">
						<label for="address">Address</label>
						<textarea name="address" id="address" rows="3" required></textarea>
					</div>

					<div class="form-group">
						<label for="state">State</label> <input type="text" name="state"
							id="state" required />
					</div>

					<div class="form-group">
						<label for="city">City</label> <input type="text" name="city"
							id="city" required />
					</div>

					<div class="form-group">
						<label for="postalCode">Postal Code</label> <input type="text"
							name="postalCode" id="postalCode" required />
					</div>
				</div>

				<!-- Right: Payment Preview + Details -->
				<div class="form-right">
					<h4>Payment Information</h4>

					<div class="credit-card-preview">
						<div class="card-number" id="previewCardNumber">•••• ••••
							•••• ••••</div>
						<div class="card-info">
							<span id="previewName">FULL NAME</span> <span id="previewExp">MM/YY</span>
						</div>
						<div class="card-brands">
							<i class="fab fa-cc-visa fa-2x"></i> <i
								class="fab fa-cc-mastercard fa-2x"></i>
						</div>
					</div>

					<div class="form-group">
						<label for="cardNumber">Card Number</label> <input type="text"
							id="cardNumber" name="cardNumber"
							placeholder="1234 5678 9012 3456" required /> <small
							id="cardNumberError"></small>
					</div>

					<div class="form-group">
						<label for="expDate">Expiration Date (MM/YY)</label> <input
							type="text" id="expDate" name="expDate" placeholder="MM/YY"
							required /> <small id="expDateError"></small>
					</div>

					<div class="form-group">
						<label for="cvv">CVV</label> <input type="text" id="cvv"
							name="cvv" placeholder="123" required /> <small id="cvvError"></small>
					</div>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-4">
				<a href="/cart" class="btn btn-outline-secondary">Cancel</a>
				<button type="submit" class="btn btn-primary">Pay
					₹${finalTotal}</button>
			</div>

		</form>
	</div>

	<script>
		function validateForm() {
			let isValid = true;

			document.getElementById('cardNumberError').textContent = '';
			document.getElementById('expDateError').textContent = '';
			document.getElementById('cvvError').textContent = '';

			const cardNumber = document.getElementById('cardNumber').value
					.replace(/\s+/g, '');
			const expDate = document.getElementById('expDate').value;
			const cvv = document.getElementById('cvv').value;

			const cardNumberPattern = /^\d{16}$/;
			const expDatePattern = /^(0[1-9]|1[0-2])\/\d{2}$/;
			const cvvPattern = /^\d{3}$/;

			if (!cardNumberPattern.test(cardNumber)) {
				document.getElementById('cardNumberError').textContent = 'Enter valid 16-digit card number.';
				isValid = false;
			}

			if (!expDatePattern.test(expDate)) {
				document.getElementById('expDateError').textContent = 'Use MM/YY format.';
				isValid = false;
			}

			if (!cvvPattern.test(cvv)) {
				document.getElementById('cvvError').textContent = 'Enter valid 3-digit CVV.';
				isValid = false;
			}

			return isValid;
		}

		// Live Preview
		document
				.getElementById('cardNumber')
				.addEventListener(
						'input',
						function() {
							const raw = this.value.replace(/\D/g, '')
									.substring(0, 16);
							const formatted = raw.replace(/(.{4})/g, '$1 ')
									.trim();
							document.getElementById('previewCardNumber').textContent = formatted
									|| '•••• •••• •••• ••••';
						});

		document
				.getElementById('fullName')
				.addEventListener(
						'input',
						function() {
							document.getElementById('previewName').textContent = this.value
									.toUpperCase()
									|| 'FULL NAME';
						});

		document
				.getElementById('expDate')
				.addEventListener(
						'input',
						function() {
							document.getElementById('previewExp').textContent = this.value
									|| 'MM/YY';
						});
	</script>

</body>
</html>