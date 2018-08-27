package com.james.price.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Config Class for Rest template
 */
@Configuration
public class RestTempletConfig {
	
	/**
	 * this method is to give the RestTemplet for microservices
	 * It is configure for client side load balancing 
	 * @return RestTemplate
	 */
@LoadBalanced
@Bean
public RestTemplate restTamplate() {
	return  new RestTemplate();
  }
}
