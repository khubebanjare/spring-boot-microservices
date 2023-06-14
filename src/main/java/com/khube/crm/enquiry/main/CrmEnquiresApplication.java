package com.khube.crm.enquiry.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "CRMEnquiry Api", 
		version = "1.0", 
		description = "CRMEnquiry MicroService Spring Boot Application",
		contact = @Contact (
				email = "info.khube@gmail.com",
				name = "MICROGRAPS",
				url = "http://localhost:8088/crmenquiry-service"
				)))
public class CrmEnquiresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmEnquiresApplication.class, args);
	}

}
