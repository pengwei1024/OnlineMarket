<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.dao.*,
com.cxft.onlinemarket.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
AdminDao dao =new AdminDao();
List<Admin> list = dao.getList();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.min.css">
    <style type="text/css">
    	#content{
    		width:1000px;
    		margin:20px;
    	}
    </style>
  </head>
  
  <body>
   
   <div id="content">
   <table class="table table-striped">
   	    <tr>
   	    <td>管理员邮箱</td>
   	    <td>管理员昵称</td>
   	    <td>token</td>
   	    <td>注册时间</td>
   	    <td>注册IP</td>
   	    </tr>
   		<% for(Admin a : list){ %>
   		<tr>
   			<td><%=a.getAdminEmail() %></td>
   			<td><%=a.getAdminName() %></td>
   			<td><%=a.getAdminPassword() %></td>
   			<td>2014-09-03</td>
   			<td>192.168.33.128</td>
   	     </tr>
   		<% } %>
   	</table>
   </div>
   
  </body>
</html>
