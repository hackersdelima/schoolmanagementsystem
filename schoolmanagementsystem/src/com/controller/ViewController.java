package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.StudentAction;

@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String uri=request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		
		switch (uri) {
		
        case "specificStudentReport.view":  
        	StudentAction action=new StudentAction();
		action.getSpecificStudentReport(request,response);
		break;
		
        case "examreport.view":
        	RequestDispatcher rd=request.getRequestDispatcher("view/exam/report.jsp");
			rd.forward(request, response);
			break;
		
		default:
			out.println("Invalid Action!");
	
		}
	}

}
