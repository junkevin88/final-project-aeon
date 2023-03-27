package com.aeon.finpro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/api", description = "Default Server URL")})
public class FinproApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinproApplication.class, args);
	}
}
