package com.cykj.easy.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cykj.easy.entity.UserTest;


//声明此类为数据持久层的类
@Repository("iUserDao")
public class UserDao implements IUserDao {
	
	@Resource(name = "sessionFactory")  
	private SessionFactory sessionFactory;

	public void save(UserTest user) {
		getSession().save(user);
	}

	public void delete(int id) {
		getSession().delete(getSession().load(UserTest.class, id));
	}

	public void update(UserTest user) {
		getSession().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<UserTest> query() {
		return getSession().createQuery("From UserTest").list();
	}

	public UserTest get(int id) {
		return (UserTest) getSession().get(UserTest.class, id);
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession()/*openSession()*/;
		
	}

}
