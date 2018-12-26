package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();

	public String execute() throws SQLException{

		String result = SUCCESS;

		userListDeleteCompleteDAO.deleteUserList();

		return result;
	}
}
