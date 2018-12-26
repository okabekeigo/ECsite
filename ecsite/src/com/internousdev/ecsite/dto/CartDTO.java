package com.internousdev.ecsite.dto;

public class CartDTO {

	private int cartRow;
	private String itemId;
	private String itemName;
	private String totalPrice;
	private String totalCount;

	public int getCartRow() {
		return cartRow;
	}

	public void setCartRow(int cartRow) {
		this.cartRow = cartRow;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
}
