package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int getUserId(int userChoice) throws SQLException{

		String sql = "SELECT id FROM login_user_transaction LIMIT 1 OFFSET ?";
		int userId = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userChoice);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userId = resultSet.getInt("id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userId;
	}

	public int oneUserDelete(int userId) throws SQLException{

		String sql = "DELETE FROM login_user_transaction WHERE id = ?";
		int delete = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			delete = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return delete;
	}
}
