package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport implements SessionAware{

	private int userChoice = 0;
	private int delete = 0;
	private int userId = 0;
	private UserDeleteCompleteDAO userDeleteCompleteDAO = new UserDeleteCompleteDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException{
		String result = ERROR;
		setUserChoice(--userChoice);
		setUserId(userDeleteCompleteDAO.getUserId(getUserChoice()));

		if(userChoice >= 0){
			setDelete(userDeleteCompleteDAO.oneUserDelete(getUserId()));
			result = SUCCESS;
		}

		session.put("delete", getDelete());

		System.out.println(getUserChoice());
		System.out.println(getDelete());
		System.out.println(getUserId());

		return result;
	}

	public int getUserChoice() {
		return userChoice;
	}

	public void setUserChoice(int userChoice) {
		this.userChoice = userChoice;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
