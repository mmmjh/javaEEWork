package com.zrdm.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.zrdm.sql.*;
import com.zrdm.db.DBBean;

public class UserDao {

	public UserDao() {

	}

	// 删除个人信息
	public void delete(int id) {
		Connection connection = (Connection) DBBean.getConnection();
		String sql = "delete from student where ID =" + id;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			System.out.println(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBBean.close(preparedStatement);
			DBBean.close(connection);
		}
	}
	// 添加个人信息
	@SuppressWarnings("deprecation")
	public void add(UserBean userBean) {
		String sql =  "insert into student(Name,ID) values('" +
				 userBean.getUsername() + "',"+userBean.getUserid()+");";
		System.out.println( "\t" + sql);
		Connection con = DBBean.getConnection();
		PreparedStatement preparedStatement = null;
		//Statement state = null;
		try {
			preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			System.out.println(sql);
			preparedStatement.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBBean.close(preparedStatement);
			DBBean.close(con);
		}
	}
	// 更新个人信息
		public void update(int id,UserBean user) {
			String sql = "update student set Name='" + user.getUsername() + "'where ID= "+id;
			Connection connection = (Connection) DBBean.getConnection();
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
				System.out.println(sql);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBBean.close(preparedStatement);
				DBBean.close(connection);
			}
		}

		/**
		 * 列出全部信息
		 * 
		 * @return
		 */
		public List<UserBean> getList() {
			String sql = "select * from student";

			Connection connection = (Connection) DBBean.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List<UserBean> userBeans = new ArrayList<UserBean>();

			try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					int id = resultSet.getInt("ID");
					String Name = resultSet.getString("Name");
					System.out.println(Name);
					userBeans.add(new UserBean(id,Name));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBBean.close(preparedStatement);
				DBBean.close(connection);
			}
			return userBeans;
		}
}
