package com.internousdev.ecsite.dto;

public class UserListDTO {

	private int userRow;
	private String loginId;
	private String loginPassword;
	private String userName;
	private String insertDate;

	public int getUserRow() {
		return userRow;
	}
	public void setUserRow(int userRow) {
		this.userRow = userRow;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getInsertDate(){
		return insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}
}
