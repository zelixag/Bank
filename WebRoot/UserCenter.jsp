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
 	
		<table border="1">
			<tr>
				<td><br></td>
				<td>银行为您提供以下服务</td>
				<td><br></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/lookallmoney.jsp">查询余额</a></td>
				<td><input type="password" name="password"/></td>
				<td><a href="${pageContext.request.contextPath }/outmoney.jsp">  取款  </a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/setmoney.jsp"> 存款  </a></td>
				<td><input type="password" name="password"/></td>
				<td><a href="${pageContext.request.contextPath }/transfermoney.jsp"> 转账 </a></td>
			</tr>
			<tr>
				<td><br></td>
				<td>服务第一，顾客至上</td>
				<td><br></td>
			</tr>
		</table>
 
 	</div>
  </body>
</html>
