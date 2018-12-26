package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private BuyItemConfirmDAO buyItemConfirmDAO = new BuyItemConfirmDAO();

	public String execute() throws SQLException{
		String result = ERROR;



		buyItemConfirmDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

		int itemStock = Integer.parseInt(session.get("itemStock").toString());
		int count = Integer.parseInt(session.get("count").toString());
		int updateItemStock = itemStock - count;
		int itemId = Integer.parseInt(session.get("itemId").toString());
		buyItemConfirmDAO.updateItemInfo(updateItemStock, itemId);

		if(session.containsKey("login_user_id")){
			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
