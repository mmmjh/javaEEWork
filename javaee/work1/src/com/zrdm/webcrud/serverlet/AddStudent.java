package com.zrdm.webcrud.serverlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zrdm.sql.*;
import com.zrdm.dao.*;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * 每一个调用次 Servlet 的地方都需要传递一个method参数用来指明所要经进行的操作
		 */
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		// 根据method的值调用不同的方法执行不同的操作
		if ("add".equals(method)) {// 修改药品信息
			add(request, response);
		} 
	}
	
	/**
	 * 添加药品信息
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date().toString() + "\tMedicineServlet.add()开始执行");

		req.setCharacterEncoding("utf-8");

		UserDao userdao = new UserDao();
		String name = req.getParameter("username");
		int id =Integer.parseInt( req.getParameter("ID"));
		UserBean user=new UserBean();
		user.setUsername(name);
		user.setUserid(id);
		userdao.add(user);
		System.out.println("添加成功");
		req.getRequestDispatcher("StudentList.jsp").forward(req, resp);
		}
}
