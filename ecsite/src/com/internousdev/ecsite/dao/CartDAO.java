package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
//	private ArrayList<CartDTO> cartDTONameList = new ArrayList<CartDTO>();
 	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();

//	public ArrayList<CartDTO> getItemId() throws SQLException{
//
//		String sql = "SELECT id FROM cart_item_transaction";
//		try{
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while(resultSet.next()){
//				CartDTO cartDTO = new CartDTO();
//				cartDTO.setItemId(resultSet.getString("id"));
//				cartDTONameList.add(cartDTO);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return cartDTONameList;
//	}

	public void itemInputCart(String itemId,String itemName, int totalPrice, int totalCount, String loginId) throws SQLException{

		String sql = "INSERT INTO cart_item_transaction (item_transaction_id,item_name,total_price,total_count,user_master_id) VALUES(?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemId);
			preparedStatement.setString(2, itemName);
			preparedStatement.setInt(3, totalPrice);
			preparedStatement.setInt(4, totalCount);
			preparedStatement.setString(5, loginId);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public  ArrayList<CartDTO> getItemList(String userId) throws SQLException{

		String sql = "SELECT item_transaction_id,item_name,total_price,total_count FROM cart_item_transaction WHERE user_master_id = ? ORDER BY item_transaction_id";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				CartDTO cartDTO = new CartDTO();
				cartDTO.setCartRow(resultSet.getRow());
				cartDTO.setItemId(resultSet.getString("item_transaction_id"));
				cartDTO.setItemName(resultSet.getString("item_name"));
				cartDTO.setTotalPrice(resultSet.getString("total_price"));
				cartDTO.setTotalCount(resultSet.getString("total_count"));
				cartDTOList.add(cartDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return cartDTOList;
	}
}
