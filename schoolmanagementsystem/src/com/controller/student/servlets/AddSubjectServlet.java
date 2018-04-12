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
		String fullmarks = request.getParameter("fullmarks");
		String passmarks = request.getParameter("passmarks");
		String fullmarks_pr = request.getParameter("fullmarks_pr");
		String passmarks_pr = request.getParameter("passmarks_pr");

		sub.setSubjectcode(subjectcode);
		sub.setSubjectname(subjectname);
		sub.setSubjecttype(subjecttype);
		sub.setFullmarks(fullmarks);
		sub.setPassmarks(passmarks);
		sub.setFullmarks_pr(fullmarks_pr);
		sub.setPassmarks_pr(passmarks_pr);

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
