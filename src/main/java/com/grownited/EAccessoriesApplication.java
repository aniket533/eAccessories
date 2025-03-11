package com.grownited;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

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
	
	@Bean
	Cloudinary cloudinary() {
		Map<String, String> config = ObjectUtils.asMap("cloud_name", "du6wdc6hr", "api_key", "382653425618882", "api_secret", "sz0orYCpAz5jz1i91MoLjeR8cpg");
		
		return new Cloudinary(config);
	}

}
