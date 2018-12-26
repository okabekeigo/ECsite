package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id_min, String item_transaction_id_max,String user_master_id) throws SQLException{

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql = "SELECT ubit.id, iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON ubit.item_transaction_id = iit.id "
				+ "WHERE ubit.item_transaction_id BETWEEN ? AND ? AND ubit.user_master_id = ?"
				+ "ORDER BY insert_date DESC";


		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id_min);
			preparedStatement.setString(2, item_transaction_id_max);
			preparedStatement.setString(3, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}

		return myPageDTO;
	}

	public int buyItemHistoryDelete(String item_transaction_id_min,String item_transaction_id_max,String user_master_id) throws SQLException{

		String sql = "DELETE FROM user_buy_item_transaction "
				+ "WHERE item_transaction_id BETWEEN ? AND ? AND user_master_id = ?";
		int result = 0;
		try{
			PreparedStatement preparedStatemnet = connection.prepareStatement(sql);
			preparedStatemnet.setString(1, item_transaction_id_min);
			preparedStatemnet.setString(2, item_transaction_id_max);
			preparedStatemnet.setString(3, user_master_id);
			result = preparedStatemnet.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}
}
