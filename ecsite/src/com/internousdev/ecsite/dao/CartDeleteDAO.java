package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class CartDeleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public void createTempTable(String userId,int check) throws SQLException{

		String sql = "CREATE TEMPORARY TABLE cartdel SELECT id FROM cart_item_transaction "
				+ "WHERE user_master_id = ? ORDER BY item_transaction_id "
				+ "LIMIT 1 OFFSET ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, check);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void cartSelectDelete() throws SQLException{

		String sql = "DELETE FROM cart_item_transaction "
				+ "WHERE id IN(SELECT id FROM cartdel)";
		String sql2 = "DROP TABLE cartdel";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement.execute();
			preparedStatement2.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void connectionClose() throws SQLException{
		connection.close();
	}

}
