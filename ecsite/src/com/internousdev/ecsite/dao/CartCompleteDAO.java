package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.CartCompleteDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private CartCompleteDTO cartCompleteDTO = new CartCompleteDTO();
	private DateUtil dateUtil = new DateUtil();

	public int CartRow(String userId) throws SQLException{

		String sql = "SELECT COUNT(*) FROM cart_item_transaction WHERE user_master_id = ?";
		int row = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				row = resultSet.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}

	public CartCompleteDTO getCartInfo(String userId,int i) throws SQLException{

		String sql = "SELECT item_transaction_id,total_price,total_count,user_master_id "
				+ "FROM cart_item_transaction "
				+ "WHERE user_master_id = ? ORDER BY item_transaction_id LIMIT 1 OFFSET ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, i);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				cartCompleteDTO.setItemId(resultSet.getInt("item_transaction_id"));
				cartCompleteDTO.setTotalPrice(resultSet.getInt("total_price"));
				cartCompleteDTO.setTotalCount(resultSet.getInt("total_count"));
				cartCompleteDTO.setUserId(resultSet.getString("user_master_id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cartCompleteDTO;
	}

	public int insertBoughtData(int itemId,int totalPrice,int totalCount,String userId,String pay) throws SQLException{

		String sql = "INSERT INTO user_buy_item_transaction"
				+ "(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) "
				+ "VALUES(?,?,?,?,?,?)";
		int count = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			preparedStatement.setInt(2, totalPrice);
			preparedStatement.setInt(3, totalCount);
			preparedStatement.setString(4, userId);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());
			count = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public int getOriginalStock(int itemId) throws SQLException{

		String sql = "SELECT item_stock FROM item_info_transaction WHERE id = ?";
		int originalStock = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				originalStock = resultSet.getInt("item_stock");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return originalStock;
	}

	public void updateItemStock(int totalCount,int itemId) throws SQLException{

		String sql = "UPDATE item_info_transaction SET item_stock = ? WHERE id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, totalCount);
			preparedStatement.setInt(2, itemId);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteCart(String userId) throws SQLException{

		String sql = "DELETE FROM cart_item_transaction WHERE user_master_id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
