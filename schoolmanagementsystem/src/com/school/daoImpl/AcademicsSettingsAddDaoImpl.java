package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		con=DbConnection.getConnection();
		String query="insert into coursetbl (subjectid,gradeid) values(?,?)";
		try{
			ps=con.prepareStatement(query);
			ps.setString(1, m.getSubjectid());
			ps.setString(2, m.getClassid());
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
		List<ClassModel> list=null;
		ClassModel model=null;
		con=DbConnection.getConnection();
		ResultSet rs=null;
		String query="select * from classlist";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				model=new ClassModel();
				model.setClassid(rs.getString("classid"));
				model.setClassname(rs.getString("classname"));
				list.add(model);
			}
			
			if(list.size()>0)
			{
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	public List<ClassModel> getsublist(HttpServletRequest request, HttpServletResponse response)
	{
		List<ClassModel> list=null;
		ClassModel model=null;
		con=DbConnection.getConnection();
		ResultSet rs=null;
		String query="select * from subjectlist";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				model=new ClassModel();
				model.setSubjectid(rs.getString("subjectid"));
				model.setSubjectname(rs.getString("subjectname"));
				model.setSubjecttype(rs.getString("subjecttype"));
				list.add(model);
			}
			
			if(list.size()>0)
			{
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
