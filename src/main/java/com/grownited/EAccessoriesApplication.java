package com.grownited;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EAccessoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAccessoriesApplication.class, args);
	}
	
	
	// encoder singleton using parent class with BCryptPasswordEEncoder(strength)
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(5);
	}

}
