package com.khube.spring.security.main.config;

public class OpenAPIConfig {
/*
	@Value("${khube.openapi.dev-url}")
	private String devUrl;

	@Value("${khube.openapi.prod-url}")
	private String prodUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development environment");

		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL in Production environment");

		Contact contact = new Contact();
		contact.setEmail("info.khube@gmail.com");
		contact.setName("Khube");
		contact.setUrl("https://google.com");

		License mitLicense = new License()
				.name("MIT License")
				.url("https://choosealicense.com/licenses/mit/");

		Info info = new Info()
				.title("Spring Security Service Old API")
				.version("1.0")
				.contact(contact)
				.description("This API exposes endpoints to manage Spring Security Old.")
				.termsOfService("https://www.google.com/")
				.license(mitLicense);

		return new OpenAPI()
				.info(info)
				.servers(List.of(devServer, prodServer));
	}
	*/
}
