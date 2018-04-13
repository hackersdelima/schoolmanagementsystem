package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.AccountAction;
import com.controller.action.StudentAction;
import com.controller.student.classes.StudentOperations;

@WebServlet("/DeleteServlet")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		String uri=request.getRequestURI();
		String id=request.getParameter("id");
		
		StudentOperations s=new StudentOperations();
		if(uri.endsWith("student.del"))
		{
			StudentAction action=new StudentAction();
		action.deleteStudent(request,response);
		}
		if(uri.endsWith("subject.del"))
		{
			status=s.deletesubject(id);
			if(status){
				request.setAttribute("msg", "Successful!");
				RequestDispatcher rd=request.getRequestDispatcher("subjectsjsp");
				rd.forward(request,response);			}
			else{
				request.setAttribute("msg", "Unuccessful!");
				RequestDispatcher rd=request.getRequestDispatcher("subjectsjsp");
				rd.forward(request,response);			}
		}
		else if(uri.endsWith("exam.del"))
		{
			try {
				status=s.deleteexam(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(status){
				request.setAttribute("msg", "Successful!");
				RequestDispatcher rd=request.getRequestDispatcher("examjsp");
				rd.forward(request,response);			}
			else{
				request.setAttribute("msg", "Unsuccessful!");
				RequestDispatcher rd=request.getRequestDispatcher("examjsp");
				rd.forward(request,response);			}
		}
		else if(uri.endsWith("language.del")){
			
				status=s.deletelanguage(id);
			if(status){
				request.setAttribute("msg", "Successful!");
				RequestDispatcher rd=request.getRequestDispatcher("examjsp");
				rd.forward(request,response);			}
			else{
				request.setAttribute("msg", "Unsuccessful!");
				RequestDispatcher rd=request.getRequestDispatcher("examjsp");
				rd.forward(request,response);			
			}
		
		
		}
		else if(uri.endsWith("account.del")){
			AccountAction action=new AccountAction();
			action.deleteAccount(request,response);
		}

	}
}
