<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@ taglib uri="http://www.itheima.com/UserTag" prefix="UserTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<div align="center">
 	<h1>林雄投资银行_登录</h1><hr>
 	<font color="red">${msga }</font>
 	<form action="${pageContext.request.contextPath }/servlet/LookAllMoneyServlet" method="POST">
		<table border="1">
			<tr>
			   <td>用户名:</td>
				<td>${sessionScope.user.username }</td>
		</tr>			
		<tr>
				<td>您的余额为:</td>
				<td>${sessionScope.user.allmoney }</td>
			</tr>
				<tr>
				<td><input type="submit" value="返回主菜单"/></td>
				<td>服务至上，客户第一</td>
			</tr>
			
		</table>
 	</form>
 	</div>
  </body>
</html>
