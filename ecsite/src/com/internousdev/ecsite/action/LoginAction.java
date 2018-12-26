package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public String execute(){
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			buyItemDTOList = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginUserId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}else{
			String loginResult = "miss";
			session.put("login_result",loginResult);
		}
		return result;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
