package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.controller.student.classes.StudentOperations;
import com.school.academic.model.ClassModel;
import com.school.dao.AcademicsSettingsAddDao;
import com.school.dao.DisplayDao;
import com.school.dao.StudentDao;
import com.school.daoImpl.AcademicsSettingsAddDaoImpl;
import com.school.daoImpl.DisplayDaoImpl;
import com.school.daoImpl.StudentDaoImpl;
import com.school.model.StudentModel;
import com.school.model.Subjects;
import com.school.model.UserModel;

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
			HttpSession session=request.getSession(true);
			List<UserModel> systemdetail =(List<UserModel>)session.getAttribute("systemdetail");
			String class_session=systemdetail.get(5).getSettingsdescription();
			
			request.setAttribute("examcode", class_session);
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
			ResultSet examlist=s.selectexam();
			
			request.setAttribute("sectionlist", sectionlist);
			request.setAttribute("classlist", classlist);
			request.setAttribute("examlist", examlist);
			RequestDispatcher rd=request.getRequestDispatcher("view/exam/createStudentReport.jsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("getMarksInputTable.click")){
			String[] classid=request.getParameter("id").split(",");;
			
			DisplayDao d=new DisplayDaoImpl();
			List<Subjects> subjectslist=d.getClassSubjects(classid[0]);
			request.setAttribute("subjectslist", subjectslist);
			RequestDispatcher rd=request.getRequestDispatcher("view/exam/setStudentMarks.jsp");
			rd.forward(request, response);
		}
		else if(uri.endsWith("reportsearchbox.click")){
			StudentOperations s = new StudentOperations();
			ResultSet sectionlist=s.getsection();
			ResultSet classlist = s.selectclass();
			ResultSet examlist=s.selectexam();
			
			request.setAttribute("examlist", examlist);
			request.setAttribute("sectionlist", sectionlist);
			request.setAttribute("classlist", classlist);
			RequestDispatcher rd=request.getRequestDispatcher("view/exam/marksSearchBox.jsp");
			rd.forward(request, response);
		}
		
		//Settings
		else if(uri.endsWith("generalSet.click")){
			
			RequestDispatcher rd=request.getRequestDispatcher("view/settings/generalSettings.jsp");
			rd.forward(request, response);
			
		}
		else if(uri.endsWith("getstudentname.click")){
			System.out.println("reached");
		PrintWriter out=response.getWriter();
			String[] classname=request.getParameter("classname").split(",");
			String section=request.getParameter("section");
			String rollno=request.getParameter("rollno");
			System.out.println("fasdfdsf"+section);
			StudentDao dao = new StudentDaoImpl();
			StudentModel student = dao.getStudentId(classname[1], section, rollno);
			
			if(rollno.equals("")){
				out.println("Roll No not Found");
			}
			else{
				
				System.out.println("fdsfasdfasd"+student.getStudentname());
				out.println(student.getStudentname());
			}
			
			
		}
		else if (uri.endsWith("nepaliToEnglish.click")) {
			PrintWriter out = response.getWriter();
			String nepalidate = request.getParameter("nepalidate");
		
			String convertedEnglishDate = dateConverter.DateConverter.nepaliToEnglish(nepalidate);
			out.println(convertedEnglishDate);
		} else if (uri.endsWith("englishToNepali.click")) {
			PrintWriter out = response.getWriter();
			String englishdate = request.getParameter("englishdate");
			String convertedNepaliDate = dateConverter.DateConverter.englishToNepali(englishdate);
			out.println(convertedNepaliDate);
		}
		else if (uri.endsWith("teststdname.click")) {
			System.out.println("reached");
			String[] stdname=request.getParameterValues("stdname");
			for(int i=0;i<stdname.length;i++){
			System.out.println(stdname[i]);
			}
			
		}
	}

}
