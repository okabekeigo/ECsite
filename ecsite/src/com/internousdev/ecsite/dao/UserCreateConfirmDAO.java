package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean findUserId(String userId) throws SQLException{

		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ?";
		boolean userIdFlag = false;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userIdFlag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userIdFlag;
	}
}
