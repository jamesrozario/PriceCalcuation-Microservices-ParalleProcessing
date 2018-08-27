package com.james.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ItemPriceServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemPriceServicesApplication.class, args);
	}
}
