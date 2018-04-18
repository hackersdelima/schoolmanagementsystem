package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.AcademicsSettingsAction;
import com.controller.action.AccountAction;
import com.controller.action.CategoryAction;
import com.controller.action.StudentAction;
import com.controller.action.TransactionAction;
import com.controller.student.classes.Model;
import com.controller.student.classes.StudentOperations;

@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
PrintWriter out=response.getWriter();
		//sdfsdfsdfsdfsdf
		String uri=request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		boolean status = false;
		Model m = new Model();
		StudentOperations s = new StudentOperations();
		switch (uri) {
		  case "examtype.add":  
		
			try {
				String examtypename, description;
				examtypename = request.getParameter("examtypename");
				description = request.getParameter("description");
				s.addexamtype(examtypename, description);
				request.setAttribute("msg", "Successful!");
				RequestDispatcher rd = request.getRequestDispatcher("initialdetailsjsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		  case "exam.add":
			m.setExamname(request.getParameter("examname"));
			m.setExamtype(request.getParameter("examtype"));
			m.setStartdate(request.getParameter("startdate"));
			m.setExamcode(request.getParameter("examcode"));
			try {
				status = s.createnewexam(m);
				if (status) {
					request.setAttribute("msg", "Successful!");
				} else {
					request.setAttribute("msg", "Unsuccessful!");
				}
				RequestDispatcher rd = request.getRequestDispatcher("examjsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		break;
		  case "assignsubjects.add":
		
			AcademicsSettingsAction asa = new AcademicsSettingsAction();
			List<String> statuslist = new ArrayList<String>();
			try {
				statuslist = asa.assignsubjects(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (statuslist.contains("false")) {
				request.setAttribute("msg", "Unsuccessful!");
			} else {
				request.setAttribute("msg", "Successful!");

			}
			RequestDispatcher rd = request.getRequestDispatcher("subjectassign");
			rd.forward(request, response);
		break;
		
		  case "studentMarks.add":
			StudentAction action=new StudentAction();
			action.insertStudentMarks(request,response);
		break;
		
		  case "generalSettings.add":
			AcademicsSettingsAction a=new AcademicsSettingsAction();
			a.updateGeneralSettings(request,response);
		break;
		
		  case "account.add":
			AccountAction accountaction=new AccountAction();
			accountaction.addAccount(request,response);
		break;
		
		  case "category.add":
			CategoryAction ca=new CategoryAction();
			ca.addCategory(request,response);
			break;
			
		  case "multitransaction.add":
		
			TransactionAction taa=new TransactionAction();
			taa.addmultiTransaction(request,response);
		break;
		
	
		  case "transaction.add":
			TransactionAction ta=new TransactionAction();
			ta.addTransaction(request,response);
		break;
		
		  default:
				out.println("Invalid Action!");
		
			}
	}


		
	}
