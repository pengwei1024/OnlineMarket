<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>order_info_page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
    
<form action="DeliveryServlet">
	<table border="1" cellspacing="0" align="center" >
		<caption>
			<strong>订单发货</strong>
		</caption>
		<tr>
		<td>订单ID：</td>
		<td>${param.orderId}<input type="hidden" name="orderId" value="${param.orderId}" /></td>
		</tr>
		<tr>
			<td>物流公司名称：</td>
			<td><input type="text" name="express" size="40" /></td>
		</tr>
		<tr>
			<td>物流编号：</td>
			<td><input type="text" name="expressId" size="40"/></td>
		</tr>
		<tr>
			<td colspan='2' align="center"><input type="submit" value="提交" />
				<input type="reset" value="重置" /></td>
		</tr>
	</table>
</form>
<body>
</body>
</html>
