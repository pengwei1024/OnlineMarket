<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.min.css">
	<style type="text/css">
		#content{
			width:500px;
			margin:20px;
		}
		#content h3{
			text-align:center;
			font: blod 16px "Microsoft Yahei";
		}
	</style>
  </head>
  
  <body>
   
   <div id="content">
   	
   	<form action="adminManage" method="post">
   		<h3>管理员注册</h3>
   		<input type="hidden" name="action" value="addAdmin"/>
   		<div class="form-group">
		    <label>输入邮箱地址</label>
		    <input type="email" name="email" class="form-control" >
  		</div>
  		<div class="form-group">
		    <label>输入昵称</label>
		    <input type="text" name="nickname" class="form-control" >
  		</div>
  		<div class="form-group">
		    <label>输入密码</label>
		    <input type="password" name="pwd" class="form-control" >
  		</div>
  		<div class="form-group">
		    <label>再次确认密码</label>
		    <input type="password" class="form-control" >
  		</div>
  		<input type="submit" class="btn btn-primary btn-block" />
   	</form>
   	
   </div>
   
  </body>
</html>
