package com.controller.action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.Model;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.daoImpl.AcademicsSettingsAddDaoImpl;

public class AcademicsSettingsAction {
	Model m=new Model();
	public ArrayList assignsubjects(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int i=0;
		boolean status=false;
		ArrayList statuslist=new ArrayList();
		String companydb=(String) request.getAttribute("companydb");
		String subjectids[]=request.getParameterValues("subjectid");
		AcademicsSettingsAddDao asad=new AcademicsSettingsAddDaoImpl();
		for(i=0;i<subjectids.length;i++){
			m.setCompanydb(companydb);
			m.setStudentid(request.getParameter("studentid"));
			m.setSubjectid(subjectids[i]);
			status=asad.assignsubject(m);
			statuslist.add(status);
		}
		return statuslist;
	}
	
}
