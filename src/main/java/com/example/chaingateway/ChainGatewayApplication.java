package com.example.chaingateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ChainGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChainGatewayApplication.class, args);
	}

}
