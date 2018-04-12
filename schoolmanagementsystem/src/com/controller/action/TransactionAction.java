package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sahakari.transaction.dao.TransactionDao;
import com.sahakari.transaction.daoImpl.TransactionDaoImpl;
import com.school.model.TellerTransactionModel;
import com.school.model.TransactionModel;
import com.school.model.UserModel;

public class TransactionAction {

	public void addTransaction(HttpServletRequest request,
			HttpServletResponse response) {
		String Id, refNo, transactionType, valueDate,bookingDate,debitAccountNumber,debitCurrency,debitNarrative,creditAccountNumber,
		creditCurrency,creditNarative,amount,commissionCode,commissionType,commissionAmount,chequeNumber,processingDate,Override,
		recordStatus,branchCode,inputter;

		TransactionModel tm=new TransactionModel();
		Id=request.getParameter("Id");
		refNo=request.getParameter("refNo");
		transactionType=request.getParameter("transactionType");
		valueDate=request.getParameter("valueDate");
		bookingDate=request.getParameter("bookingDate");
		debitAccountNumber=request.getParameter("debitAccountNumber");
		debitCurrency=request.getParameter("debitCurrency");
		debitNarrative=request.getParameter("debitNarrative");
		creditAccountNumber=request.getParameter("creditAccountNumber");
		creditCurrency=request.getParameter("creditCurrency");
		creditNarative=request.getParameter("creditNarative");
		amount=request.getParameter("amount");
		commissionCode=request.getParameter("commissionCode");
		commissionType=request.getParameter("commissionType");
		commissionAmount=request.getParameter("commissionAmount");
		chequeNumber=request.getParameter("chequeNumber");
		Override=request.getParameter("Override");
		recordStatus=request.getParameter("recordStatus");
		branchCode=request.getParameter("branchCode");
		
		HttpSession session=request.getSession();
		UserModel userDetail=(UserModel)session.getAttribute("userdetail");
		
		inputter=userDetail.getUsername();
		
		tm.setAmount(amount);
		tm.setBookingDate(bookingDate);
		tm.setBranchCode(branchCode);
		tm.setChequeNumber(chequeNumber);
		tm.setChequeNumber(chequeNumber);
		tm.setCommissionAmount(commissionAmount);
		tm.setCommissionCode(commissionCode);
		tm.setCommissionType(commissionType);
		tm.setCreditAccountNumber(creditAccountNumber);
		tm.setCreditCurrency(creditCurrency);
		tm.setCreditNarative(creditNarative);
		tm.setDebitAccountNumber(debitAccountNumber);
		tm.setDebitCurrency(debitCurrency);
		tm.setDebitNarrative(debitNarrative);
		tm.setId(Id);
		tm.setInputter(inputter);
		tm.setOverride(Override);
		tm.setRecordStatus(recordStatus);
		tm.setRefNo(refNo);
		tm.setTransactionType(transactionType);
		tm.setValueDate(valueDate);
		
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.addTransaction(tm);
		if(status){
			request.setAttribute("msg", "Transaction Add Successful!");
		}
		else{
			request.setAttribute("msg", "Transaction Add Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("inserttransaction.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public void deTransactionAccount(HttpServletRequest request,
			HttpServletResponse response) {
		String id=request.getParameter("id");
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.addTransaction(id);
		if(status){
			request.setAttribute("msg", "Transaction Delete Successful!");
		}
		else{
			request.setAttribute("msg", "Transaction Delete Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewtransaction.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public void updateTransaction(HttpServletRequest request,
			HttpServletResponse response) {
		String Id, refNo, transactionType, valueDate,bookingDate,debitAccountNumber,debitCurrency,debitNarrative,creditAccountNumber,
		creditCurrency,creditNarative,amount,commissionCode,commissionType,commissionAmount,chequeNumber,processingDate,Override,
		recordStatus,branchCode;

		TransactionModel tm=new TransactionModel();
		Id=request.getParameter("Id");
		refNo=request.getParameter("refNo");
		transactionType=request.getParameter("transactionType");
		valueDate=request.getParameter("valueDate");
		bookingDate=request.getParameter("bookingDate");
		debitAccountNumber=request.getParameter("debitAccountNumber");
		debitCurrency=request.getParameter("debitCurrency");
		debitNarrative=request.getParameter("debitNarrative");
		creditAccountNumber=request.getParameter("creditAccountNumber");
		creditCurrency=request.getParameter("creditCurrency");
		creditNarative=request.getParameter("creditNarative");
		amount=request.getParameter("amount");
		commissionCode=request.getParameter("commissionCode");
		commissionType=request.getParameter("commissionType");
		commissionAmount=request.getParameter("commissionAmount");
		chequeNumber=request.getParameter("chequeNumber");
		processingDate=request.getParameter("processingDate");
		Override=request.getParameter("Override");
		recordStatus=request.getParameter("recordStatus");
		branchCode=request.getParameter("branchCode");
		
		tm.setAmount(amount);
		tm.setBookingDate(bookingDate);
		tm.setBranchCode(branchCode);
		tm.setChequeNumber(chequeNumber);
		tm.setChequeNumber(chequeNumber);
		tm.setCommissionAmount(commissionAmount);
		tm.setCommissionCode(commissionCode);
		tm.setCommissionType(commissionType);
		tm.setCreditAccountNumber(creditAccountNumber);
		tm.setCreditCurrency(creditCurrency);
		tm.setCreditNarative(creditNarative);
		tm.setDebitAccountNumber(debitAccountNumber);
		tm.setDebitCurrency(debitCurrency);
		tm.setDebitNarrative(debitNarrative);
		tm.setId(Id);
		tm.setOverride(Override);
		tm.setProcessingDate(processingDate);
		tm.setRecordStatus(recordStatus);
		tm.setRefNo(refNo);
		tm.setTransactionType(transactionType);
		tm.setValueDate(valueDate);
		String previousid=request.getParameter("previousid");
		
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.updateTransaction(tm,previousid);
		if(status){
			request.setAttribute("msg", "Transaction Update Successful!");
		}
		else{
			request.setAttribute("msg", "Transaction Update Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("inserttransaction.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	
	public void addmultiTransaction(HttpServletRequest request, HttpServletResponse response) {
		String 
		transactionid=request.getParameter("transactionid"),
		transactionno=request.getParameter("transactionno"),
		bookingdate=request.getParameter("bookingdate"),
		valuedate=request.getParameter("valuedate"),
		processdate=request.getParameter("processdate"),
		accountnumber=request.getParameter("accountnumber"),
		drcr=request.getParameter("drcr"),
		narrative=request.getParameter("narrative"),
		chequenumber=request.getParameter("chequenumber"),
		amount=request.getParameter("amount"),
		transactioncode=request.getParameter("transactioncode"),
		authorizer="0";
		
		
		HttpSession session =request.getSession();
		UserModel userdetail=(UserModel)session.getAttribute("userdetail");
		String inputter=userdetail.getUsername();
		
		TellerTransactionModel tm=new TellerTransactionModel();
		tm.setTransactionid(transactionid);
		tm.setTransactionno(transactionno);
		tm.setBookingdate(bookingdate);
		tm.setValuedate(valuedate);
		tm.setProcessdate(processdate);
		tm.setAccountnumber(accountnumber);
		tm.setDrcr(drcr);
		tm.setNarrative(narrative);
		tm.setAmount(amount);
		tm.setTransactioncode(transactioncode);
		tm.setInputter(inputter);
		tm.setAuthorizer(authorizer);
		tm.setChequenumber(chequenumber);
		
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.insertMultiTransaction(tm);
		System.out.println(status);
		if(status){
			request.setAttribute("msg", "Transaction Added Successfully!");
		}
		else{
			request.setAttribute("msg", "Add  Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("insertMultiTxn.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public void updateMultiTransaction(HttpServletRequest request, HttpServletResponse response) {

		String 
		transactionid=request.getParameter("transactionid"),
		transactionno=request.getParameter("transactionno"),
		bookingdate=request.getParameter("bookingdate"),
		valuedate=request.getParameter("valuedate"),
		processdate=request.getParameter("processdate"),
		accountnumber=request.getParameter("accountnumber"),
		drcr=request.getParameter("drcr"),
		narrative=request.getParameter("narrative"),
		chequenumber=request.getParameter("chequenumber"),
		amount=request.getParameter("amount"),
		transactioncode=request.getParameter("transactioncode"),
		authorizer="0";
		
		
		HttpSession session =request.getSession();
		UserModel userdetail=(UserModel)session.getAttribute("userDetail");
		String inputter=userdetail.getUsername();
		
		TellerTransactionModel tm=new TellerTransactionModel();
		tm.setTransactionid(transactionid);
		tm.setTransactionno(transactionno);
		tm.setBookingdate(bookingdate);
		tm.setValuedate(valuedate);
		tm.setProcessdate(processdate);
		tm.setAccountnumber(accountnumber);
		tm.setDrcr(drcr);
		tm.setNarrative(narrative);
		tm.setAmount(amount);
		tm.setTransactioncode(transactioncode);
		tm.setInputter(inputter);
		tm.setAuthorizer(authorizer);
		tm.setChequenumber(chequenumber);
		String previousid=request.getParameter("previousid");

		
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.updateMultiTransaction(tm,previousid);
		if(status){
			request.setAttribute("msg", "Transaction Update Successful!");
		}
		else{
			request.setAttribute("msg", "Transaction Update Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewMultiTxn.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteTellerTransaction(HttpServletRequest request,
			HttpServletResponse response) {
		String id=request.getParameter("id");
		TransactionDao td=new TransactionDaoImpl();
		boolean status=td.deleteTellerTransaction(id);
		if(status){
			request.setAttribute("msg", "Delete Successful!");
		}
		else{
			request.setAttribute("msg", "Delete  Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewteller.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	public void deleteMultiTransaction(HttpServletRequest request, HttpServletResponse response) {

		String id=request.getParameter("id");
		
		TransactionDao dao=new TransactionDaoImpl();
		boolean status=dao.deleteMultiTransaction(id);
		if(status){
			request.setAttribute("msg", "Delete Successful!");
		}
		else{
			request.setAttribute("msg", "Delete  Failed!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewMultiTxn.click");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}



}
