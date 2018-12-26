package com.internousdev.ecsite.action;

import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemArrivalDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemArrivalAction extends ActionSupport{

	private ItemArrivalDAO itemArrivalDAO = new ItemArrivalDAO();
	private ArrayList<BuyItemDTO> itemArrivalDTOList = new ArrayList<BuyItemDTO>();

	public String execute(){
		String result = SUCCESS;

		setItemArrivalDTOList(itemArrivalDAO.getBuyItemInfo());

		return result;
	}

	public ArrayList<BuyItemDTO> getItemArrivalDTOList() {
		return itemArrivalDTOList;
	}

	public void setItemArrivalDTOList(ArrayList<BuyItemDTO> itemArrivalDTOList) {
		this.itemArrivalDTOList = itemArrivalDTOList;
	}
}
