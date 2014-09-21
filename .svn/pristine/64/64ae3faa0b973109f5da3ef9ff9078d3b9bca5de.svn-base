<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminPath = basePath + "admin/";
Cookie[] cks = request.getCookies();
Boolean flag = false;
for(Cookie ck : cks){
	if(ck.getName().equals("uid")){
		if(ck.getValue() != null && !ck.getValue().equals(""))
			flag = true;
	}
}
if(!flag){
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=adminPath%>">
    <meta charset="utf-8" />
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/scrollbar.css"/>
  </head>
   <frameset rows="56,*" frameborder="no" border="0" framespacing="0">
      	<frame src="includes/page/header.jsp" scrolling="No" noresize="noresize"/>    
      	<frame src="includes/page/center.jsp" />
   </frameset>
   <noframes>
   <body>
   </body>
   </noframes>
</html>
