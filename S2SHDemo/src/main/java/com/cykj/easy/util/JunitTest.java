package com.cykj.easy.util;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cykj.easy.dao.IUserDao;
import com.cykj.easy.entity.UserTest;
import com.cykj.easy.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "/applicationContext.xml" })
public class JunitTest {

	@Resource(name = "iUserDao")
	private IUserDao iUserDao;

	@Autowired
	private LoginService loginService;

	@Test
	public void testSelect() {
		try {

			// List<UserTest> list= iUserDao.query();//可以使用

			List<UserTest> list = loginService.queryData();
			for (UserTest c : list) {
				System.out.println("name:" + c.getName() + ",id:" + c.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testQuery() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"/applicationContext.xml");
			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
			String hql = "select id,name from UserTest";
			Query query = sessionFactory.openSession().createQuery(hql);

			List<UserTest> list = (List<UserTest>)query.list();
			if(list.size() < 0) {
				throw new Exception("查询结果为空！");
			}
			for (UserTest c : list) {
				System.out.println("----name:" + c.getName() + ",id:" + c.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
//		Object la = context.getBean("loginAction");
//		System.out.println("====la：" + la);

	}

}
