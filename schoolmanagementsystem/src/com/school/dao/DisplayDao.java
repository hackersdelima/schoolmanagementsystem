package com.school.dao;

import java.util.List;

import com.school.model.StudentModel;
import com.school.model.Subjects;

public interface DisplayDao {

	public List<Subjects> getClassSubjects(String classid);

	public List<Subjects> getSpecificStudentReport(Subjects s);
	public StudentModel getSpecificStudentDetails(String studentid);

}
