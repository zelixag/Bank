package com.itheima.test;

import org.junit.Test;

import com.itheima.dao.XmlUserDao;
import com.itheima.domain.User;

public class XmlUserDaoTest {
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("adminxxx");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("admin", "adminxx");
		System.out.println(user);
	}
	
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("��Ǭ");
		user.setPassword("123");
		user.setNickname("С����");
		user.setRealname("ƱǮ");
		user.setIdentityNum("6587698797687");
		user.setEmail("piaoqian@itcast.cn");
		dao.addUser(user);
	}
}
