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
 	<font color="red">${msg3 }</font>
 	<form action="${pageContext.request.contextPath }/servlet/SetMoneyServlet" method="POST">
		<table border="1">
			<tr>
				<td>输入金额:</td>
				<td><input type="text" name="money"></td>
				<td><br></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认"/></td>
				<td><input type="checkbox" value="ok" name="remname" 
					
				/>服务至上</td>
			</tr>
			
		</table>
 	</form>
 	</div>
  </body>
</html>
