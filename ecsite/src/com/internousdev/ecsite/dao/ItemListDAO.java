package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private ArrayList<ItemListDTO> itemListDTOList = new ArrayList<ItemListDTO>();
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

//	public int countItem() throws SQLException{
//		int count = 0;
//		String sql = "SELECT id FROM item_info_transaction";
//
//		try{
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
////			ResultSet resultSet = preparedStatement.executeQuery();
//			count = preparedStatement.executeUpdate();
//
////			while(resultSet.next()){
////				itemListDTO.setItemId(resultSet.getString("id"));
////				itemListDTOList.add(itemListDTO);
////			}
//
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			connection.close();
//		}
//		return count;
//	}

	public ArrayList<ItemListDTO> getItemList() throws SQLException{

		String sql ="SELECT item_name,item_price,item_stock,insert_date FROM item_info_transaction";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemListDTO itemListDTO = new ItemListDTO();
				itemListDTO.setItemRow(resultSet.getRow());
				itemListDTO.setItemName(resultSet.getString("item_name"));
				itemListDTO.setItemPrice(resultSet.getString("item_price"));
				itemListDTO.setItemStock(resultSet.getString("item_stock"));
				itemListDTO.setInsert_date(resultSet.getString("insert_date"));
				itemListDTOList.add(itemListDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return itemListDTOList;
	}
}
