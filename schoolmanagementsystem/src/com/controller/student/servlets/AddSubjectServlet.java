package com.controller.student.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
import com.school.model.Subjects;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean status = false;
		Subjects sub = new Subjects();
		String subjectcode = request.getParameter("subjectcode");
		String subjectname = request.getParameter("subjectname");
		String subjecttype = request.getParameter("subjecttype");
		
		sub.setSubjectcode(subjectcode);
		sub.setSubjectname(subjectname);
		sub.setSubjecttype(subjecttype);

		StudentOperations s = new StudentOperations();
		status = s.addsubject(sub);
		if (status) {
			request.setAttribute("msg", "Successful!");
		} else {
			request.setAttribute("msg", "Unsuccessful!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("subjectsjsp");
		rd.forward(request, response);
	}
}
