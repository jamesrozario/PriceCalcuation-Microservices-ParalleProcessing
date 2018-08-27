package com.james.price.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * This is the Item entity class
 * @author james
 *
 */
@Entity
public class Item  {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemID;
	private String  itemPrice;
	private String itemName;
	
	public Integer getItemID() {
		return itemID;
	}
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Item ()
	{
	}
	public Item(String itemName,String itemPrice)
	{
		this.itemName =itemName;
		this.itemPrice = itemPrice;
	}

}
