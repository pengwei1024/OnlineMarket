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
<style type="text/css">
#name {
	font-size: 15px;
	font-weight: 700;
}

#info {
	font-size: 13;
}
</style>
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

<body>
	<form action="QueryOneOrderServlet">
		<p align="center">
			输入用户邮箱： <input type="text" name="userId" /> <input type="submit"
				value="快捷查询" />
		</p>
	</form>

	<table align="center" style="width: 95%; ">
		<tr bgcolor="white">
			<td align="center" colspan="11">
				<h2>订单列表</h2>
			</td>
		</tr>

		<tr align="center" bgcolor="lightgreen" id="name">
			<td>订单信息</td>
			<td>收货人：</td>
			<td>订单金额</td>
			<td>订单日期</td>
			<td>订单状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.order_list}" var="order">
			<tr id="info">
				<td><input type="checkbox" name="${order.orderId}" />订单ID：${order.orderId}
					<br></td>
				<td>${order.receiverName}</td>
				<td>${order.money}</td>
				<td>${order.orderDate}</td>
				<td><c:if test="${order.paystate=='0'}">
				<font color="red"><c:out value="未支付"></c:out> </font><br>
				</c:if>
				<c:if test="${order.paystate=='1'}">
				<font color="orang"><c:out value="已支付"></c:out> </font><br>
				</c:if>
				<c:if test="${order.paystate=='2'}">
				<font color="blue"><c:out value="已发货"></c:out> </font><br>
				</c:if></td>
				<td><a
					href="${pageContext.request.contextPath}/QueryOrderInfoServlet?orderId=${order.orderId }"><button>查看订单详情</button></a>
					<a
					href="${pageContext.request.contextPath}/DeleteOrderServlet?orderId=${order.orderId}"><button>删除</button></a>
					<c:if test="${order.paystate=='0'}">
						<c:out value="不付不发货"></c:out>
					</c:if> <c:if test="${order.paystate=='1'}">
						<button onclick="location.href='admin/includes/column/orderManage/delivery_info.jsp?orderId=${order.orderId}'">发&nbsp;&nbsp;&nbsp;&nbsp;货</button>
					</c:if>
					<c:if test="${order.paystate=='2'}">
					<c:out value="已发货坐等"></c:out>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<div align='center'>${requestScope.toolBar}</div>
</body>
</html>
