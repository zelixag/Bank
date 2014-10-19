package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LookAllMoneyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		//UserService service = new UserService();
	   //User user1=service.findUser(request.getParameter("username"));
		//User user1=service.transferMoney(user, request.getParameter("money"),request.getParameter("username"));
		
		//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		
		
			//request.getRequestDispatcher("/checkrealname.jsp").forward(request, response);
			
			request.getSession().setAttribute("msga", "");
			request.getSession().setAttribute("username", request.getParameter("username"));
			request.getSession().setAttribute("money", request.getParameter("money"));
			response.sendRedirect(request.getContextPath()+"/UserCenter.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
