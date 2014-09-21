<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminPath = basePath + "admin/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=adminPath%>">
    <title>管理员登录</title>
    <meta charset="utf-8"/>   
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
  </head>
  
  <body>
     <div class="login_panel">
     	<form id="login-form" role="form" action="../adminManage" method="post">
     		<h2>管理员登录</h2>
     		<input type="hidden" name="action" value="adminLogin"/>
     		<div class="form-group">
		      <label for="disabledTextInput">Email</label>
		      <input type="text" placeholder="请输入邮箱"
		       class="form-control" name="uid">
		    </div>
		    <div class="form-group">
		      <label for="disabledTextInput">Password</label>
		      <input type="password" placeholder="请输入密码"
		       class="form-control" name="pwd">
		    </div>
		    <div class="checkbox">
      <label>
        <input type="checkbox">自动登录
      </label>
    </div>
	<button type="submit" class="btn btn-success btn-block">登录</button>
     	</form>
     </div>
     <%
     	if(request.getParameter("result") != null){
     %>
     <script>alert("账号或者密码输入错误");</script>
     <% 
     }
     %>
  </body>
</html>
