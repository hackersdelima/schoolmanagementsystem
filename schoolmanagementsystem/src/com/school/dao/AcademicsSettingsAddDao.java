package com.school.dao;

import java.sql.SQLException;

import com.controller.student.classes.Model;

public interface AcademicsSettingsAddDao {
	
	public boolean assignsubject(Model m) throws SQLException;
}
