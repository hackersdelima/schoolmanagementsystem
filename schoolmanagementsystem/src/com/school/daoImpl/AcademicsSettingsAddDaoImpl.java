package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.controller.student.classes.Model;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.dbconnection.DbConnection;

public class AcademicsSettingsAddDaoImpl implements AcademicsSettingsAddDao {
	PreparedStatement ps=null;
	Connection con=null;
	public boolean assignsubject(Model m) throws SQLException{
		int a;
		boolean status=false;
		con=DbConnection.getConnection();
		String query="insert into course (subjectid,studentid) values('"+m.getSubjectid()+"','"+m.getStudentid()+"')";
		try{
			ps=con.prepareStatement(query);
			a=ps.executeUpdate();
			if(a>0){
				status=true;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			if(con!=null){con.close();}
			if(ps!=null){ps.close();}
		}
		return status;
	}
}
