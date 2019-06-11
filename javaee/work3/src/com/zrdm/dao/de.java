package com.zrdm.dao;
import java.util.List;

import com.zrdm.sql.*;
public class de {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao  dao = new UserDao();
		List<UserBean> list = dao.selStudentAll();
        for (UserBean s : list)
        {
            System.out.println("-----" + s.getUserid() + "\t" + s.getUsername()
                    + "\t" );
        }
         
	}

}
