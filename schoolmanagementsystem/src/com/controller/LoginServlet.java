package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String schooldb="";
		MainClass m=new MainClass();
		if(m.checkmaindb(username, password)==true){
			HttpSession session=request.getSession(true);
			ResultSet userdetail=m.userdetails(username, password);
			session.setAttribute("userdetail", userdetail);
				try {
					if(userdetail.next()==true){
						schooldb=userdetail.getString("companydb");
					}
				} catch (SQLException e) {
					System.out.println("getting schooldb error"+e);
				}
			m.connectschooldb(schooldb);
			RequestDispatcher rs=request.getRequestDispatcher("view/header.jsp");
			rs.forward(request,response);
		}
		else{
			String errormsg="Invalid login credentials!";
			request.setAttribute("errormsg", errormsg);
			RequestDispatcher rs=request.getRequestDispatcher("view/index.jsp");
			rs.forward(request,response);
		}
	}

}
