package com.james.price.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is the controller class that process the Rest calls and provide the total price in bag.
 */
@RestController
@RequestMapping("/rest/price")
public class PriceController {
	
	private static final Logger log = LoggerFactory.getLogger(PriceController.class);
	
	@Autowired
    RestTemplate restTemplate;
	
	/**
	 * This method is to calculate the price for given item list.
	 * @param productIds
	 * @return
	 */
	@GetMapping("/calcualtePrice")
	public String  getPrice(@RequestParam(value = "productIds") List<String> productIds) 
	{
		Double calcuatedPrice = 0.0;
		log.info("Product List"+productIds);
		 if (productIds.isEmpty()) {
	         
	            throw new IllegalArgumentException("pathparam 'productIds' should not be empty or null");
	        }
		 /* use parallel stream to fetch the item prices in parallel to improve the performance*/
		 Long  startTime = System.currentTimeMillis();
		 calcuatedPrice = productIds.parallelStream().map(this::getItemPrice).reduce((Double) 0.0,this::sumPrice);
		 log.info("Price calcuation completed in "+ (System.currentTimeMillis() -startTime));
		 return calcuatedPrice.toString();
		
	}
	
	private Double getItemPrice(String itemId)
	{
		/* Call the Service Registry endpoint to pull the item price.*/
		log.info("Price Cal from dbItemPrice-Services for Itemid" +itemId);
		ResponseEntity<String> quoteResponse = restTemplate.exchange("http://dbItemPrice-Services/rest/db/" +itemId, HttpMethod.GET,
                null, new ParameterizedTypeReference<String>() {
                });

		String itemPrice = quoteResponse.getBody();
        log.info("Price Cal from dbItemPrice-Services for Itemid" +itemId+" is "+ itemPrice);
        if(null!=itemPrice)
        {
        	return Double.valueOf(itemPrice);
        }
        else return 0.0;

	}
	/**
	 * This method is to sum the item prices. You can implement the other logic as well like add the tax or apply the coupon
	 * @param a
	 * @param b
	 * @return
	 */
	private Double sumPrice(Double a, Double b)
	{
		return (double)(a+b);
	}

}
