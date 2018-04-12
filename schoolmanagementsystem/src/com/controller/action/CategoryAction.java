package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.dao.CategoryDao;
import com.school.daoImpl.CategoryDaoImpl;
import com.school.model.CategoryModel;
import com.school.model.UserModel;

public class CategoryAction {
	public void addCategory(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		UserModel userdetail=(UserModel)session.getAttribute("userdetail");
		
		CategoryModel cm=new CategoryModel();
		String 
		categoryId=request.getParameter("categoryId"), 
		categoryHead=request.getParameter("categoryHead"), 
		accountType=request.getParameter("accountType"),
		authorizer=request.getParameter("authorizer"),
		inputter=userdetail.getUsername();
		
		cm.setAccountType(accountType);
		cm.setAuthorizer(authorizer);
		cm.setCategoryHead(categoryHead);
		cm.setCategoryId(categoryId);
		cm.setInputter(inputter);
		
		boolean status=false;
		CategoryDao c=new CategoryDaoImpl();
		status=c.insertCategory(cm);
		if(status){
			request.setAttribute("msg", "Save successful!");
		}
		else{
			request.setAttribute("msg", "Save unsuccessful!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("category.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	
	}

	public void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) {
		String id=request.getParameter("id");
		CategoryDao c=new CategoryDaoImpl();
		boolean status=false;
		status=c.deleteCategory(id);
		if(status){
			request.setAttribute("msg", "Delete successful!");
		}
		else{
			request.setAttribute("msg", "Delete unsuccessful!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("category.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public void updateCategory(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		UserModel userdetail=(UserModel)session.getAttribute("userdetail");
		
		CategoryModel cm=new CategoryModel();
		String 
		categoryId=request.getParameter("categoryId"), 
		categoryHead=request.getParameter("categoryHead"), 
		accountType=request.getParameter("accountType"),
		authorizer=request.getParameter("authorizer"),
		inputter=userdetail.getUsername();
		
		String previousid=request.getParameter("previousid");
		cm.setAccountType(accountType);
		cm.setAuthorizer(authorizer);
		cm.setCategoryHead(categoryHead);
		cm.setCategoryId(categoryId);
		cm.setInputter(inputter);
		
		boolean status=false;
		CategoryDao c=new CategoryDaoImpl();
		status=c.updateCategory(cm,previousid);
		if(status){
			request.setAttribute("msg", "Update successful!");
		}
		else{
			request.setAttribute("msg", "Update unsuccessful!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("category.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
