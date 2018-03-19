package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
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
import com.school.academic.model.ClassModel;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.dao.DisplayDao;
import com.school.daoImpl.AcademicsSettingsAddDaoImpl;
import com.school.daoImpl.DisplayDaoImpl;
import com.school.model.StudentModel;
import com.school.model.Subjects;

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
			RequestDispatcher rd=request.getRequestDispatcher("view/student/studentRegistration.jsp");
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
			StudentOperations s=new StudentOperations();
			List<StudentModel> list=s.studentDetails();
			request.setAttribute("slist", list);
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
		else if(uri.endsWith("assigncourse.click")){
			
			AcademicsSettingsAddDao dao=new AcademicsSettingsAddDaoImpl();
			List<ClassModel> list=new ArrayList<ClassModel>();
			 list=dao.getclasslist(request,response);
			 
			 List<ClassModel> sublist=new ArrayList<ClassModel>();
			 sublist=dao.getsublist(request,response);
			
				
			request.setAttribute("classlist", list);
			request.setAttribute("sublist", sublist);
			RequestDispatcher rd=request.getRequestDispatcher("view/academics/assigncourse.jsp");
			rd.forward(request, response);
		}
		
		//examination
		else if(uri.endsWith("createexam.click")){
			RequestDispatcher rd=request.getRequestDispatcher("examjsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("createStudentReport.click")){
			StudentOperations s = new StudentOperations();
			ResultSet sectionlist=s.getsection();
			ResultSet classlist = s.selectclass();
			ResultSet examtypelist=s.selectexamtype();
			
			request.setAttribute("sectionlist", sectionlist);
			request.setAttribute("classlist", classlist);
			request.setAttribute("examtypelist", examtypelist);
			RequestDispatcher rd=request.getRequestDispatcher("view/exam/createStudentReport.jsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("getMarksInputTable.click")){
			String classid=request.getParameter("id");
			DisplayDao d=new DisplayDaoImpl();
			List<Subjects> subjectslist=d.getClassSubjects(classid);
			request.setAttribute("subjectslist", subjectslist);
			RequestDispatcher rd=request.getRequestDispatcher("view/exam/setStudentMarks.jsp");
			rd.forward(request, response);
		}
	}

}
