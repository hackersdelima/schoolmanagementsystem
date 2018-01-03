package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
import com.school.model.StudentModel;

/**
 * Servlet implementation class NavigationController
 */
@WebServlet("/NavigationController")
public class NavigationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.endsWith("studentadmission.click")){
			RequestDispatcher rd=request.getRequestDispatcher("studentregistrationjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("studentslist.click")){
			StudentOperations s=new StudentOperations();
			List<StudentModel> list=s.studentDetails();
			request.setAttribute("slist", list);
			RequestDispatcher rd=request.getRequestDispatcher("studentslistjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("initialdetails.click")){
			RequestDispatcher rd=request.getRequestDispatcher("initialdetailsjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("subjects.click")){
			RequestDispatcher rd=request.getRequestDispatcher("subjectsjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("subjectassign.click")){
			RequestDispatcher rd=request.getRequestDispatcher("subjectassign");
			rd.forward(request, response);
		}
		else if(uri.endsWith("createexam.click")){
			RequestDispatcher rd=request.getRequestDispatcher("examjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("dashboard.click")){
			RequestDispatcher rd=request.getRequestDispatcher("view/dashboard.jsp");
			rd.forward(request, response);
		}
	}

}
