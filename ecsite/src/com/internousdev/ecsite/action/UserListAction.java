package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private ArrayList<UserListDTO> userListDTOList = new ArrayList<UserListDTO>();
	private UserListDAO userListDAO = new UserListDAO();

	public String execute()throws SQLException{
		String result = SUCCESS;

		userListDTOList = userListDAO.getUserList();

		return result;
	}

	public ArrayList<UserListDTO> getUserListDTOList(){
		return userListDTOList;
	}
}
