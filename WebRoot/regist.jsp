<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>林雄投资银行_注册</h1><hr>
  	<font color="red">${msg }</font>
  	<form action="${pageContext.request.contextPath}/servlet/RegistServlet" method="POST" >
  		<table border="1">
  			<tr>
  				<td>用户名</td>
  				<td><input type="text" name="username" value="${param.username }" /></td>
  			</tr>
  			<tr>
  				<td>密码</td>
  				<td><input type="password" name="password" /></td>
  			</tr>
  			<tr>
  				<td>确认密码</td>
  				<td><input type="password" name="password2" /></td>
  			</tr>
  			<tr>
  				<td>昵称</td>
  				<td><input type="text" name="nickname" value="${param.nickname }"/></td>
  			</tr>
  			<tr>
  				<td>真实名字</td>
  				<td><input type="text" name="realname" value="${param.realname }"/></td>
  			</tr>
  			<tr>
  				<td>身份证号</td>
  				<td><input type="text" name="identityNum" value="${param.identityNum }"/></td>
  			</tr>
  			<tr>
  				<td>邮箱</td>
  				<td><input type="text" name="email" value="${param.email }" /></td>
  			</tr>
  			<tr>
  				<td>验证码</td>
  				<td><input type="text" name="valistr" /></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="注册" /></td>
  				<td><img src="${pageContext.request.contextPath }/servlet/ValiImg" style="cursor: pointer" onclick="changeImg(this)"/></td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
