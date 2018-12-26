package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemArrivalCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemArrivalCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private int arrivalNumber;
	private ItemArrivalCompleteDAO itemArrivalCompleteDAO = new ItemArrivalCompleteDAO();

	public String execute() throws SQLException{
		String result = SUCCESS;

		int itemStock = Integer.parseInt(session.get("buyItem_stock_2").toString());
		int itemStockSum = itemStock + arrivalNumber;
		int itemId = Integer.parseInt(session.get("itemId_2").toString());
		itemArrivalCompleteDAO.itemStockUpdate(itemStockSum, itemId);

//		System.out.println(itemStock);
//		System.out.println(arrivalNumber);
//		System.out.println(itemStockSum);
//		System.out.println(itemId);

		return result;
	}

	public int getArrivalNumber() {
		return arrivalNumber;
	}

	public void setArrivalNumber(int arrivalNumber) {
		this.arrivalNumber = arrivalNumber;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
