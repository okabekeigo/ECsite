package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public ArrayList<BuyItemDTO> getBuyItemInfo(){
		String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction ORDER BY id";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setCount(resultSet.getRow());
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
				buyItemDTOList.add(buyItemDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTOList;
	}


//	public int countBuyItemInfo(){
//		String sql = "SELECT COUNT(*) FROM item_info_transaction";
//
//		try{
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet= preparedStatement.executeQuery();
//			int count = 0;
//			count = resultSet.
//		}
//	}

//	public ArrayList<BuyItemDTO> getBuyItemDTOList(){
//		return buyItemDTOList;
//	}
}
