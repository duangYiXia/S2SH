package com.cykj.easy.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.cykj.easy.entity.UserTest;
import com.cykj.easy.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default-package")
@Action(value = "loginAction")
@Results({ @Result(name = "success", location = "/WEB-INF/login.jsp"),
		@Result(name = "register", location = "/register.jsp"), @Result(name = "insertOk", location = "/success.jsp") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2420332025324729781L;

	// @Resource(name="loginServiceImpl")
	@Autowired
	private LoginService loginService;

	@Action(value = "goLogin")

	public String login() throws java.lang.Exception {
		System.out.println("----------------------进来登录action");
		try {
			System.out.println("---------------------service=" + loginService);
			List<UserTest> users = loginService.queryData();
			System.out.println("userlist=" + users.size());
			ServletActionContext.getRequest().setAttribute("users", users);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			throw new java.lang.Exception();
		}

		return "success";
	}

	@Action("goRegister")
	public String goRegister() {
		System.out.println("----------------------进来注册action");

		return "register";
	}

	@Action("saveUesr") // 方法必须都是无参的，否则报找不到这个方法错误
	public String saveUesr() {
		System.out.println("----------------------进来保存action");
		HttpServletRequest request = ServletActionContext.getRequest();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("u:" + username + ",p:" + password);
		UserTest test = new UserTest();
		//test.setId(55L);
		test.setName(username);
		test.setPassword(password);
		loginService.insertUser(test);
		request.setAttribute("username", username);
		return "insertOk";
	}

}