package com.school.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;
import com.school.dao.JsonServices;

public class JsonServicesImpl implements JsonServices{
	public  List<JSONObject> getFormattedResultSet(ResultSet rs){
		List<JSONObject> reslist=new ArrayList<JSONObject>();
		try{
			ResultSetMetaData rsMeta=(ResultSetMetaData) rs.getMetaData();
			int colCount=rsMeta.getColumnCount();
			
			List<String> columnNames= new ArrayList<String>();
			for(int i=1;i<=colCount;i++){
				columnNames.add(rsMeta.getColumnName(i).toUpperCase());
			}
			while(rs.next()){
				JSONObject jobj=new JSONObject();
				for(int i=1;i<=colCount;i++){
					String key=columnNames.get(i - 1);
					String value=rs.getString(i);
					jobj.put(key, value);
				}
				reslist.add(jobj);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reslist;
	}
}
