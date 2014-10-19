package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class GetMoneyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		UserService service = new UserService();
	
		user = service.getMoney(user, request.getParameter("money"));
		if(user== null){
			//3.�������ȷ����ʾ
			request.getSession().setAttribute("msg1", "��������Ч������������!");
			response.sendRedirect(request.getContextPath()+"/outmoney.jsp");
			//request.getRequestDispatcher("/outmoney.jsp").forward(request, response);
			return;
		}else{		
			request.getSession().setAttribute("msga", "ȡ��ɹ�");
			//request.getSession().setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("user", user);
		}
		response.sendRedirect(request.getContextPath()+"/UserCenter.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
