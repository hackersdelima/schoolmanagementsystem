package com.school.dao;

import java.util.List;

import com.school.model.Subjects;

public interface DisplayDao  {

	public List<Subjects> getClassSubjects(String classid);
}
