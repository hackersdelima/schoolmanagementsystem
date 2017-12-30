package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.Model;
import com.school.academic.model.ClassModel;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.dbconnection.DbConnection;

public class AcademicsSettingsAddDaoImpl implements AcademicsSettingsAddDao {
	PreparedStatement ps=null;
	Connection con=null;
	public void assigncourse(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		
		
	}
	public boolean assignsubject(Model m) throws SQLException{
		int a;
		boolean status=false;
		con=DbConnection.dbconnection(m.getCompanydb());
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
	public List<ClassModel> getclasslist(HttpServletRequest request, HttpServletResponse response)
	{
	}
}
