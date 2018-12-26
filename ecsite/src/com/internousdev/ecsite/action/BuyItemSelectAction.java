package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemSelectDAO;
import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemSelectAction extends ActionSupport implements SessionAware{

	private int choice = 0;
	public Map<String, Object> session;

	public String execute()  throws SQLException{

		String result = ERROR;
		choice--;
		session.put("choice", choice);

		BuyItemSelectDAO buyItemSelectDAO = new BuyItemSelectDAO();
		BuyItemSelectDTO buyItemSelectDTO = buyItemSelectDAO.getBuyItemInfo(choice);

		if(choice >= 0){
			session.put("id", buyItemSelectDTO.getId());
			session.put("buyItem_name", buyItemSelectDTO.getItemName());
			session.put("buyItem_price", buyItemSelectDTO.getItemPrice());
			result = SUCCESS;
		}



		return result;
	}

	public void counter(int c){
		for(int i = 1; i <= c; i++){
			if(c == i){
				System.out.println(c);
			}
		}
	}

	public int getChoice(){
		return choice;
	}
	public void setChoice(int choice){
		this.choice = choice;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
