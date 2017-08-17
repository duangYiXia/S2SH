package com.cykj.easy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cykj.easy.dao.IUserDao;
import com.cykj.easy.entity.UserTest;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	// @Resource(name="iUserDao")
	@Autowired
	private IUserDao iUserDao;

	public List<UserTest> queryData() {
		return iUserDao.query();
	}

	public void insertUser(UserTest test) {
		iUserDao.save(test);
	}
}