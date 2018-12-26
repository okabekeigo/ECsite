package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	public String execute() throws SQLException{
		String result = SUCCESS;
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();

		itemListDeleteCompleteDAO.itemDelete();

		return result;
	}
}
