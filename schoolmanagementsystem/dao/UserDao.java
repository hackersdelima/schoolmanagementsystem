package com.sahakari.user.dao;

import java.util.List;

import com.sahakari.model.UserModel;

public interface UserDao {

	public boolean adduserdao(UserModel u);
	
	public boolean deleteuserdao(String userid);

	public UserModel edituserdao(String userid);

	public List<UserModel> getexistingusers();

	public boolean updateuserdao(UserModel usermodel);
	public String getRoleAssigned(String name);

	public List<String> getRoleName();

	public List<UserModel> getBranchList();

	public boolean insertusergroup(String groupname, String givenRoles);

	public boolean checkUserGroup(String parameter);

}
