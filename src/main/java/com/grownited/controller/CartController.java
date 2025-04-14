package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grownited.dto.CartDto;
import com.grownited.entity.CartEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.AuthorizePaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private AuthorizePaymentService authorizePaymentService;

	@Autowired
	CartRepository repoCart;

	@Autowired
	ProductRepository repoProduct;

	@Autowired
	UserRepository repoUser;

	@GetMapping("cart")
	public String cart(Model model) {

		List<ProductEntity> allProduct = repoProduct.findAll();
		model.addAttribute("allProduct", allProduct);

		return "NewCart";
	}

	@SuppressWarnings("unused")
	@GetMapping("/listusercart")
	public String listUserCart(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}

		List<Object[]> cartItems = repoCart.getCartItemsByUser(user.getUserId());

		double subtotal = 0;
		for (Object[] item : cartItems) {
			subtotal += Double.parseDouble(item[4].toString()); // total_price
		}

		double shipping = 50.00;
		double grandTotal = subtotal + shipping;

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("grandTotal", grandTotal);
		session.setAttribute("grandTotal", grandTotal);

		if (user != null) {
			int count = repoCart.getCartCountByUserId(user.getUserId());
			model.addAttribute("cartCount", count);
		} else {
			model.addAttribute("cartCount", 0);
		}

		return "UserCart";
	}

	@PostMapping("/add-to-cart")
	public String addToCart(@RequestParam("productId") Integer productId, HttpSession session) {

		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
		if (userId == null) {
			return "redirect:/login"; // Or handle guest users
		}

		Optional<ProductEntity> productOpt = repoProduct.findById(productId);
		if (productOpt.isPresent()) {
			String quantity = "1"; // Default quantity (can be dynamic)
			repoCart.insertCartItem(userId, productId, quantity);
		}

		return "redirect:/listusercart";
	}

	@PostMapping("/update-cart-quantity")
	public String updateCartQuantity(@RequestParam("productId") Integer productId,
			@RequestParam("quantity") String quantity, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null) {
			repoCart.updateCartQuantity(user.getUserId(), productId, quantity);
		}
		return "redirect:/listusercart";
	}

	@PostMapping("/remove-from-cart")
	public String removeFromCart(@RequestParam("productId") Integer productId, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null) {
			repoCart.deleteCartItem(user.getUserId(), productId);
		}
		return "redirect:/listusercart";
	}

	@PostMapping("savecart")
	public String saveCart(CartEntity cartEntity, HttpSession session) {

		UserEntity user = (UserEntity) session.getAttribute("user"); // this always return as object, that's why we have
																		// to typecast into UserEntity.
		Integer UserId = user.getUserId();
		cartEntity.setUserId(UserId);

		repoCart.save(cartEntity);

		return "redirect:/adminlistcart";
	}

	@GetMapping("adminlistcart")
	public String listCart(Model model) {

		List<CartDto> cartList = repoCart.getAll(); // select * query

		model.addAttribute("cartList", cartList);

		return "ListCart";
	}

	@GetMapping("viewcart")
	public String viewCart(Integer cartId, Model model) {

		// ?
		Optional<CartEntity> op = repoCart.findById(cartId);

		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			CartEntity cart = op.get();

			// send data to jasp
			model.addAttribute("cart", cart);
		}

		return "ViewCart";
	}

	@GetMapping("deletecart")
	public String deleteCart(Integer cartId) {

		repoCart.deleteById(cartId); // delete from cart where cartID = :cartId

		return "redirect:/listcart";
	}

	@GetMapping("editcart")
	public String editCart(Integer cartId, Model model) {

		Optional<CartEntity> op = repoCart.findById(cartId);
		System.out.println(op.toString());
		if (op.isEmpty()) {
			return "redirect:/listcart";
		} else {
			model.addAttribute("cart", op.get());
			return "EditCart";
		}

	}

	// GET mapping for displaying the checkout page
	@PostMapping("/cart/checkout")
	public String checkoutPage(HttpSession session, Model model, RedirectAttributes redirectAttributes) {

		// Ensure the user is logged in
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			redirectAttributes.addFlashAttribute("message", "Please log in to proceed with checkout.");
			return "redirect:/login"; // Redirect to login if not logged in
		}

		Integer userId = user.getUserId();
		// Fetch cart items for the user
		List<CartEntity> cartItems = repoCart.findByUserId(userId);

		if (cartItems == null || cartItems.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Your cart is empty!");
			return "redirect:/listusercart";
		}

		// Calculate the subtotal from the cart items (before any discount)
		double subtotal = 0.0;
		for (CartEntity cartItem : cartItems) {
			Optional<ProductEntity> productOpt = repoProduct.findById(cartItem.getProductId());
			if (productOpt.isPresent()) {
				ProductEntity product = productOpt.get();
				String priceStr = product.getOfferPrice(); // get the price as a String
				Double offerPrice = Double.parseDouble(priceStr); // convert to Double
				String q = cartItem.getQuantity(); // get the price as a String
				Double quantity = Double.parseDouble(q); // convert to Double
				subtotal += offerPrice * quantity;
			}
		}

		double shipping = 50.00;
		double finalTotal = subtotal + shipping;

		// Add subtotal and cart items to the model for display
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("shipping", shipping);
		model.addAttribute("finalTotal", finalTotal);
		// Save final total in session (optional)
		session.setAttribute("finalTotal", finalTotal);

		return "Checkout"; // Return the view name for the checkout page
	}

	// Checkout payment
	@PostMapping("/checkout/payment")
	public String checkout(@RequestParam Double amount, @RequestParam("cardNumber") String cardNumber,
			@RequestParam("expDate") String expDate, @RequestParam("cvv") String cvv, HttpSession session,
			RedirectAttributes redirectAttributes) {

		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null)
			return "redirect:/login";

		Integer userId = user.getUserId();
		List<CartEntity> cartItems = repoCart.findByUserId(userId);

		if (cartItems.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", " Cart is empty!");
			return "redirect:/listusercart";
		}

		if (amount == null || amount <= 0) {
			amount = 0.0; // Set a valid default amount if necessary
		}

		// Use user's email (assuming it's stored in UserEntity)
		String email = user.getEmail();
		System.out.println(email);
		// Call Authorize.Net payment service
		String transactionId = authorizePaymentService.run(amount, cardNumber, cvv, expDate, email);
		System.out.println("transactionId is " + transactionId);

		if (transactionId.startsWith("Error:")) {
			redirectAttributes.addFlashAttribute("message", " Payment  failed: " + transactionId);
			System.out.println("Redirect when error ");
			return "redirect:/listusercart";
		}

		// Save order logic here (optional)

		// repoOrder.save(order);

		// Clear cart after successful payment
		repoCart.deleteAll(cartItems);

		redirectAttributes.addAttribute("successAlert", "Order placed successfully! Transaction ID: " + transactionId);
		return "redirect:/listusercart";

	}
}
