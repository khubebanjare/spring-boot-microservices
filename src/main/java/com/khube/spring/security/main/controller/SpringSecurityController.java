package com.khube.spring.security.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auth/api")
@RestController
public class SpringSecurityController {

	@GetMapping(value = "/string")
	public String getString() {
		return "get string constant pool object";
	}
}














//@Operation(
//	      summary = "Retrun String object",
//	      description = "Get a String object by getting their string.",
//	      tags = { "string", "get" })
//	  @ApiResponses(@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class))}))
//@Tag(name = "Spring Security", description = "Spring Security Implementation in Old Way")
