package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.dao.StudentDao;
import com.school.dbconnection.DbConnection;
import com.school.model.StudentModel;
import com.school.model.Subjects;

public class StudentDaoImpl implements StudentDao {
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement ps=null;
	public boolean insertStudentMarks(){
		return false;
	}

	public boolean insertStudentMarks(Subjects s){
		String query="insert into exam_marks_tbl(studentid,examid,subjectid,prmarks,thmarks,totalmarks,totalgrade,remarks,inputDate, fullmarks, passmarks) values(?,?,?,?,?,?,?,?,now(),?,?)";
		int i=0;
		con=DbConnection.getConnection();
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getStudentid());
			ps.setString(2, s.getExamid());
			ps.setString(3, s.getSubjectid());
			ps.setString(4, s.getPrmarks());
			ps.setString(5, s.getThmarks());
			ps.setString(6, s.getTotalmarks());
			ps.setString(7, s.getTotalgrade());
			ps.setString(8, s.getRemarks());
			ps.setString(9, s.getFullmarks());
			ps.setString(10, s.getPassmarks());
			i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
				
	}
	
	public StudentModel getStudentId(String classid, String sectionid, String rollno)
	{
		StudentModel s=new StudentModel();
		String query="select * from studentinfo where admissionclass=? and section=? and rollno=?";
		con=DbConnection.getConnection();
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, classid);
			ps.setString(2, sectionid);
			ps.setString(3, rollno);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				s.setStudentid(rs.getString("studentid"));
				s.setStudentname(rs.getString("studentname"));
				
				return s;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
