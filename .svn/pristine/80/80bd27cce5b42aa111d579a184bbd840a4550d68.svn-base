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

<title>My JSP 'query_book_info.jsp' starting page</title>

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
	<table align="center" style="width: 100%; ">
		<tr bgcolor="white">
			<td align="center" colspan="11">
				<h2>所有商品信息</h2>
			</td>
		</tr>

		<tr align="center" bgcolor="lightgreen" id="name">
			<td>全选<input type="checkbox" /></td>
			<td>ID</td>
			<td>名称</td>
			<td>作者</td>
			<td>出版社</td>
			<td>类型</td>
			<td>定价</td>
			<td>现价</td>
			<td>销量</td>
			<td>库存</td>
			<td>操作</td>
		</tr>


		<c:forEach items="${requestScope.querybook}" var="entry">
			<tr id="info">
				<td><input type="checkbox" /></td>
				<td>${entry.bookId}</td>
				<td><img src="${entry.bookPicture}" width="30px" height="30px" />${entry.bookName}</td>
				<td>${entry.bookAuthor}</td>
				<td>${entry.bookPublisher}</td>
				<td>${entry.bookType}</td>
				<td>${entry.bookPrice}</td>
				<td>${entry.bookNowPrice}</td>
				<td>${entry.hit}</td>
				<td>${entry.pnum}</td>
				<td style="text-align:center"><a
					href="${pageContext.request.contextPath}/admin/includes/column/goodsManage/update_book_info.jsp?bookId=${entry.bookId }&&bookName=${entry.bookName}&&bookAuthor=${entry.bookAuthor}&&bookPublisher=${entry.bookPublisher}&&bookType=${entry.bookType}&&bookPrice=${entry.bookPrice}&&bookNowPrice=${entry.bookNowPrice}&&bookPicture=${entry.bookPicture}&&pnum=${entry.pnum}&&bookIntroduction=${entry.bookIntroduction}"><button>修改</button></a>
					<a
					href="${pageContext.request.contextPath}/DelBookInfoInAdminServlet?id=${entry.bookId }"><button>删除</button></a>

				</td>
			</tr>
		</c:forEach>
	</table>
	<div align='center'>${requestScope.toolBar}</div>
</body>
</html>
