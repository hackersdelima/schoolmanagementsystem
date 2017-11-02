package com.school.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
	 static Connection conn=null;
	 static Statement stmt=null;
	public DbConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static Connection dbconnection(String database){
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"","root","");
			stmt=conn.createStatement();
			System.out.println(database+" connected");
		}
		catch (Exception e){
			System.out.println("database error"+e);
		}
		return conn;
	}
}
