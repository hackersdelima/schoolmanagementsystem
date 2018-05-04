package com.controller.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.MainClass;
import com.controller.student.classes.Model;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.daoImpl.AcademicsSettingsAddDaoImpl;
import com.school.user.model.UserModel;

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
	public void updateGeneralSettings(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(true);
		String[] settings_id=request.getParameterValues("settings_id"),
				description=request.getParameterValues("description");
		boolean status=false;
		List<String> statlist = new ArrayList<String>();
		Model m=new Model();
		UserModel user = new UserModel();
		MainClass action = new MainClass();
		AcademicsSettingsAddDao as=new AcademicsSettingsAddDaoImpl();
		for (int i = 0; i < description.length; i++) {
			m.setSettings_id(settings_id[i]);
			m.setDescription(description[i]);
			
			status = as.updateGeneralSetting(m);
			if (status)
				statlist.add("true");
			else
				statlist.add("false");
		}
		session.removeAttribute("systemdetail");
		List<UserModel> systemdetail = action.getSystemDetails(user);
		session.setAttribute("systemdetail", systemdetail);
		if (statlist.contains("true")){
			request.setAttribute("msg", "Update Successful!");
		}
		else{
			request.setAttribute("msg", "Update Failed!");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("generalSet.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
