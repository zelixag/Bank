package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class TransferMoneyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		UserService service = new UserService();
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("money"));
	   User user1=service.findUserAndMoney(request.getParameter("username"),request.getParameter("money"));
		//User user1=service.transferMoney(user, request.getParameter("money"),request.getParameter("username"));
		
		//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		
		
		if(user1== null){
			//3.�������ȷ����ʾ
			//request.setAttribute("msg2", "��������Ч������������!");
			request.getSession().setAttribute("msg2", "��������Ч��Է��û�����������������!");
			response.sendRedirect(request.getContextPath()+"/transfermoney.jsp");
			return;
		}else{		//request.getRequestDispatcher("/checkrealname.jsp").forward(request, response);
			
			request.getSession().setAttribute("user1", user1);
			request.getSession().setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("money", request.getParameter("money"));
			response.getWriter().write("ȷ�϶Է���ʵ����....");
			response.setHeader("refresh", "4;url=/User/checkrealname.jsp");
		}
		//response.sendRedirect(request.getContextPath()+"/UserCenter.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
