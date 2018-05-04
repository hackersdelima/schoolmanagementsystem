package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sahakari.user.dao.UserDao;
import com.sahakari.user.daoImpl.UserDaoImpl;
import com.school.dao.LoginDao;
import com.school.daoImpl.LoginDaoImpl;
import com.school.user.model.UserModel;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void userlogin(HttpServletRequest request,
			HttpServletResponse response) {
		
		UserModel u=new UserModel();
		u.setStaffCode(request.getParameter("staffCode"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		LoginDao l=new LoginDaoImpl();
		
			UserModel userDetail=l.getUserDetail(u);
		
			HttpSession session=request.getSession(true);
			session.setAttribute("userdetail", userDetail);
		
			String currentBranchcode=userDetail.getBranchCode();
			session.setAttribute("currentBranchcode", currentBranchcode);
			
			
			
			UserDao ud=new UserDaoImpl();
			String mainRole=ud.getRoleAssigned(userDetail.getGivenrole());
			session.setAttribute("mainRole", mainRole);
			System.out.println(mainRole);
			
			session.setAttribute("currentBranchFunctions", userDetail.getFunctionAllowed());
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("view/header.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	

	public void userlogout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("../index.jsp");
		try {
			rd.forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
