package com.controller;
import java.sql.*;
public class MainClass {
	static Connection conn=null;
	Statement stmt=null;
	public MainClass(){		
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagementsystemdb","root","");
			stmt=conn.createStatement();
			System.out.println("schoolmanagementsystemdb connected");
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	public void connectschooldb(String schooldb){		
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+schooldb+"","root","");
			stmt=conn.createStatement();
			System.out.println(schooldb+" connected");
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally{
            if(conn != null)
                try{conn.close();stmt.cancel();}
            catch(SQLException e){e.printStackTrace();}
        }
	}
	public boolean checkmaindb(String username, String password){
		boolean status=false;
		String query="select * from usertbl where username='"+username+"' and password='"+password+"';";
		try{
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			status=rs.next();
			System.out.println(status);
		}
		catch(Exception e){
			System.out.println("checkmaindb error"+e);
		}
		return status;
	}
	public boolean checkuserinternaldb(String username, String password, String schooldb){
		boolean status=false;
		String query="select id from "+schooldb+".tbluser where username='"+username+"' and password='"+password+"';";
		try{
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			status=rs.next();
			System.out.println(status);
		}
		catch(Exception e){
			System.out.println("checkmainuser error"+e);
		}
		return status;
	}
	// userdetails contains every information about user including database to be connected
	public ResultSet userdetails(String username, String password){
		ResultSet rs=null;
		String query="select usertbl.*, companydetailtbl.*, userdetailtbl.* from usertbl join mainusertbl ON usertbl.id=mainusertbl.mId join companydetailtbl ON companydetailtbl.companyId = mainusertbl.companyId join userdetailtbl ON userdetailtbl.uId=usertbl.userdetailId where usertbl.username='"+username+"' and usertbl.password='"+password+"'; ";
		try{
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("schooldb error"+e);
		}
		return rs;
	}
	
	
}
