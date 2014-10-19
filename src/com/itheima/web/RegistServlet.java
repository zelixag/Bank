 package com.itheima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.exception.MsgException;
import com.itheima.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			UserService service = new UserService();
			//1.������֤��
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistr");
			if(valistr == null || valistr2==null || !valistr.equals(valistr2)){
				request.getSession().setAttribute("msg", "��֤�벻��ȷ!");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			//2.��װ����У������
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			user.checkValue();
			//3.����Service�еķ�������û�
			service.registUser(user);
			//4.��¼�û�
			request.getSession().setAttribute("user", user);
			//5.��ʾע��ɹ�3��ص���ҳ
			response.getWriter().write("��ϲ��ע��ɹ�!3��ص���ҳ....");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
		}catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
