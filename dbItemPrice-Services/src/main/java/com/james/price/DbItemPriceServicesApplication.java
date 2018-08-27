package com.james.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.james.price.repository")
@SpringBootApplication
public class DbItemPriceServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbItemPriceServicesApplication.class, args);
	}
}
