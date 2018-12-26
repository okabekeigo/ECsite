package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dao.MyPageDAO2;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private MyPageDAO2 myPageDAO2 = new MyPageDAO2();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{

		if(!session.containsKey("id")){
			return ERROR;
		}

		if(deleteFlg == null){
			String item_transaction_id_min = myPageDAO2.minItemId();
			String item_transaction_id_max = myPageDAO2.maxItemId();
			String user_master_id = session.get("login_user_id").toString();
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id_min, item_transaction_id_max, user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		String item_transaction_id_min = myPageDAO2.minItemId();
		String item_transaction_id_max = myPageDAO2.maxItemId();
		String user_master_id = session.get("login_user_id").toString();
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id_min, item_transaction_id_max, user_master_id);

		if(res > 0){
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return myPageList;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
