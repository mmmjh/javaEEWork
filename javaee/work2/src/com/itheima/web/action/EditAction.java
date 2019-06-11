package com.itheima.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.zrdm.dao.UserDao;
import com.zrdm.sql.UserBean;

/**
 * 我们的第一个动作类。
 * 动作类：
 *    它就是一个概念。它就是struts2框架中用于处理请求的类。
 *    我们以后处理请求都写动作类。
 * @author zhy
 *
 */
public class EditAction {

	private HttpServletRequest request;
	 private UserDao us = new UserDao();
	 private int id;
	 private String username;
	 private UserBean user;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("static-access")
	public String edit() throws Exception {	
		user=new UserBean();
		user.setUserid(id);
		user.setUsername(username);
		us.update(id, user);
		System.out.println("查询方法执行了。。。。"+this);
		return "success";
		
	}
}
