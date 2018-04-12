package com.school.dao;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.school.model.CategoryModel;

public interface CategoryDao {
	public List<CategoryModel> accounttype();
	public boolean insertCategory(CategoryModel cm);
	public JSONObject selectCategories();
	public List<CategoryModel> getCategories();
	public CategoryModel getSpecificCategoryDetail(String id);
	public boolean deleteCategory(String id);
	public boolean updateCategory(CategoryModel cm, String previousid);
	

}
