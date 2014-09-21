<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.dao.*,
com.cxft.onlinemarket.model.*,com.cxft.onlinemarket.utils.*" 
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String colPath = "admin/includes/column/noticeManage";
BbsDao dao = new BbsDao();
List<BBS> list = dao.getList();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.min.css">
  </head>
  
  <body>
   
   <table class="table table-striped">
   <% for(BBS bbs : list){ %>
   <tr>
   		<td><%=bbs.getBbsId() %></td>
   		<td><%=bbs.getTitle() %></td>
   		<td><%=bbs.getAuthor() %></td>
   		<td><%=TimeUtil.getDayTime(Long.parseLong(bbs.getInTime()))%></td>
   		<td><a href='http://localhost:8080/OnlineMarket/article?aid=<%=bbs.getBbsId() %>' target="_black">查看</a></td>
   		<td><a href='<%=colPath%>/update.jsp?aid=<%=bbs.getBbsId() %>'>编辑</a></td>
   		<td><a href='article?bid=<%=bbs.getBbsId() %>&action=deleteBbs'>删除</a></td>
   </tr>
   <% } %>
   </table>
  </body>
</html>
