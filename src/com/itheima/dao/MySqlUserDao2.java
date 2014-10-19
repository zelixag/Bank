package com.itheima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;

public class MySqlUserDao2 implements UserDao {

	private Object out;



	public void addUser(User user) {
		String sql = "insert into users values (null,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setString(4,user.getIdentityNum());
			ps.setString(5,user.getRealname());
			ps.setString(6, user.getEmail());
			//ps.setFloat(7, user.getAllmoney());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User findUserByUNandPSW(String username, String password) {
		String sql = "select * from users where username=?and password=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setRealname(rs.getString("realname"));
				user.setIdentityNum(rs.getString("identityNum"));
				user.setEmail(rs.getString("email"));
				user.setAllmoney(rs.getFloat("allmoney"));
				return user;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User setMoney(User user, String setmoney) {
		float setmoney1 =new Float(setmoney);
		System.out.println(user.getAllmoney());
		System.out.println((user.getAllmoney()+setmoney1));
		String sql = "update  users set allmoney="+(user.getAllmoney()+setmoney1) +"  where  username='"+user.getUsername()+"'";
		Connection conn = null;
		PreparedStatement ps = null;
		MySqlUserDao2 d = new MySqlUserDao2();
		
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			 ps.executeUpdate(sql);
		    return d.findUserByUserName(user.getUsername());
			}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User getMoney(User user, String getmoney) {
		
		float setmoney1 =new Float(getmoney);
		System.out.println(user.getAllmoney());
		System.out.println((user.getAllmoney()-setmoney1));
		String sql = "update  users set allmoney="+(user.getAllmoney()-setmoney1)+"where username='"+user.getUsername()+"'";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySqlUserDao2 d = new MySqlUserDao2();
		
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			//ps.setString(1, user.getUsername());
			 ps.executeUpdate(sql);
			 return  d.findUserByUserName(user.getUsername());
			}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	

	}

	public User transferMoney(User user, String tranmoney,String username) {
		String sql = "select allmoney from users where username = ?  ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySqlUserDao2 d = new MySqlUserDao2();
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				
				//System.out.println(user.getAllmoney());
				rs.getFloat("allmoney");
				float tranmoney1 = new Float(tranmoney);
				user.setAllmoney(user.getAllmoney()-tranmoney1);
				String sql1 = "update users set allmoney="+(rs.getFloat("allmoney")+tranmoney1)+" where username='?'";
				ps.setString(1,username);
				ps.executeUpdate(sql1);
				String sql2 = "update users set allmoney ="+(user.getAllmoney())+" where username = '"+user.getUsername()+"'" ;
				//ps.setString(1,user.getUsername());
				
				//ps.executeUpdate(sql1);
				ps.executeUpdate(sql2);
				
				return d.findUserByUserName(user.getUsername());

				
			
			}else{
				return null;
			}
							
			}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}

	}

	public double lookAllMoney(User user) {
	String sql = "select allmoney from users where username = ?  ";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		conn = JDBCUtils.getConn();
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		rs = ps.executeQuery();
		if(rs.next()){
			
			user.setAllmoney(rs.getFloat("allmoney"));
			
			return user.getAllmoney();
		}else{
			return 0;
		}
		}catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}finally{
		JDBCUtils.close(rs, ps, conn);
	}
}
	

	public User findUserByUserName(String username) {
		String sql = "select * from users where username=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setRealname(rs.getString("realname"));
				user.setIdentityNum(rs.getString("identityNum"));
				user.setEmail(rs.getString("email"));
				user.setAllmoney(rs.getFloat("allmoney"));
				return user;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}


}
