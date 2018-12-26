package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartCompleteDAO;
import com.internousdev.ecsite.dto.CartCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartCompleteAction extends ActionSupport implements SessionAware {

	private String completeFlg = "fault";
	private CartCompleteDAO cartCompleteDAO = new CartCompleteDAO();
	private CartCompleteDTO cartCompleteDTO = new CartCompleteDTO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		String result = SUCCESS;

		String userId = session.get("login_user_id").toString();
		int row = cartCompleteDAO.CartRow(userId);

		for (int i = 0; i < row; i++) {
			cartCompleteDTO = cartCompleteDAO.getCartInfo(userId,i);

			int itemId = cartCompleteDTO.getItemId();
			int totalPrice = cartCompleteDTO.getTotalPrice();
			int totalCount = cartCompleteDTO.getTotalCount();
			String pay = session.get("pay").toString();
			int complete = cartCompleteDAO.insertBoughtData(itemId, totalPrice, totalCount, userId, pay);
			int originalStock = cartCompleteDAO.getOriginalStock(itemId);
			int newStock = originalStock - totalCount;
			cartCompleteDAO.updateItemStock(newStock,itemId);

			if (complete > 0) {
				setCompleteFlg("OK");
			}
		}

		if(getCompleteFlg().equals("OK")){
			cartCompleteDAO.deleteCart(userId);
		}
		System.out.println(userId);

		return result;
	}

	public String getCompleteFlg() {
		return completeFlg;
	}

	public void setCompleteFlg(String completeFlg) {
		this.completeFlg = completeFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
