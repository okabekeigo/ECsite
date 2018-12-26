package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteCompleteDAO extends BuyItemSelectDAO{

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public void oneItemDelete(int itemId) throws SQLException{

		String sql = "DELETE FROM item_info_transaction WHERE id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
