package com.controller.action;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
import com.school.dao.DisplayDao;
import com.school.dao.StudentDao;
import com.school.daoImpl.DisplayDaoImpl;
import com.school.daoImpl.StudentDaoImpl;
import com.school.model.StudentModel;
import com.school.model.Subjects;

/**
 * Servlet implementation class StudentAction
 */
@WebServlet("/StudentAction")
public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentAction() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentid = request.getParameter("id");
		StudentOperations s = new StudentOperations();
		boolean status = s.deleteStudent(studentid);
		if (status) {
			request.setAttribute("msg", "Delete Successful!");
		} else {
			request.setAttribute("msg", "Delete Unsuccessful!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("studentslist.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// exam management system
	public void insertStudentMarks(HttpServletRequest request, HttpServletResponse response) {
		Subjects s = new Subjects();
		StudentDao dao = new StudentDaoImpl();
		String[] classid = request.getParameter("classid").split(",");
		String sectionid = request.getParameter("sectionid");
		String rollno = request.getParameter("rollno");
		String examid = request.getParameter("examid");

		String[] thmarks = request.getParameterValues("thmarks"), prmarks = request.getParameterValues("prmarks"),
				subjecttype = request.getParameterValues("subtype"), subid = request.getParameterValues("subid"),
				remarks = request.getParameterValues("remarks"), totalgrade = request.getParameterValues("totalgrade"),
				fullmarks=request.getParameterValues("fullmarks"),passmarks=request.getParameterValues("passmarks"),
				fullmarks_pr=request.getParameterValues("fullmarks_pr"),
				passmarks_pr=request.getParameterValues("passmarks_pr");

		s.setClassid(classid[1]);
		s.setSectionid(sectionid);
		s.setExamid(examid);

		StudentModel student = dao.getStudentId(classid[1], sectionid, rollno);
		s.setStudentid(student.getStudentid());
		boolean status = false;

		List<String> statuslist = new ArrayList<String>();
		for (int i = 0; i < subid.length; i++) {
			s.setSubjectid(subid[i]);
			s.setSubjecttype(subjecttype[i]);
			s.setThmarks(thmarks[i]);
			s.setPrmarks(prmarks[i]);
			s.setFullmarks(fullmarks[i]);
			s.setPassmarks(passmarks[i]);
			s.setFullmarks_pr(fullmarks_pr[i]);
			s.setPassmarks_pr(passmarks_pr[i]);
			s.setRemarks(remarks[i]);
			s.setTotalgrade(totalgrade[i]);
			// query

			status = dao.insertStudentMarks(s);
			// statuslist.add(status.toString());
			if (status) {
				statuslist.add("true");
			} else {
				statuslist.add("false");
			}
		}
		if (statuslist.contains("false")) {
			request.setAttribute("msg", "Unsuccessful");
		} else {
			request.setAttribute("msg", "successful");
		}
		RequestDispatcher rd=request.getRequestDispatcher("createStudentReport.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	//student exam report
	public void getSpecificStudentReport(HttpServletRequest request, HttpServletResponse response) {
		 DecimalFormat decimal = new DecimalFormat("##.00");
		 
		Subjects s=new Subjects();
		String examid=request.getParameter("examid"),
				section=request.getParameter("section"),rollno=request.getParameter("rollno");
		
		String[] classdetail=request.getParameter("classname").split(",");
		
		RequestDispatcher rd=null;
		
		//get student admission no
		StudentDao sdao = new StudentDaoImpl();
		StudentModel student = sdao.getStudentId(classdetail[1], section, rollno);
		if(student==null){request.setAttribute("msg", "Student Not Found!");
		 rd=request.getRequestDispatcher("reportsearchbox.click");
		 try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else{
		String studentid=student.getStudentid();
		
		
		s.setStudentid(studentid);
		s.setExamid(examid);
		List<Subjects> reportlist=new ArrayList<Subjects>();
		DisplayDao dao=new DisplayDaoImpl();
		
		reportlist=dao.getSpecificStudentReport(s);
		
		if(reportlist!=null){
			StudentModel stdDetail=dao.getSpecificStudentDetails(studentid);
			StudentOperations exam=new StudentOperations();
			System.out.println(examid+studentid);
			Subjects examSummary=exam.selectSpecificExam(examid, studentid);
		
			request.setAttribute("examSummary", examSummary);
			request.setAttribute("stdDetail", stdDetail);
			request.setAttribute("reportlist", reportlist);
			
			 rd=request.getRequestDispatcher("examreport.view");
		}
		
		else{
			request.setAttribute("msg", "Report Not Found!");
			 rd=request.getRequestDispatcher("reportsearchbox.click");
			
		}
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		}
		}
		
		
	

}
