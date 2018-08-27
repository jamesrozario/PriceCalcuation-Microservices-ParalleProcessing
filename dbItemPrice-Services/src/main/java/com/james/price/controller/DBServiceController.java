package com.james.price.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.price.model.Item;
import com.james.price.repository.DBRepository;
/**
 * This controller provide the below functionality
 * setup the Item- price in Database
 * Provide the item price for selected itemid from database 
 * Delete the selected Item from system
 * @author james
 *
 */
@RestController
@RequestMapping("/rest/db")
public class DBServiceController {

	private static final Logger log = LoggerFactory.getLogger(DBServiceController.class);
	
	private DBRepository dbRepository;
	public DBServiceController(DBRepository dbRepository)
	{
		this.dbRepository=dbRepository;
	}
	
	@GetMapping("/{itemId}")
	public String getItemPrice(@PathVariable("itemId") Integer itemId)
	{
		log.info("In  getItemPrice call for itemid :"+ itemId);
		return dbRepository.getOne(itemId).getItemPrice();
	}
	@GetMapping("/items")
	public List<Item>getItems()
	{
		
		List<Item> itemList = dbRepository.findAll();
		
		return itemList;
	}
	@PostMapping("/add")
	public List <Item> setItem(@RequestBody List <Item> items)
	{
		log.info("In  setItem call for itemid :"+ items);
		if( null!=items)
		{
			items.parallelStream().forEach(n->dbRepository.save(n));
		}
		log.info("In setItem after pesisting the data");
		return getItems();
	
	}
	@DeleteMapping("/{itemId}")
	public void deleteItem(@PathVariable("itemId") Integer itemId)
	{
		log.info("In  deleteItem call for itemid :"+ itemId);
		dbRepository.deleteById(itemId);
	}
}
