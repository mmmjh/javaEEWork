package com.itheima.web.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zrdm.dao.*;
import com.zrdm.sql.*;
/**
 * 我们的第一个动作类。
 * 动作类：
 *    它就是一个概念。它就是struts2框架中用于处理请求的类。
 *    我们以后处理请求都写动作类。
 * @author zhy
 *
 */
public class MainAction extends ActionSupport implements ServletRequestAware {
	 private HttpServletRequest request;
	 private UserDao us = new UserDao();
	 private UserBean user;
	 private List<UserBean> list;
	 private String id;
	 private String username;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;	
	}
	public String add(){
		user=new UserBean();
		System.out.println(id);
		user.setUsername(username);
		user.setUserid(Integer.parseInt(id));
		us.add(user);
		System.out.println("增加方法执行了。。。。"+this);
		return "success";
	}
	public String list(){
		user=new UserBean();
		list = us.getList();
		
		List<UserBean> students = list;
		for(UserBean user : students ) {
			System.out.println(user.getUserid());
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("students", students);
		System.out.println("列表方法执行了。。。。"+this);
		return "success";
	}

}
