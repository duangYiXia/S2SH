package com.cykj.easy.dao;

import java.util.List;

import com.cykj.easy.entity.UserTest;


public interface IUserDao {

	public void save(UserTest user);

	public void delete(int id);

	public void update(UserTest user);

	public List<UserTest> query();

	public UserTest get(int id);

}
