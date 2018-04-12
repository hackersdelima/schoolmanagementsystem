package com.school.model;

public class TellerTransactionModel {
	String transactionid,bookingdate,valuedate,processdate,debitaccountnumber,creditaccountnumber,narrative,chequenumber,amount,transactioncode,branchid,inputter,authorizer;

	String transactionno,drcr,accountnumber;//for multi txn

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}


	
	public String getTransactionno() {
		return transactionno;
	}

	public void setTransactionno(String transactionno) {
		this.transactionno = transactionno;
	}

	public String getDrcr() {
		return drcr;
	}

	public void setDrcr(String drcr) {
		this.drcr = drcr;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}


	public String getValuedate() {
		return valuedate;
	}

	public void setValuedate(String valuedate) {
		this.valuedate = valuedate;
	}

	public String getProcessdate() {
		return processdate;
	}

	public void setProcessdate(String processdate) {
		this.processdate = processdate;
	}

	public String getDebitaccountnumber() {
		return debitaccountnumber;
	}

	public void setDebitaccountnumber(String debitaccoutnumber) {
		this.debitaccountnumber = debitaccoutnumber;
	}

	public String getCreditaccountnumber() {
		return creditaccountnumber;
	}

	public void setCreditaccountnumber(String creditaccountnumber) {
		this.creditaccountnumber = creditaccountnumber;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public String getChequenumber() {
		return chequenumber;
	}

	public void setChequenumber(String chequenumber) {
		this.chequenumber = chequenumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactioncode() {
		return transactioncode;
	}

	public void setTransactioncode(String transactioncode) {
		this.transactioncode = transactioncode;
	}

	public String getInputter() {
		return inputter;
	}

	public void setInputter(String inputter) {
		this.inputter = inputter;
	}

	public String getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}
}
