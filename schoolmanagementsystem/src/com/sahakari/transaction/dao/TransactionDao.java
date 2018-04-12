package com.sahakari.transaction.dao;

import java.util.List;

import com.school.model.TellerTransactionModel;
import com.school.model.TransactionModel;



public interface TransactionDao {

	public List<TellerTransactionModel> getMultiTransaction();
	public TellerTransactionModel getMultiTransactionDetail(String id);
	public boolean addTransaction(TransactionModel tm);
	public boolean addTransaction(String id);
	
	public boolean insertMultiTransaction(TellerTransactionModel tm);
	public boolean deleteTellerTransaction(String id);
	
	
	public List<TransactionModel> gettransactions();
	public TransactionModel getTransactionDetail(String id);
	public boolean updateMultiTransaction(TellerTransactionModel tm, String previousid);
	
	public boolean updateTransaction(TransactionModel tm,String id);

	public boolean deleteMultiTransaction(String id);


	

	

}
