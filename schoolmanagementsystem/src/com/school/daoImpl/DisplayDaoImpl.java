package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.school.dao.DisplayDao;
import com.school.dbconnection.DbConnection;
import com.school.model.StudentModel;
import com.school.model.Subjects;

public class DisplayDaoImpl implements DisplayDao{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public List<Subjects> getClassSubjects(String classid){
		List<Subjects> list=new ArrayList<Subjects>();
		Subjects sub=null;
		String query="select subjectlist.* from coursetbl join subjectlist on coursetbl.subjectid=subjectlist.subjectid where coursetbl.gradeid=?";
		try{
		con=DbConnection.getConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, classid);
		rs=ps.executeQuery();
		while(rs.next()){
			sub=new Subjects();
			sub.setSubjectid(rs.getString("subjectid"));
			sub.setSubjectname(rs.getString("subjectname"));
			sub.setSubjecttype(rs.getString("subjecttype"));
			list.add(sub);
		}
		if(list.size()>0){
			return list;
		}
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	public StudentModel getSpecificStudentDetails(String studentid){
		String query="select * from studentinfo where studentid=?";
		StudentModel s=null;
		
		try {
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, studentid);
			rs=ps.executeQuery();
			
			if(rs.next()){
				s=new StudentModel();
				s.setStudentname(rs.getString("studentname"));
				s.setAdmissionclass(rs.getString("admissionclass"));
				s.setSection(rs.getString("section"));
				s.setStudentid(rs.getString("studentid"));
				s.setRollno(rs.getString("rollno"));
				con.close();
				ps.close();
				rs.close();
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Subjects> getSpecificStudentReport(Subjects s){
		List<Subjects> list=new ArrayList<Subjects>();
		String query="select *, subjectlist.* from exam_marks_tbl join subjectlist on exam_marks_tbl.subjectid=subjectlist.subjectid join exam on exam_marks_tbl.examid=exam.examid  where exam_marks_tbl.studentid=? and exam_marks_tbl.examid=?";
		
		Subjects sub=null;
		con=DbConnection.getConnection();
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getStudentid());
			ps.setString(2, s.getExamid());
			rs=ps.executeQuery();
			while(rs.next()){
				sub=new Subjects();
				sub.setSubjectcode(rs.getString("subjectCode"));
				sub.setSubjectname(rs.getString("subjectname"));
				sub.setSubjecttype(rs.getString("subjecttype"));
				sub.setPrmarks(rs.getString("prmarks"));
				sub.setThmarks(rs.getString("thmarks"));
				sub.setTotalmarks(rs.getString("totalmarks"));
				sub.setTotalgrade(rs.getString("totalgrade"));
				sub.setRemarks(rs.getString("remarks"));
				sub.setFullmarks(rs.getString("fullmarks"));
				sub.setPassmarks(rs.getString("passmarks"));
				
				list.add(sub);
				
			}
			if(list.size()>0){
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
