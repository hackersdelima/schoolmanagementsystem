package com.controller;

import java.io.IOException;
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
		boolean status = false;
		String uri = request.getRequestURI();
	
		Model m = new Model();
		StudentOperations s = new StudentOperations();
		if (uri.endsWith("examtype.add")) {
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
		}
		if (uri.endsWith("exam.add")) {
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
		}
		if (uri.endsWith("assignsubjects.add")) {
		
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
		}
		else if (uri.endsWith("studentMarks.add")) {
			StudentAction action=new StudentAction();
			action.insertStudentMarks(request,response);
		}
		else if(uri.endsWith("generalSettings.add")){
			AcademicsSettingsAction a=new AcademicsSettingsAction();
			a.updateGeneralSettings(request,response);
		}
		else if(uri.endsWith("account.add")){
			AccountAction a=new AccountAction();
			a.addAccount(request,response);
		}
		if(uri.endsWith("category.add")){
			CategoryAction ca=new CategoryAction();
			ca.addCategory(request,response);
		if(uri.endsWith("multitransaction.add"))
		{
			TransactionAction action=new TransactionAction();
			action.addmultiTransaction(request,response);
		}
		
	
		if(uri.endsWith("transaction.add")){
			TransactionAction ta=new TransactionAction();
			ta.addTransaction(request,response);
		}
	}

	}}
