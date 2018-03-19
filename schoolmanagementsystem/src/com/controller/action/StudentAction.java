package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
import com.school.dao.StudentDao;
import com.school.daoImpl.StudentDaoImpl;
import com.school.model.StudentModel;
import com.school.model.Subjects;

/**
 * Servlet implementation class StudentAction
 */
@WebServlet("/StudentAction")
public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentAction() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentid = request.getParameter("id");
		StudentOperations s = new StudentOperations();
		boolean status = s.deleteStudent(studentid);
		if (status) {
			request.setAttribute("msg", "Delete Successful!");
		} else {
			request.setAttribute("msg", "Delete Unsuccessful!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("studentslist.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// exam management system
	public void insertStudentMarks(HttpServletRequest request, HttpServletResponse response) {
		Subjects s = new Subjects();
		StudentDao dao=new StudentDaoImpl();
		
		String classid = request.getParameter("classid"), sectionid = request.getParameter("sectionid");
		String rollno=request.getParameter("rollno");
		String examtype=request.getParameter("examtype");

		String[] thmarks = request.getParameterValues("thmarks"), prmarks = request.getParameterValues("prmarks"),
				totalmarks = request.getParameterValues("totalmarks"),
				subjecttype = request.getParameterValues("subtype"), subid = request.getParameterValues("subid"),
				remarks=request.getParameterValues("remarks"),
				totalgrade=request.getParameterValues("totalgrade");
		
	
		
		s.setClassid(classid);
		s.setSectionid(sectionid);
		s.setExamtype(examtype);
	
		
		StudentModel student=dao.getStudentId(classid,sectionid,rollno);
		s.setStudentid(student.getStudentid());
		boolean status=false;
		
			List<String> statuslist=new ArrayList<String>();
		for (int i = 0; i < subid.length; i++) {
			s.setSubjectid(subid[i]);
			s.setSubjecttype(subjecttype[i]);
			s.setThmarks(thmarks[i]);
			s.setPrmarks(prmarks[i]);
			s.setTotalmarks(totalmarks[i]);
			
			s.setRemarks(remarks[i]);
			s.setTotalgrade(totalgrade[i]);
			//query
		
			status=dao.insertStudentMarks(s);
			//statuslist.add(status.toString());
			if(status){
				statuslist.add("true");
			}
			else{
				statuslist.add("false");
			}
		}
		if(statuslist.contains("false")){
			request.setAttribute("msg", "Unsuccessful");
		}
		else{
			request.setAttribute("msg", "successful");
		}
		//dispatcher
	}

}
