package com.school.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
	private static Connection conn=null;
    static{//instantiation block-called before constructor static-once work is done remains constant
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try{
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nalanda","root","centos");//javproject name of database
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
