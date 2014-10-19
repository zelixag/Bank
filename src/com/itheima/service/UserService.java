package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.exception.MsgException;
import com.itheima.factory.DaoFactory;

public class UserService {
//	private XmlUserDao dao = new XmlUserDao();
//	private MySqlUserDao dao = new MySqlUserDao();
	private UserDao dao = DaoFactory.getFactory().getDao();
	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException{
		//1.检查用户名是否已经存在,如果已经存在则提示
		if(dao.findUserByUserName(user.getUsername())!=null){
			throw new MsgException("用户名已经存在!");
		}
		//2.如果不存在则调用dao中的方法添加用户
		dao.addUser(user);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUserByUNandPSW(username, password);
	}
	
	public float lookAllMoney(User user){
		return dao.lookAllMoney(user);
		
	}
	public User findUserAndMoney(String userName,String transfermoney){
		if(transfermoney==""||userName==""){
			return null;
		}
		for(int i=0;i<transfermoney.length();i++){
			if(47>transfermoney.charAt(i)||transfermoney.charAt(i)>58){
				return null;
				
		}
		}
		return dao.findUserByUserName(userName);
		
	}
	public  User setMoney(User user,String setmoney){
		char[] checkNum = null;
		if(setmoney==""){
			return null;
		}
		for(int i=0;i<setmoney.length();i++){
			if(47>setmoney.charAt(i)||setmoney.charAt(i)>58){
				return null;
				
		}
		}
		dao.setMoney(user, setmoney);
		return dao.setMoney(user, setmoney);
		
	}
	
	public User transferMoney(User user,String transfermoney,String username ){
		if(transfermoney==""||username==""){
			return null;
		}
		for(int i=0;i<transfermoney.length();i++){
			if(47>transfermoney.charAt(i)||transfermoney.charAt(i)>58){
				return null;
		}
		}
		return dao.transferMoney(user, transfermoney, username);
	}

	public User getMoney(User user, String getmoney) {
		char[] checkNum = null;
		if(getmoney==""){
			return null;
		}
		for(int i=0;i<getmoney.length();i++){
			if(47>getmoney.charAt(i)||getmoney.charAt(i)>58){
				return null;
				
		}
		}
		
		return dao.getMoney(user, getmoney);
	}
}
