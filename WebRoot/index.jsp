<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  <body>
	<h1>林雄投资银行</h1><hr>
	<c:if test="${sessionScope.user==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.allmoney }!
		<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
	</c:if>
  </body>
</html>
