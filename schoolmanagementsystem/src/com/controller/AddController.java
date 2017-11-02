package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.AcademicsSettingsAction;
import com.controller.student.classes.Model;
import com.controller.student.classes.StudentOperations;
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		String uri=request.getRequestURI();
		HttpSession session=request.getSession(true);
		ResultSet rs=(ResultSet)session.getAttribute("userdetail");
		String companydb ="";
		try {
			companydb = rs.getString("companydb");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Model m=new Model();
		StudentOperations s=new StudentOperations(companydb);
		if(uri.endsWith("examtype.add"))
		{
			try {
				String examtypename,description;
				examtypename=request.getParameter("examtypename");
				description=request.getParameter("description");
				s.addexamtype(examtypename, description);
				response.sendRedirect("profile#!/initialdetails");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(uri.endsWith("exam.add"))
		{
			m.setExamname(request.getParameter("examname"));
			m.setExamtype(request.getParameter("examtype"));
			m.setStartdate(request.getParameter("startdate"));
			try {
				status=s.createnewexam(m);
				if(status){
				response.getOutputStream().println("<script>alert('SUCCESSFUL!');window.location.href = 'profile#!/createexam';</script>");
				}
				else{
					response.getOutputStream().println("<script>alert('UNSUCCESSFUL!');window.location.href = 'profile#!/createexam';</script>");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(uri.endsWith("assignsubjects.add")){
				request.setAttribute("companydb", companydb);
					AcademicsSettingsAction asa=new AcademicsSettingsAction();
					ArrayList statuslist=new ArrayList();
					try {
						statuslist=asa.assignsubjects(request,response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if(statuslist.contains(false)) {
						response.getOutputStream().println("<script>alert('UNSUCCESSFUL!');window.location.href = 'profile#!/assignsubjects';</script>");
					}
					else{
						response.getOutputStream().println("<script>alert('SUCCESSFUL!');window.location.href = 'profile#!/assignsubjects';</script>");
					}
		}
	
	}

}
