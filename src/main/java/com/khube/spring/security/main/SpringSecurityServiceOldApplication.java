package com.khube.spring.security.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityServiceOldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityServiceOldApplication.class, args);
	}

}
