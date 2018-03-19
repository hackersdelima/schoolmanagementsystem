package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
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
		System.out.println("reached");
		Subjects s = new Subjects();
		String classid = request.getParameter("classid"), sectionid = request.getParameter("sectionid"),
				studentid = request.getParameter("studentid");

		String[] thmarks = request.getParameterValues("thmarks"), prmarks = request.getParameterValues("prmarks"),
				totalmarks = request.getParameterValues("totalmarks"),
				subjecttype = request.getParameterValues("subtype"), subid = request.getParameterValues("subid");
		s.setClassid(classid);
		s.setSectionid(sectionid);
		s.setStudentid(studentid);

		for (int i = 0; i < subid.length; i++) {
			s.setSubjectid(subid[i]);
			s.setSubjecttype(subjecttype[i]);
			s.setThmarks(thmarks[i]);
			s.setPrmarks(prmarks[i]);
			s.setTotalmarks(totalmarks[i]);
			
			System.out.println(subid[i]);
		}
	}

}
