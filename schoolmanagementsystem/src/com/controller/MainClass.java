package com.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.school.dbconnection.DbConnection;
import com.school.user.model.UserModel;
public class MainClass {
	static Connection conn=null;
	Statement stmt=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean checkuser(String username, String password, String staffCode){
		boolean status=false;
		String query="select * from usertbl where username='"+username+"' and password='"+password+"' and staffCode='"+staffCode+"';";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			status=rs.next();
			if(status){
				rs=null;
				stmt=null;
				return true;
			}
		}
		catch(Exception e){
			System.out.println("checkmaindb error"+e);
		}
		return false;
	}
	
	// userdetails contains every information about user including database to be connected
	public UserModel userdetails(String username, String password, String staffCode){
		ResultSet rs=null;
		UserModel u;
		String query="select * from usertbl where username='"+username+"' and password='"+password+"' and staffCode='"+staffCode+"'; ";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next()){
				u=new UserModel();
				u.setUserid(rs.getString("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setStatus(rs.getString("status"));
				return u;
			}
			
		}
		catch(Exception e){
			System.out.println("schooldb error"+e);
		}
		return null;
	}
	
	//system details
	public List<UserModel> getSystemDetails(UserModel u){
		String query="select * from generalsettings";
		UserModel user=null;
		List<UserModel> list=new ArrayList<UserModel>();
		conn=DbConnection.getConnection();
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				user=new UserModel();
				user.setSettingsid(rs.getString("settings_id"));
				user.setSettingstype(rs.getString("type"));
				user.setSettingsdescription(rs.getString("description"));
				list.add(user);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
