package com.grownited.filter;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.grownited.entity.UserEntity;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckFilter implements Filter {

	ArrayList<String> publicURL = new ArrayList<>();
	
	public LoginCheckFilter() {
 		publicURL.add("/login");
 		publicURL.add("/signup");
 		publicURL.add("/saveuser");
 		publicURL.add("/forgotpassword");
 		publicURL.add("/sendotp");
 		publicURL.add("/authenticate");
 		publicURL.add("/logout");
 		publicURL.add("/home");
 		publicURL.add("/updatepassword");
 
 	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		
		System.out.println("Filter Call...." + uri);
		
		
		if(publicURL.contains(uri) || uri.contains(".css") || uri.contains(".js") || uri.contains("assets") || uri.contains("img")) {
			chain.doFilter(request, response); // go ahead
		} else {
			HttpSession session = req.getSession();
			UserEntity user = (UserEntity)session.getAttribute("user");
			
			if(user == null) {
				req.getRequestDispatcher("login").forward(request, response);
			} else {
					// already login
					// check url? amdin user
	
					// admin?
					if (uri.startsWith("/admin")) {
						if (user.getRole().equals("ADMIN")) {
							chain.doFilter(request, response);// go Ahead
						}else {
							req.getRequestDispatcher("login").forward(request, response);
						}
					} else {
						chain.doFilter(request, response);// go Ahead
					}
					// user role admin ? 
			}//go ahead
		}
	}
}
