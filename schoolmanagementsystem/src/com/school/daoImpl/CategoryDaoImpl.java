package com.school.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.school.dao.CategoryDao;
import com.school.dbconnection.DbConnection;
import com.school.model.CategoryModel;

public class CategoryDaoImpl  implements CategoryDao{
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public boolean insertCategory(CategoryModel cm){
		try{
			String query="insert into categories values (?,?,?,?,?)";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, cm.getCategoryId());
			ps.setString(2, cm.getCategoryHead());
			ps.setString(3, cm.getAccountType());
			ps.setString(4, cm.getInputter());
			ps.setString(5, cm.getAuthorizer());
			int i=ps.executeUpdate();
			if(i>0){
				con.close();
				ps=null;
				return true;
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public JSONObject selectCategories(){
		 JSONObject data=new JSONObject();
		try{
			String query="select * from categories";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(!rs.next()){
				 System.out.println("0");
		        }else{
		            JSONArray array=new JSONArray();
		           
		            while(rs.next()){
		                JSONObject obj = new JSONObject();
		                obj.put("accountType",rs.getString("accountType"));
		                obj.put("authorizer",rs.getString("authorizer"));
		                obj.put("categoryHead",rs.getString("categoryHead"));
		                obj.put("categoryId",rs.getString("categoryId"));
		                obj.put("inputter",rs.getString("inputter"));
		                array.put(obj);
		            }
		            data.put("data", array);
		            return data;
		        }
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	public List<CategoryModel> getCategories(){
		String query="select * from categories";
		List<CategoryModel> list=new ArrayList<CategoryModel>();
		CategoryModel c=null;
		con=DbConnection.getConnection();
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				c=new CategoryModel();
				c.setCategoryId(rs.getString("categoryId"));
				c.setCategoryHead(rs.getString("categoryHead"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	public List<CategoryModel> accounttype(){
		List<CategoryModel> list=new ArrayList<CategoryModel>();
		CategoryModel cm=null;
		try{
			String query="select * from accounttype";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				cm=new CategoryModel();
				cm.setAccountType(rs.getString("accountType"));
				cm.setAccountHead(rs.getString("accountTypeHead"));
				list.add(cm);
			}
			if(list.size()>0){
				con.close();
				ps=null;
				rs=null;
				return list;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	public CategoryModel getSpecificCategoryDetail(String id){
		CategoryModel cm=null;
		try{
			String query="select * from categories where categoryId='"+id+"'";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()){
				cm=new CategoryModel();
				cm.setAccountType(rs.getString("accountType"));
				cm.setCategoryHead(rs.getString("categoryHead"));
				cm.setCategoryId(rs.getString("categoryId"));
				cm.setInputter(rs.getString("inputter"));
				con.close();
				ps=null;
				rs=null;
				return cm;
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public boolean deleteCategory(String id){
		try{
			String query="delete from categories where categoryId='"+id+"'";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			int i=ps.executeUpdate();
			if(i>0){
				con.close();
				ps=null;
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public boolean updateCategory(CategoryModel cm, String previousid){
		try{
			String query="update categories set categoryId=?,categoryHead=?,accountType=?,inputter=?,authorizer=? where categoryId=?";
			con=DbConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, cm.getCategoryId());
			ps.setString(2, cm.getCategoryHead());
			ps.setString(3, cm.getAccountType());
			ps.setString(4, cm.getInputter());
			ps.setString(5, cm.getAuthorizer());
			ps.setString(6, previousid);
			int i=ps.executeUpdate();
			if(i>0){
				con.close();
				ps=null;
				return true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}

}
