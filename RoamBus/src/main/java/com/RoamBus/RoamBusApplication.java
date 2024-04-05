package com.RoamBus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		servers = {
				@Server(url = "/", description = "RoamBus Server URL")
		}
)
@SpringBootApplication
public class RoamBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoamBusApplication.class, args);
	}

}
