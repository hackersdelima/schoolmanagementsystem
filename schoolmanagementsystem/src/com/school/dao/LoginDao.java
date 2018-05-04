package com.school.dao;

import com.school.user.model.UserModel;


public interface LoginDao {
	public boolean checkuser(UserModel u);
	public UserModel getUserDetail(UserModel u);

}
