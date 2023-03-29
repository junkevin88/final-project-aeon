package com.aeon.finpro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "3.0", description = "This API is for final project AEON Backend Developer"))
public class FinproApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinproApplication.class, args);
	}
}
