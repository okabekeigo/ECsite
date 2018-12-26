package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private int count;
	private int id;
	private String itemName;
	private String itemPrice;
	private String itemStock;


	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock = itemStock;
	}
}
