package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.school.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	ResultSet rs=null;
	Connection conn=null;
	PreparedStatement ps=null;
	public boolean insertStudentMarks(){
		return false;
	}

}
