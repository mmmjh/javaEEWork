package com.zrdm.webcrud.serverlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrdm.dao.UserDao;
import com.zrdm.sql.UserBean;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
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
		if ("Edit".equals(method)) {// �޸�ҩƷ��Ϣ
			Edit(request, response);
		} 
	}
	
	/**
	 * ���ҩƷ��Ϣ
	 */
	private void Edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(new Date().toString() + "\tMedicineServlet.add()��ʼִ��");

		req.setCharacterEncoding("utf-8");

		UserDao userdao = new UserDao();
		String name = req.getParameter("Name");
		int id =Integer.parseInt( req.getParameter("ID"));
		System.out.println(id);
		UserBean user=new UserBean();
		user.setUsername(name);
		user.setUserid(id);
		userdao.update(id,user);
		System.out.println(user.getUsername());
		req.getRequestDispatcher("StudentList.jsp").forward(req, resp);
		}


}
