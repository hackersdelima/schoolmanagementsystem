package com.controller.action;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.Model;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.daoImpl.AcademicsSettingsAddDaoImpl;

public class AcademicsSettingsAction {
	Model m=new Model();
	public List<String> assignsubjects(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int i=0;
		boolean status=false;
		List<String> statuslist=new ArrayList<String>();
		String subjectids[]=request.getParameterValues("subjectid");
		String classid=request.getParameter("classid");
		
		AcademicsSettingsAddDao asad=new AcademicsSettingsAddDaoImpl();
		for(i=0;i<subjectids.length;i++){
			m.setStudentid(request.getParameter("studentid"));
			m.setSubjectid(subjectids[i]);
			m.setClassid(classid);
			status=asad.assignsubject(m);
			if(status){
			statuslist.add("true");
			}
			else{
				statuslist.add("false");
				
			}
		}
		return statuslist;
	}
	
}
