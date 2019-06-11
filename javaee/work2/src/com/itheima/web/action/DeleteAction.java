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
public class DeleteAction {

	private HttpServletRequest request;
	 private UserDao us = new UserDao();
	 private int stId;
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	@SuppressWarnings("static-access")
	public String delete() throws Exception {
		us.delete(stId);
		System.out.println("删除方法执行了。。。。"+this);
		return "success";
	}
}
