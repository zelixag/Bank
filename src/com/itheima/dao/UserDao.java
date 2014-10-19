package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * @param username �û���
	 * @return �����û����ҵ����û���Ϣbean,���û�ҵ�����null
	 */
	public User findUserByUserName(String username);
	
	/**
	 * ����û�
	 * @param user Ҫ��ӵ��û���Ϣbean
	 */
	public void addUser(User user);
	
	/**
	 * �����û���������Ҷ�Ӧ���û�
	 * @param username �û���
	 * @param password ����
	 * @return �ҵ����û�,����Ҳ����򷵻�null
	 */
	public User findUserByUNandPSW(String username,String password);
	
	public User setMoney(User user,String setmoney);
	public User getMoney(User user,String getmoney);
	public User transferMoney(User user,String tranmoney,String username);
	public double lookAllMoney(User user);

}
