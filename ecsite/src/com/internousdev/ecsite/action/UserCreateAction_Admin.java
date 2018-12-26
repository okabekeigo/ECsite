package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction_Admin extends ActionSupport{

	private String branch = "admin";

	public String execute(String branch){
		setBranch(branch);
		return SUCCESS;
	}

	public String getBranch(){
		return branch;
	}
	public void setBranch(String branch){
		this.branch = branch;
	}
}