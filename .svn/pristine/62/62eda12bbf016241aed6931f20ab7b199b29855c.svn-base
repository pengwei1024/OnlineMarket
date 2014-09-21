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
	<c:forEach items="${requestScope.list}" var="order">
		<strong>订单详情</strong>
		<dl>
			<dt>收货人信息</dt>
			<dd>
				<ul>
					<li>订单编号：${order.orderId}</li>
					<li>收&nbsp;货&nbsp;人：${order.receiverName}</li>
					<li>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：${order.receiverAddress}</li>
					<li>手机号码：${order.receiverTel}</li>
					<li>备注信息：${order.orderRemark}</li>
				</ul>
			</dd>
		</dl>

		<dl>
			<dt>支付及配送方式</dt>
			<dd>
				<ul>
					<li>支付方式：${order.payType}</li>
					<li>订单状态：${order.paystate}</li>
					<li>物流公司：${order.express}</li>
					<li>物流单号：${order.expressId}</li>
				</ul>
			</dd>
		</dl>

		<dl>
			<dt>商品清单</dt>
			<dd>
				<table align="center" border='1' width="100%" cellspacing="0">
					<tr>
						<th>图书编号</th>
						<th width="20%">图书图片</th>
						<th>图书名称</th>
						<th>售价</th>
						<th>购买数量</th>
					</tr>
					<c:forEach items="${requestScope.list_item}" var="order_item">

						<tr>
							<td>${order_item.book.bookId}</td>
							<td><img alt="" src="${order_item.book.bookPicture}"
								width="30" height="30"></td>
							<td>${order_item.book.bookName}</td>
							<td>${order_item.book.bookNowPrice}</td>
							<td>${order_item.number}</td>
						</tr>
						<c:set var="money"
							value="${money + order_item.book.bookNowPrice * order_item.number }" />
					</c:forEach>
				</table>
			</dd>
			<dd>

				<div align="right">
					合计：${money}<br> 
					运费：
				</div>
			</dd>
		</dl>

	</c:forEach>
	<div align='center'>${requestScope.toolBar}</div>
</body>
</html>
