package com.cykj.easy.service;

import java.util.List;

import com.cykj.easy.entity.UserTest;

public interface LoginService {
	public List<UserTest> queryData();
	public void insertUser(UserTest test);
}
