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
 * Servlet implementation class listStudent
 */
@WebServlet("/listStudent")
public class listStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listStudent() {
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
		 * ÿһ�����ô� Servlet �ĵط�����Ҫ����һ��method��������ָ����Ҫ�����еĲ���
		 */
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		// ����method��ֵ���ò�ͬ�ķ���ִ�в�ͬ�Ĳ���
		if ("list".equals(method)) {// �޸�ҩƷ��Ϣ
			list(request, response);
		} 
	}
	
	/**
	 * ���ҩƷ��Ϣ
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(new Date().toString() + "\tMedicineServlet.add()��ʼִ��");

		req.setCharacterEncoding("utf-8");
		UserDao users = new UserDao();
		List<UserBean> medicineBeans = users.getList();
		for(UserBean user : medicineBeans ) {
			System.out.println(user.getUserid());
		}
		req.setAttribute("userBeans", medicineBeans);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		}


}
