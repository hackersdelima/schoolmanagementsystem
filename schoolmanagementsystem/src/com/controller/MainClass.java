package com.controller;
import java.sql.*;

import com.school.dbconnection.DbConnection;
import com.school.model.UserModel;
public class MainClass {
	static Connection conn=null;
	Statement stmt=null;
	
	public boolean checkuser(String username, String password){
		boolean status=false;
		String query="select * from usertbl where username='"+username+"' and password='"+password+"';";
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
	public UserModel userdetails(String username, String password){
		ResultSet rs=null;
		UserModel u;
		String query="select * from usertbl where username='"+username+"' and password='"+password+"'; ";
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
	
	
}
