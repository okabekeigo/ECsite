package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dao.CartDAO2;
import com.internousdev.ecsite.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private CartDAO cartDAO = new CartDAO();
	private CartDAO2 cartDAO2 = new CartDAO2();
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();
	private Map<String, Object> session;
	private int count;
	private int allPrice;

	public String execute() throws SQLException{
		String result = SUCCESS;

		String userId = session.get("login_user_id").toString();
		String itemId = session.get("id").toString();

		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		int totalPrice = count * intPrice;
		int formerCount = cartDAO2.findTotalCount(itemId,userId);
		int sumCount = count + formerCount;
		int sumPrice = sumCount * intPrice;

		if(sumCount > cartDAO2.getItemStock(itemId)){
			result = ERROR;
		}else if(cartDAO2.findTotalCount(itemId,userId) == 0){
			cartDAO.itemInputCart(
					itemId,
					session.get("buyItem_name").toString(),
					totalPrice,
					count,
					userId);
		}
		else{
			cartDAO2.cartUpdate(
					sumPrice,
					sumCount,
					itemId);
		}

		cartDTOList = cartDAO.getItemList(userId);
		setAllPrice(cartDAO2.cartAllPrice(userId));

		return result;
	}

	public ArrayList<CartDTO> getCartDTOList() {
		return cartDTOList;
	}

	public void setCartDTOList(ArrayList<CartDTO> cartDTOList) {
		this.cartDTOList = cartDTOList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(int allPrice) {
		this.allPrice = allPrice;
	}

}
