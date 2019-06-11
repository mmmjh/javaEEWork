package com.zrdm.webcrud.serverlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrdm.dao.UserDao;
import com.zrdm.sql.UserBean;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
		if ("delete".equals(method)) {// 修改药品信息
			delete(request, response);
		} 
	}
	
	/**
	 * 添加药品信息
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id =Integer.parseInt( req.getParameter("id"));
		UserDao userdao = new UserDao();
		userdao.delete(id);
		System.out.println("添加成功");
		req.getRequestDispatcher("StudentList.jsp").forward(req, resp);
		}
}
