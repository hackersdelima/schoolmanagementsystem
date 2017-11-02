package com.controller.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		String subjectname=request.getParameter("subjectname");
		String subjecttype=request.getParameter("subjecttype");
		String companydb=request.getParameter("companydb");
		StudentOperations s=new StudentOperations(companydb);
		status=s.addsubject(subjectname,subjecttype);
		if(status){
		response.getOutputStream().println("<script>alert('SUCCESSFUL!');window.location.href = 'profile#!/createsubject';</script>");
		}
		else{
		response.getOutputStream().println("<script>alert('UNSUCCESSFUL!');window.location.href = 'profile#!/createsubject';</script>");
		}
	}
}
