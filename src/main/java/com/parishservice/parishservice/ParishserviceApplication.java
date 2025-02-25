package com.parishservice.parishservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@OpenAPIDefinition(
		info = @Info(
				title = "Parish Service Rest APIS Documentation",
				description = "Parish Service Rest Apis it is part the myKcc microservice",
				version = "3.3.1",
				contact = @Contact(
						name = "myKcc-Project",
						email = "kamarelngunda@gmail.com",
						url = "www.myKcc.com"
				),
				license = @License(
						name = "Apache 3.0",
						url = "www.myKcc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Parish-Service-docs",
				url = "http://www.myKcc.com"
		)
)




@SpringBootApplication
public class ParishserviceApplication {

	@Autowired
	Environment environment;


	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ParishserviceApplication.class, args);
	}

	@Configuration
	public static class Myconfiguration {
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
				}
			};
		}

	}
}
