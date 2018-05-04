package com.sahakari.user.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Generator;
import com.sahakari.user.dao.UserDao;
import com.sahakari.user.daoImpl.UserDaoImpl;
import com.school.user.model.UserModel;

public class UserAction {

	public void adduseraction(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username"), givenrole = request
				.getParameter("givenRole"), password = request
				.getParameter("username"), status = "1", fullName = request
				.getParameter("fullName"), post = request.getParameter("post"), staffCode = request
				.getParameter("staffCode"), startDate = request
				.getParameter("startDate"), endDate = request
				.getParameter("endDate"), branchCode = request
				.getParameter("branchCode"), roleName = request
				.getParameter("roleName"), functionRestriction = request
				.getParameter("branchAllowed"),
				functionAllowed=request.getParameter("functionAllowed");
		Generator g=new Generator();
		functionAllowed=g.addHash(functionAllowed);

		String[] branchArray = request.getParameterValues("branchAllowed");
		String branchAllowed = Arrays.toString(branchArray).replace("[", "")
				.replace("]", "");
		
		String[] additionalFunctionsArray=request.getParameterValues("additionalFunctions");
		String additionalFunctions=Arrays.toString(additionalFunctionsArray).replace("[", "")
				.replace("]", "");
		
		UserModel u = new UserModel();
		u.setUsername(username);
		u.setGivenrole(givenrole);
		u.setPassword(password);
		u.setStatus(status);
		u.setFullName(fullName);
		u.setPost(post);
		u.setStaffCode(staffCode);
		u.setStartDate(startDate);
		u.setEndDate(endDate);
		u.setBranchCode(branchCode);
		u.setRoleName(roleName);
		u.setFunctionAllowed(functionAllowed);
		u.setFunctionRestriction(functionRestriction);
		u.setBranchAllowed(branchAllowed);
		u.setAdditionalFunctions(additionalFunctions);
		

		UserDao userdao = new UserDaoImpl();
		boolean stats = userdao.adduserdao(u);

		if (stats) {
			request.setAttribute("msg", "User Created Successfully");
			request.setAttribute("username", username);

			try {
				RequestDispatcher rd = request
						.getRequestDispatcher("adduser.user");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("user error");
			}
		}

	}

	public void deleteuseraction(HttpServletRequest request,
			HttpServletResponse response) {

		String userid = request.getParameter("userid");

		UserDao userdao = new UserDaoImpl();
		boolean status = userdao.deleteuserdao(userid);
		if (status) {
			request.setAttribute("msg", "User Deleted Success");
			RequestDispatcher rd = request
					.getRequestDispatcher("deleteusernav.user");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void edituseraction(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String[] name = request.getParameterValues("roles");
		String roles = Arrays.toString(name).replace("[", "").replace("]", "");

		UserDao userdao = new UserDaoImpl();
		UserModel useredit = new UserModel();
		useredit = userdao.edituserdao(userid);

		if (useredit != null) {
			List<UserModel> userInfo=userdao.getexistingusers();
			request.setAttribute("userInfo",userInfo);
			
			List<String> rolename=userdao.getRoleName();
			request.setAttribute("rolename", rolename);
			
			List<UserModel> branchlist=userdao.getBranchList();
			request.setAttribute("branchlist", branchlist);
			
			request.setAttribute("update", "update");
			request.setAttribute("updatebtn", "showupdatebutton");
			request.setAttribute("useredit", useredit);
			
			RequestDispatcher rd = request.getRequestDispatcher("view/UserSetting/edituser.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateuseraction(HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username"), givenrole = request
				.getParameter("givenRole"), password = request
				.getParameter("username"), status = "1", fullName = request
				.getParameter("fullName"), post = request.getParameter("post"), staffCode = request
				.getParameter("staffCode"), startDate = request
				.getParameter("startDate"), endDate = request
				.getParameter("endDate"), branchCode = request
				.getParameter("branchCode"), roleName = request
				.getParameter("roleName"), functionRestriction = request
				.getParameter("branchAllowed"),
				functionAllowed=request.getParameter("functionAllowed");
		System.out.println("function is "+functionAllowed);
		String userid = request.getParameter("useridforupdate");
		
		Generator g=new Generator();
		functionAllowed=g.addHash(functionAllowed);

		String[] branchArray = request.getParameterValues("branchAllowed");
		String branchAllowed = Arrays.toString(branchArray).replace("[", "")
				.replace("]", "");
		
		String[] additionalFunctionsArray=request.getParameterValues("additionalFunctions");
		String additionalFunctions=Arrays.toString(additionalFunctionsArray).replace("[", "")
				.replace("]", "");
		
		UserModel u = new UserModel();
		u.setUsername(username);
		u.setGivenrole(givenrole);
		u.setPassword(password);
		u.setStatus(status);
		u.setFullName(fullName);
		u.setPost(post);
		u.setStaffCode(staffCode);
		u.setStartDate(startDate);
		u.setEndDate(endDate);
		u.setBranchCode(branchCode);
		u.setRoleName(roleName);
		u.setFunctionAllowed(functionAllowed);
		u.setFunctionRestriction(functionRestriction);
		u.setBranchAllowed(branchAllowed);
		u.setAdditionalFunctions(additionalFunctions);
		u.setUserid(userid);
		
		UserDao userdao = new UserDaoImpl();
		boolean stats = userdao.updateuserdao(u);

		if (stats) {
			request.setAttribute("msg", "User Details Updated");
			RequestDispatcher rd = request.getRequestDispatcher("adduser.user");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
		

	}

	public void insertusergroup(HttpServletRequest request,
			HttpServletResponse response) {
		String[] givenRolesArray=request.getParameterValues("givenRoles");
		String givenRoles=Arrays.toString(givenRolesArray).replace("[", "")
				.replace("]", "");
		String groupname=request.getParameter("groupname");
		
		UserDao user=new UserDaoImpl();
		boolean status=user.insertusergroup(groupname,givenRoles);
		if(status){
			request.setAttribute("msg", "Group added successfully!");
			try {
				request.getRequestDispatcher("addusergroup.user").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			};
		}
			
		
		
	}

}
