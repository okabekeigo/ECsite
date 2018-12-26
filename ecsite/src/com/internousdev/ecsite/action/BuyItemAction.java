package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemSelectDAO;
import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private int count;
	private String pay;
	private boolean buyItemFlg = false;
	private BuyItemSelectDAO buyItemSelectDAO = new BuyItemSelectDAO();

	public String execute() throws SQLException{
		String result = SUCCESS;
		session.put("count", count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount * intPrice);

		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
		}else{
			payment = "クレジットカード";
			session.put("pay", payment);
		}

		int choice = Integer.parseInt(session.get("choice").toString());
		BuyItemSelectDTO buyItemSelectDTO = buyItemSelectDAO.getBuyItemInfo(choice);
		String itemStock = buyItemSelectDTO.getItemStock();
		session.put("itemStock", itemStock);
		if(count <= Integer.parseInt(itemStock)){
			setBuyItemFlg(true);
		}

		int itemId = buyItemSelectDTO.getId();
		session.put("itemId", itemId);

		return result;
	}

	public void setCount(int count){
		this.count = count;
	}
	public void setPay(String pay){
		this.pay = pay;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public boolean getBuyItemFlg() {
		return buyItemFlg;
	}

	public void setBuyItemFlg(boolean buyItemFlg) {
		this.buyItemFlg = buyItemFlg;
	}

}
