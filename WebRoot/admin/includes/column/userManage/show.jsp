<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.model.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <p align="center">用户基本信息</p>
   <hr>
  
  <table align="center" border="1" cellspacing="0" bordercolor="#f2f2f2">
  
  <tr>
  <td>用户名</td>
  <td>性别 </td>
  <td>Email</td>
  <td>密码</td>
  <td>证件类型</td>
  <td>证件号码 </td>
    <td>城市 </td>
      <td>地址</td>
        <td>邮编 </td>
         <td>电话</td>
         <td>等级</td>
         <td>注册时间</td>
         <td>token</td>
         <td>activemail</td>
  </tr>
  <%List<User>list=(List)request.getAttribute("list");
  if(list.size()==1){
   %>
  <tr>
  <td><%=list.get(0).getUserName() %></td>
  <td><%=list.get(0).getSex() %></td>
  <td><%=list.get(0).getUserEmail() %></td>
  <td><%=list.get(0).getUserPassword() %></td>
  <td><%=list.get(0).getCardType() %></td>
  <td><%=list.get(0).getCardNumber() %> </td>
    <td> <%=list.get(0).getCity() %></td>
      <td><%=list.get(0).getUserAddress() %></td>
        <td> <%=list.get(0).getPostCode() %></td>
         <td><%=list.get(0).getUserTel() %></td>
         <td><%=list.get(0).getGrade() %></td>
         <td><%=list.get(0).getRegisterTime() %></td>
         <td><%=list.get(0).getToken() %></td>
         <td><%=list.get(0).getActiveMail() %></td>
  </tr>
  <%}
   %>
  </table>
   
   
  </body>
</html>
