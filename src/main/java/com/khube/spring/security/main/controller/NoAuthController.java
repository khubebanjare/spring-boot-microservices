package com.khube.spring.security.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/noAuth/api")
@RestController
public class NoAuthController {

	@GetMapping("/hi")
	public String getHi() {
		return "Hii No Security";
	}
}
