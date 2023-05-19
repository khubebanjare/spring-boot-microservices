package com.khube.spring.security.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/api")
public class ProcessController {

	@GetMapping(value = "/processes")
	public String getProcess() {
		return "Please wait while prcessing your request................";
	}
}
