package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemSelectDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemSelectDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemSelectDTO buyItemSelectDTO = new BuyItemSelectDTO();

	public BuyItemSelectDTO getBuyItemInfo(int choice) throws SQLException{
		String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction ORDER BY id LIMIT 1 OFFSET ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, choice);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				buyItemSelectDTO.setId(resultSet.getInt("id"));
				buyItemSelectDTO.setItemName(resultSet.getString("item_name"));
				buyItemSelectDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemSelectDTO.setItemStock(resultSet.getString("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return buyItemSelectDTO;
	}
}
