package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO2 {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public String minItemId() throws SQLException{
		String sql = "SELECT id FROM item_info_transaction ORDER BY id LIMIT 1";
		String min = null;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				min = resultSet.getString("id");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return min;
	}

	public String maxItemId() throws SQLException{
		String sql = "SELECT id FROM item_info_transaction ORDER BY id DESC LIMIT 1";
		String max = null;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				max = resultSet.getString("id");
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		System.out.println("this is max" + max);
		return max;
	}
}
