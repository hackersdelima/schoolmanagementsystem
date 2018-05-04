package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.LoginAction;
import com.school.model.UserModel;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel user = new UserModel();
		MainClass m = new MainClass();
		if (m.checkuser(username, password) == true) {
			HttpSession session = request.getSession(true);
			UserModel userdetail = (UserModel) m.userdetails(username, password);
			if (userdetail.getStatus().equals("1")) {
				List<UserModel> systemdetail = m.getSystemDetails(user);
				
				session.setAttribute("userdetail", userdetail);
				session.setAttribute("systemdetail", systemdetail);
				
				
				LoginAction la=new LoginAction();
				la.userlogin(request, response);
				
			} else {
				String errormsg = "Invalid login credentials!";
				request.setAttribute("errormsg", errormsg);
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
			}
		} else {
			String errormsg = "Invalid login credentials!";
			request.setAttribute("errormsg", errormsg);
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}
	}

}
