package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<UserListDTO> getUserList() throws SQLException{

		ArrayList<UserListDTO> userListDTOList = new ArrayList<UserListDTO>();
		String sql = "SELECT login_id,login_pass,user_name,insert_date FROM login_user_transaction";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				UserListDTO dto = new UserListDTO();
				dto.setUserRow(resultSet.getRow());
				dto.setLoginId(resultSet.getString("login_id"));
				dto.setLoginPassword(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				userListDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return userListDTOList;
	}
}
