package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class CheckRealNameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		UserService service = new UserService();
		System.out.println(user);
		System.out.println(request.getSession().getAttribute("money")+"");
	System.out.println(request.getSession().getAttribute("username")+"");
		user=service.transferMoney(user, request.getSession().getAttribute("money")+"",request.getSession().getAttribute("username")+"");
		request.getSession().setAttribute("msga", "»ã¿î³É¹¦");
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/UserCenter.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
