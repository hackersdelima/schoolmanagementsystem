package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sahakari.account.dao.AccountDao;
import com.sahakari.account.daoImpl.AccountDaoImpl;
import com.school.model.AccountModel;
import com.school.model.UserModel;


public class AccountAction {

	public void addAccount(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		UserModel userDetail=(UserModel)session.getAttribute("userdetail");
		String inputter=userDetail.getUsername();
		
		String pid,accountNumber, alternativeAccounId, categoryId, accountType, accountName, limitRef;
		pid=request.getParameter("pid");
		accountNumber=request.getParameter("accountNumber");
		alternativeAccounId=request.getParameter("alternativeAccounId");
		categoryId=request.getParameter("categoryId");
		accountType=request.getParameter("accountType");
		accountName=request.getParameter("accountName");
		limitRef=request.getParameter("limitRef");
		AccountModel am=new AccountModel();
		am.setPid(pid);
		//am.setMemberid(memberid);
		am.setAccountNumber(accountNumber);
		am.setAlternativeAccounId(alternativeAccounId);
		am.setCategoryId(categoryId);
		am.setAccountType(accountType);
		am.setAccountName(accountName);
		am.setLimitRef(limitRef);
		am.setInputter(inputter);
		
		AccountDao a=new AccountDaoImpl();
		
		/*pid=a.selectpid(am);
		am.setPid(pid);
		*/
		boolean status=a.insertAccount(am);
		if(status){
			request.setAttribute("msg", "Account Add Successful !");
		}
		else{
			request.setAttribute("msg", "Account Add Failed !");
		}
		RequestDispatcher rd=request.getRequestDispatcher("insertaccount.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) {
		String accountNumber=request.getParameter("id");
		AccountDao a=new AccountDaoImpl();
		boolean status=a.deleteAccount(accountNumber);
		if(status){
			request.setAttribute("msg", "Delete Successful !");
		}
		else{
			request.setAttribute("msg", "Delete Failed !");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewaccount.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void updateAccount(HttpServletRequest request,
			HttpServletResponse response) {
		
		String previousAccountNumber, pid, memberid,accountNumber, alternativeAccounId, categoryId, accountType, accountName, limitRef;
		previousAccountNumber=request.getParameter("previousAccountNumber");
		pid=request.getParameter("pid");
		accountNumber=request.getParameter("accountNumber");
		alternativeAccounId=request.getParameter("alternativeAccounId");
		categoryId=request.getParameter("categoryId");
		accountType=request.getParameter("accountType");
		accountName=request.getParameter("accountName");
		limitRef=request.getParameter("limitRef");
		AccountModel am=new AccountModel();
		am.setPreviousAccountNumber(previousAccountNumber);
		am.setPid(pid);
		am.setAccountNumber(accountNumber);
		am.setAlternativeAccounId(alternativeAccounId);
		am.setCategoryId(categoryId);
		am.setAccountType(accountType);
		am.setAccountName(accountName);
		am.setLimitRef(limitRef);
		
		AccountDao a=new AccountDaoImpl();
		
		boolean status=a.updateAccount(am);
		if(status){
			request.setAttribute("msg", "Update Successful !");
		}
		else{
			request.setAttribute("msg", "Update Failed !");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewaccount.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	

}
