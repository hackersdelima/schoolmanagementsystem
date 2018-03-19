package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.school.dao.DisplayDao;
import com.school.dbconnection.DbConnection;
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

}
