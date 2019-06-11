package com.zrdm.sql;

public class UserBean {

	private int userid;
	private String username;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserBean() {
		super();
	}

	public UserBean(int userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}

