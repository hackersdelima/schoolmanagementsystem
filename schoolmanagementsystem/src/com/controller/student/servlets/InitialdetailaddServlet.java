package com.controller.student.servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.StudentOperations;
@WebServlet("/InitialdetailaddServlet")
public class InitialdetailaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String languagename,castename,sectionname,housegroupname, specialinterestname,classname,companydb;
		companydb=request.getParameter("companydb");
		languagename=request.getParameter("languagename");
		castename=request.getParameter("castename");
		sectionname=request.getParameter("sectionname");
		housegroupname=request.getParameter("housegroupname");
		specialinterestname=request.getParameter("specialinterestname");
		classname=request.getParameter("classname");
		StudentOperations s=new StudentOperations();
		if(languagename!=null ){
			s.addlanguage(languagename);
		}
		else if(castename!=null){
			s.addcaste(castename);
			
		}
		else if(sectionname!=null){
			s.addsection(sectionname);
			
		}
		else if(housegroupname!=null){
			s.addhousegroup(housegroupname);
		}
		else if(specialinterestname!=null){
			s.addspecialinterest(specialinterestname);
		}
		else if(classname!=null){
			s.addclass(classname);
		}
		request.setAttribute("msg", "Successful!");
		RequestDispatcher rd=request.getRequestDispatcher("initialdetailsjsp");
		rd.forward(request,response);		}

}
