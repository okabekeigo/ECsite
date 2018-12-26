package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.GoCartDAO;
import com.internousdev.ecsite.dao.GoCartDAO2;
import com.internousdev.ecsite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware{

	private GoCartDAO goCartDAO = new GoCartDAO();
	private GoCartDAO2 goCartDAO2 = new GoCartDAO2();
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();
	private int allPrice;
	private Map<String, Object> session;

	public String execute() throws SQLException{
		String result = SUCCESS;

		String userId = session.get("login_user_id").toString();

		setCartDTOList(goCartDAO.getItemList(userId));
		setAllPrice(goCartDAO2.cartAllPrice(userId));

		return result;
	}

	public ArrayList<CartDTO> getCartDTOList() {
		return cartDTOList;
	}

	public void setCartDTOList(ArrayList<CartDTO> cartDTOList) {
		this.cartDTOList = cartDTOList;
	}

	public int getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(int allprice) {
		allPrice = allprice;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
