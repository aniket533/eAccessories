package com.grownited.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	// mail service
	@Autowired
	MailService serviceMail;

	@Autowired
	UserRepository repoUser; // object of UserRepository interface

	// creating object of PasswordEncoder to encrypt the password.
	@Autowired
	PasswordEncoder encoder; // use this object in below method

	@Autowired
	Cloudinary cloudinary;

	@Autowired
	CartRepository repoCart;

	@GetMapping(value = { "/", "signup" })
	public String signup() {
		return "Signup";
	}

	@GetMapping("login") // url
	public String login() { // method
		return "Login"; // return jsp name
	}

	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity, MultipartFile profilePic, Model model) {

		// read
//		System.out.println(userEntity.getFirstName());
//		System.out.println(userEntity.getLastName());
//		System.out.println(userEntity.getEmail());
//		System.out.println(userEntity.getPassword());
//		System.out.println(userEntity.getGender());

		System.out.println(profilePic.getOriginalFilename()); // file name

		if (profilePic.getOriginalFilename().endsWith(".jpg") || profilePic.getOriginalFilename().endsWith(".png")
				|| profilePic.getOriginalFilename().endsWith(".jpeg")) {

			try {

				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				userEntity.setProfilePicPath(result.get("url").toString());

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} else {

			model.addAttribute("error", "Not valid type of Profile Pic");
			return "Signup";
		}

		String encPassword = encoder.encode(userEntity.getPassword());

		userEntity.setPassword(encPassword);

		userEntity.setRole("USER"); // default value of role
		userEntity.setCreatedAt(new Date()); // date value
		userEntity.setActive(true);
		repoUser.save(userEntity); // insert query

		// send mail
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());

		return "Login";// jsp
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) { // Model is passed to
																									// print message on
																									// page in case of
																									// invalid
																									// credentials

		// validate
//		System.out.println(email);
//		System.out.println(password);

		// user -> email, password
		Optional<UserEntity> op = repoUser.findByEmail(email); // findByEmail has been created in UserRepository
		// select * from users where email= :email and password= :password

		if (op.isPresent()) {
			// true
			// email

			UserEntity dbUser = op.get(); // if there will be valid email then users table will get copied in dbUser

			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {

				// session -> user set
				session.setAttribute("user", dbUser);

				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard"; // will go to admin controller

				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/userhome";

				} else {

					model.addAttribute("error", "Please contact Admin with Error Code #0991");

				}

			}

		}

		model.addAttribute("error", "Invalid Credentials");
		return "Login";
	}

	// open forgetpassword jsp
	@GetMapping("forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";// jsp
	}

	// submit on forgetpassword ->
	@PostMapping("sendotp")
	public String sendOtp(String email, Model model) {
		// email valid
		Optional<UserEntity> op = repoUser.findByEmail(email);
		if (op.isEmpty()) {
			// email Invalid
			model.addAttribute("error", "Email not found");
			return "ForgotPassword";
		} else {
			// email valid
			// send mail otp
			// otp generate
			// send mail otp
			String otp = "";
			otp = (int) (Math.random() * 100000) + "";

			UserEntity user = op.get();
			user.setOtp(otp);
			repoUser.save(user); // update otp for user
			serviceMail.sendOtpForForgotPassword(email, user.getFirstName(), otp);

			return "ChangePassword";
		}

	}

	@PostMapping("updatepassword")
	public String updatePassword(String email, String password, String otp, Model model) {
		Optional<UserEntity> op = repoUser.findByEmail(email);

		if (op.isEmpty()) {
			model.addAttribute("error", "Invalid Data");
			return "ChangePassword";
		} else {
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) {
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repoUser.save(user); // update
			} else {
				model.addAttribute("error", "Invalid Data");
				return "ChangePassword";
			}
		}

		model.addAttribute("msg", "Password updated");
		return "Login";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:login";
	}

	@GetMapping("profile")
	public String showProfile(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		if (user == null) {
			return "redirect:/login"; // Redirect to login if user is not logged in
		}

		model.addAttribute("user", user);
		return "Profile"; // JSP page name

	}

	@PostMapping("updateprofile")
	public String updateProfile(@ModelAttribute UserEntity userEntity, MultipartFile profilePic,
			RedirectAttributes redirectAttributes, HttpSession session) {

		Optional<UserEntity> op = repoUser.findById(userEntity.getUserId());

		if (op.isPresent()) {
			UserEntity dbUsers = op.get();
			dbUsers.setFirstName(userEntity.getFirstName());
			dbUsers.setLastName(userEntity.getLastName());
			dbUsers.setEmail(userEntity.getEmail());
			dbUsers.setContactNum(userEntity.getContactNum());
			dbUsers.setGender(userEntity.getGender());

			if (profilePic != null && !profilePic.isEmpty()) {
				String fileName = profilePic.getOriginalFilename().toLowerCase();
				if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg")) {
					try {
						Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
						dbUsers.setProfilePicPath(result.get("url").toString());
					} catch (IOException e) {
						redirectAttributes.addFlashAttribute("error", "Image upload failed!");
						return "redirect:/profile";
						// e.printStackTrace();
					}
				}
			}

			repoUser.save(dbUsers);
			session.setAttribute("user", dbUsers);
			redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
		} else {
			redirectAttributes.addFlashAttribute("error", "User not found!");
		}
		return "redirect:/profile";
	}

}
