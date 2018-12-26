package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemArrivalNumberDAO;
import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemArrivalNumberAction extends ActionSupport implements SessionAware{

	private int choice = 0;
	public Map<String, Object> session;

	public String execute()  throws SQLException{

		String result = ERROR;
		choice--;
		session.put("choice_2", choice);

		ItemArrivalNumberDAO itemArrivalNumberDAO = new ItemArrivalNumberDAO();
		BuyItemSelectDTO buyItemSelectDTO = itemArrivalNumberDAO.getBuyItemInfo(choice);

		if(choice >= 0){
			session.put("id_2", buyItemSelectDTO.getId());
			session.put("buyItem_name_2", buyItemSelectDTO.getItemName());
			session.put("buyItem_price_2", buyItemSelectDTO.getItemPrice());
			session.put("buyItem_stock_2", buyItemSelectDTO.getItemStock());
			result = SUCCESS;
		}

		int itemId = buyItemSelectDTO.getId();
		session.put("itemId_2", itemId);

		return result;
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
