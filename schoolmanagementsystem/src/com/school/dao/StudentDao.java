package com.school.dao;

import com.school.model.StudentModel;
import com.school.model.Subjects;

public interface StudentDao {
	public boolean insertStudentMarks();

	public boolean insertStudentMarks(Subjects s);

	public StudentModel getStudentId(String classid, String sectionid, String rollno);
}
