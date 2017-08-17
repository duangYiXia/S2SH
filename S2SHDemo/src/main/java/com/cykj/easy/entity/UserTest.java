package com.cykj.easy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TEST")
public class UserTest implements Serializable {

	private static final long serialVersionUID = -6243282827039976872L;

	// ID
	private Long id;

	// 用戶名
	private String name;
	
	// 密碼
	private String password;


	@Id
	@GeneratedValue  //表格中没有值  id从1开始递增,表格中有值从id的最大值作为初始值递增
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 20, nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "password", length = 20, nullable = false, unique = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
