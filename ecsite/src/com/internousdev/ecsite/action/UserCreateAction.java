package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport{

	private String branch = "ordinary";

	public String execute(String branch) throws SQLException{
		String result = SUCCESS;
		setBranch(branch);

		return result;
	}

	public String getBranch(){
		return branch;
	}
	public void setBranch(String branch){
		this.branch = branch;
	}
}
