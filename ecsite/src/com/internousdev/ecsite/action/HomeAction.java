package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute() throws SQLException{
		String result = "login";
		if(session.containsKey("id")){
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		session.remove("login_result");

//		System.out.println(buyItemDTOList);
//		System.out.println("test4");

		return result;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
