package com.vivekchutke.microservices.gradlecurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.vivekchutke.microservices.gradlecurrencyconversionservice")
public class GradlecurrencyconversionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradlecurrencyconversionserviceApplication.class, args);
	}

}
