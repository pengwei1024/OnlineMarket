<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.model.*,
com.cxft.onlinemarket.dao.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SiteDao dao =new SiteDao();
Site site = dao.get();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'site.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.min.css">
	<style type="text/css">
	#content{
		width:600px;
		margin:20px;
	}
	</style>
  </head>
  <body>
    
     <div id="content">
     <form action="site" method="post">
     		<input type="hidden" name="action" value="update"  />
     		<div class="form-group">
    		<label>站点名称</label>
    		<input type="text" name="title" value="<%=site.getSite_name() %>" class="form-control">
  			</div>
  			<div class="form-group">
    		<label>站点关键词</label>
    		<textarea rows="5" name="keyword" class="form-control" ><%=site.getSite_key() %></textarea>
  			</div>
  			<div class="form-group">
    		<label>站点描述</label>
    		<textarea rows="5" name="describe" class="form-control" ><%=site.getSite_describe() %></textarea>
  			</div>
  			<input type="submit" class="btn btn-primary btn-block"/>
     </form>
     </div>
    
  </body>
</html>
