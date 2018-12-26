package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CartConfirmAction extends ActionSupport implements SessionAware{

	private String pay;
	private Map<String, Object> session;

	public String execute(){
		String result = SUCCESS;

		if(pay.equals("1")){
			session.put("pay", "現金払い");
		}else if(pay.equals("2")){
			session.put("pay", "クレジットカード");
		}

		return result;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
