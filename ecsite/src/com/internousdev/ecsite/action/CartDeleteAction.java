package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware {

	private CartDeleteDAO cartDeleteDAO = new CartDeleteDAO();
	private String[] check;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		String userId = session.get("login_user_id").toString();

		if (check != null) {
			if (!(check[0].equals("false"))) {
				for (int i = check.length - 1; i >= 0; i--) {
					System.out.println(check[i]);
					int intCheck = Integer.parseInt(check[i]);
					intCheck--;
					cartDeleteDAO.createTempTable(userId, intCheck);
					cartDeleteDAO.cartSelectDelete();
				}
				cartDeleteDAO.connectionClose();
				result = SUCCESS;
			}
		}
		return result;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
