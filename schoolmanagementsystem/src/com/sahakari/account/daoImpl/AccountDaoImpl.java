package com.sahakari.account.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sahakari.account.dao.AccountDao;
import com.school.dbconnection.DbConnection;
import com.school.model.AccountModel;


public class AccountDaoImpl implements AccountDao{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int i=0;
	public String selectAccountTypeFromCategory(String categoryId){
		String accountType="";
		try{
			String query="select accountType from categories where categoryId=?";
			
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, categoryId);
			rs=ps.executeQuery();
			if(rs.next()){
				accountType=rs.getString("accountType");
				con.close();
				ps=null;
				rs=null;
				return accountType;
			}
			
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	public AccountModel getAccountTypes(String accountType){
		String query="select * from accounttype where accountType=?";
		AccountModel am=null;
		try{
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, accountType);
			rs=ps.executeQuery();
			if(rs.next()){
				am=new AccountModel();
				am.setAccountType(rs.getString("accountType"));
				am.setAccountTypeHead(rs.getString("accountTypeHead"));
				con.close();
				ps=null;
				rs=null;
				return am;
			}
			
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	public List<AccountModel> getCategories(){
		List<AccountModel> list=new ArrayList<AccountModel>();
		String query="select * from categories";
		AccountModel am=null;
		try{
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				am=new AccountModel();
				am.setCategoryId(rs.getString("categoryId"));
				am.setCategoryHead(rs.getString("categoryHead"));
				list.add(am);
			}
			if(list.size()>0){
				con.close();
				ps=null;
				rs=null;
				return list;
			}
		}catch(Exception e){System.out.println(e);}
		return null;
	}
	public String selectpid(AccountModel am){
		String pid="";
		try{
			String query="select pid from customertbl where memberid=?";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, am.getMemberid());
			rs=ps.executeQuery();
			if(rs.next()){
				pid=rs.getString("pid");
				con.close();
				ps=null;
				rs=null;
				return pid;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public boolean insertAccount(AccountModel am){
		try{
		String query="insert into accountstbl (accountNumber, pid, alternativeAccountId, categoryId, accountType, accountName, limitRef, inputter) values (?,?,?,?,?,?,?,?)";
		con=DbConnection.getConnection();
		ps=con.prepareStatement(query);
		ps.setString(1, am.getAccountNumber());
		ps.setString(2, am.getPid());
		ps.setString(3, am.getAlternativeAccounId());
		ps.setString(4, am.getCategoryId());
		ps.setString(5, am.getAccountType());
		ps.setString(6, am.getAccountName());
		ps.setString(7, am.getLimitRef());
		ps.setString(8,am.getInputter());
		i=ps.executeUpdate();
		if(i>0){
			con.close();
			ps=null;
			i=0;
			return true;
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}		return false;
	}
	public List<AccountModel> viewAccount(){
		String query="select * from accountstbl";
		List<AccountModel> list=new ArrayList<AccountModel>();
		AccountModel am=null;
		try{
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				am=new AccountModel();
				am.setOpeningBal(rs.getString("openingBal"));
				am.setAccountNumber(rs.getString("accountNumber"));
				am.setPid(rs.getString("pid"));
				am.setAlternativeAccounId(rs.getString("alternativeAccountId"));
				am.setAccountType(rs.getString("accountType"));
				am.setAccountName(rs.getString("accountName"));
				am.setLimitRef(rs.getString("limitRef"));
				list.add(am);
			}
			if(list.size()>0){
				con.close();
				ps=null;
				rs=null;
				return list;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public boolean deleteAccount(String accountNumber){
		try{
			int i;
			String query="delete from accountstbl where accountNumber=?";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, accountNumber);
			i=ps.executeUpdate();
			if(i>0){
				con.close();
				ps=null;
				return true;
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}
	public AccountModel getAccountDetail(String accountNumber){
		String query="select * from accountstbl where accountNumber=?";
		AccountModel am=null;
		try{
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, accountNumber);
			rs=ps.executeQuery();
			if(rs.next()){
				am=new AccountModel();
				am.setAccountNumber(rs.getString("accountNumber"));
				am.setPid(rs.getString("pid"));
				am.setAlternativeAccounId(rs.getString("alternativeAccountId"));
				am.setCategoryId(rs.getString("categoryId"));
				am.setAccountType(rs.getString("accountType"));
				am.setAccountName(rs.getString("accountName"));
				am.setLimitRef(rs.getString("limitRef"));
				return am;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public boolean updateAccount(AccountModel am){
		try{
			String query="update accountstbl set accountNumber=?,pid=?,alternativeAccountId=?,categoryId=?,accountType=?,accountName=?,limitRef=? where accountNumber=?";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, am.getAccountNumber());
			ps.setString(2, am.getPid());
			ps.setString(3, am.getAlternativeAccounId());
			ps.setString(4, am.getCategoryId());
			ps.setString(5, am.getAccountType());
			ps.setString(6, am.getAccountName());
			ps.setString(7, am.getLimitRef());
			ps.setString(8, am.getPreviousAccountNumber());
			i=ps.executeUpdate();
			if(i>0){
				con.close();
				ps=null;
				i=0;
				return true;
			}
		}catch(Exception e){System.out.println(e);}
		return false;
	}
}
