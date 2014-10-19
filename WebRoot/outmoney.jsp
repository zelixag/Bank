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
 	<font color="red">${msg1 }</font>
 	<form action="${pageContext.request.contextPath }/servlet/GetMoneyServlet" method="POST">
		<table border="1">
			<tr>
				<td>输入金额:</td>
				<td><input type="text" name="money"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认"/></td>
				<td><input type="checkbox" value="ok" name="remname" 
					<c:if test="${cookie.remname!=null }">
						checked="checked" 
					</c:if>
				/>记住用户名</td>
			</tr>
			
		</table>
 	</form>
 	</div>
  </body>
</html>
