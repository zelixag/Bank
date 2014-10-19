
package com.itheima.domain;

import java.io.Serializable;

import com.itheima.exception.MsgException;

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private String password2;
	private String nickname;
	private String realname;
	private String identityNum;
	private double allmoney;
	public double getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(float allmoney) {
		this.allmoney = allmoney;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdentityNum() {
		return identityNum;
	}
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return username+":"+password;
	}
	
	public void checkValue() throws MsgException{
		if(username==null || "".equals(username)){
			throw new MsgException("�û�������Ϊ��!");
		}
		if(password==null || "".equals(password)){
			throw new MsgException("���벻��Ϊ��!");
		}
		if(password2==null || "".equals(password2)){
			throw new MsgException("ȷ�����벻��Ϊ��!");
		}
		if(!password.equals(password2)){
			throw new MsgException("�������벻һ��!");
		}
		if(nickname==null || "".equals(nickname)){
			throw new MsgException("�ǳƲ���Ϊ��!");
		}
		if(realname==null || "".equals(realname)){
			throw new MsgException("��ʵ���ֲ���Ϊ��!");
		}
		if(identityNum==null || "".equals(identityNum)){
			throw new MsgException("���֤�Ų���Ϊ��!");
		}
		if(email==null || "".equals(email)){
			throw new MsgException("���䲻��Ϊ��!");
		}
		if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
			throw new MsgException("�����ʽ����ȷ!");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
