package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> itemListList = new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{
		String result = SUCCESS;
//		int i = 1;
//		while(i <= itemListDAO.countItem()){
			itemListList = itemListDAO.getItemList();
//		}
		return result;
	}

	public ArrayList<ItemListDTO> getItemListList(){
		return itemListList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
