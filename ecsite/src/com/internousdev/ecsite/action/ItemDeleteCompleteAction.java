package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemDeleteCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport{

	private int itemChoice;
	private ItemDeleteCompleteDAO itemDeleteCompleteDAO = new ItemDeleteCompleteDAO();
	private BuyItemSelectDTO buyItemSelectDTO = new BuyItemSelectDTO();

	public String execute() throws SQLException{
		String result = SUCCESS;

		itemChoice--;
		buyItemSelectDTO = itemDeleteCompleteDAO.getBuyItemInfo(itemChoice);
		int itemId = buyItemSelectDTO.getId();

		itemDeleteCompleteDAO.oneItemDelete(itemId);

		System.out.println(itemChoice);
		System.out.println(itemId);

		return result;
	}

	public int getItemChoice() {
		return itemChoice;
	}

	public void setItemChoice(int itemChoice) {
		this.itemChoice = itemChoice;
	}
}
