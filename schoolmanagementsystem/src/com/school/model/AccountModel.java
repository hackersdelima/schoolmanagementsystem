package com.school.model;

public class AccountModel {
	String pid, memberid, accountNumber,alternativeAccounId, accountName, limitRef, inputter, openingBal;
	String interestType,
	interestRate,principalAmount, startDateNP, startDateEn, maturityDateNP, maturityDateEn, repaymentStartDateNp, repaymentStartDateEn,
	repaymentFrequency, loanDrawdownAc,chargeDebitAc,chargeAmount,chargePaymentDate,interestLiqAccount,principalLiqAccount;
	public String getPrincipalLiqAccount() {
		return principalLiqAccount;
	}

	public void setPrincipalLiqAccount(String principalLiqAccount) {
		this.principalLiqAccount = principalLiqAccount;
	}

	public String getInterestLiqAccount() {
		return interestLiqAccount;
	}

	public void setInterestLiqAccount(String interestLiqAccount) {
		this.interestLiqAccount = interestLiqAccount;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(String principalAmount) {
		this.principalAmount = principalAmount;
	}

	public String getStartDateNP() {
		return startDateNP;
	}

	public void setStartDateNP(String startDateNP) {
		this.startDateNP = startDateNP;
	}

	public String getStartDateEn() {
		return startDateEn;
	}

	public void setStartDateEn(String startDateEn) {
		this.startDateEn = startDateEn;
	}

	public String getMaturityDateNP() {
		return maturityDateNP;
	}

	public void setMaturityDateNP(String maturityDateNP) {
		this.maturityDateNP = maturityDateNP;
	}

	public String getMaturityDateEn() {
		return maturityDateEn;
	}

	public void setMaturityDateEn(String maturityDateEn) {
		this.maturityDateEn = maturityDateEn;
	}

	public String getRepaymentStartDateNp() {
		return repaymentStartDateNp;
	}

	public void setRepaymentStartDateNp(String repaymentStartDateNp) {
		this.repaymentStartDateNp = repaymentStartDateNp;
	}

	public String getRepaymentStartDateEn() {
		return repaymentStartDateEn;
	}

	public void setRepaymentStartDateEn(String repaymentStartDateEn) {
		this.repaymentStartDateEn = repaymentStartDateEn;
	}

	public String getRepaymentFrequency() {
		return repaymentFrequency;
	}

	public void setRepaymentFrequency(String repaymentFrequency) {
		this.repaymentFrequency = repaymentFrequency;
	}

	public String getLoanDrawdownAc() {
		return loanDrawdownAc;
	}

	public void setLoanDrawdownAc(String loanDrawdownAc) {
		this.loanDrawdownAc = loanDrawdownAc;
	}

	public String getChargeDebitAc() {
		return chargeDebitAc;
	}

	public void setChargeDebitAc(String chargeDebitAc) {
		this.chargeDebitAc = chargeDebitAc;
	}

	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getChargePaymentDate() {
		return chargePaymentDate;
	}

	public void setChargePaymentDate(String chargePaymentDate) {
		this.chargePaymentDate = chargePaymentDate;
	}

	public String getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(String openingBal) {
		this.openingBal = openingBal;
	}

	String categoryId, categoryHead;
	String accountType, accountTypeHead;
	String previousAccountNumber;

	public String getPreviousAccountNumber() {
		return previousAccountNumber;
	}

	public void setPreviousAccountNumber(String previousAccountNumber) {
		this.previousAccountNumber = previousAccountNumber;
	}

	public String getAccountTypeHead() {
		return accountTypeHead;
	}

	public void setAccountTypeHead(String accountTypeHead) {
		this.accountTypeHead = accountTypeHead;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCategoryHead() {
		return categoryHead;
	}

	public void setCategoryHead(String categoryHead) {
		this.categoryHead = categoryHead;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPid() {
		return pid;
	}

	public String getInputter() {
		return inputter;
	}

	public void setInputter(String inputter) {
		this.inputter = inputter;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getAlternativeAccounId() {
		return alternativeAccounId;
	}

	public void setAlternativeAccounId(String alternativeAccounId) {
		this.alternativeAccounId = alternativeAccounId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getLimitRef() {
		return limitRef;
	}

	public void setLimitRef(String limitRef) {
		this.limitRef = limitRef;
	} 
}
