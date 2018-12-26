package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class CartDAO2 {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int getItemStock(String itemId) throws SQLException{

		String sql = "SELECT item_stock FROM item_info_transaction WHERE id = ?";
		int originalCount = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				originalCount = resultSet.getInt("item_stock");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return originalCount;
	}

	public int findTotalCount(String itemId,String userId) throws SQLException{

		String sql = "SELECT total_count FROM cart_item_transaction WHERE item_transaction_id = ? && user_master_id = ? LIMIT 1";
		int find = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemId);
			preparedStatement.setString(2, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				find = resultSet.getInt("total_count");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return find;
	}

	public void cartUpdate(int sumPrice, int sumCount, String itemId) throws SQLException{

		String sql = "UPDATE cart_item_transaction set total_price = ?, total_count = ? WHERE item_transaction_id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sumPrice);
			preparedStatement.setInt(2, sumCount);
			preparedStatement.setString(3, itemId);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int cartAllPrice(String userId) throws SQLException{

		String sql = "SELECT total_price FROM cart_item_transaction WHERE user_master_id = ?";
		int allPrice = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				allPrice += resultSet.getInt("total_price");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return allPrice;
	}

}
