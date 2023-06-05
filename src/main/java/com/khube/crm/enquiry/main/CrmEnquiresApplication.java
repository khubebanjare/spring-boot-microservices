package com.khube.crm.enquiry.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CrmEnquiresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmEnquiresApplication.class, args);
	}

}
