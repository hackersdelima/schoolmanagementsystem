package com.school.dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.student.classes.Model;
import com.school.academic.model.ClassModel;

public interface AcademicsSettingsAddDao {
	
	public boolean assignsubject(Model m) throws SQLException;

	public void assigncourse(HttpServletRequest request, HttpServletResponse response);

	public List<ClassModel> getclasslist(HttpServletRequest request, HttpServletResponse response);
}
