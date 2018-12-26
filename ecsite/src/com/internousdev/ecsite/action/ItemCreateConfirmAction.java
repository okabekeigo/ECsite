package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String createItemName;
	private String createItemPrice;
	private String createItemStock;
	public Map<String, Object> session;
	private String itemErrorMessage;

	public String execute(){
		String result = ERROR;
		if(!(createItemName.equals("")) && !(createItemPrice.equals("")) && !(createItemStock.equals(""))){
			session.put("createItemName", createItemName);
			session.put("createItemPrice", createItemPrice);
			session.put("createItemStock", createItemStock);
			result = SUCCESS;
		}else{
			setItemErrorMessage("未入力の項目があります。");
		}
		return result;
	}

//	public String getCreateItemName(){
//		return createItemName;
//	}
	public void setCreateItemName(String createItemName){
		this.createItemName = createItemName;
	}

//	public String getCreateItemPrice(){
//		return createItemPrice;
//	}
	public void setCreateItemPrice(String createItemPrice){
		this.createItemPrice = createItemPrice;
	}

//	public String getCreateItemStock(){
//		return createItemStock;
//	}
	public void setCreateItemStock(String createItemStock){
		this.createItemStock = createItemStock;
	}

	public String getItemErrorMessage(){
		return itemErrorMessage;
	}
	public void setItemErrorMessage(String itemErrorMessage){
		this.itemErrorMessage = itemErrorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
