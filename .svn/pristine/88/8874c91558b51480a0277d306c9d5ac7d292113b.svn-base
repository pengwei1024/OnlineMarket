<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'add_book_info.jsp' starting page</title>

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
	<form action="${pageContext.request.contextPath }/AddBookInfoServlet"
		method="post">
		<div style="margin-top:10px;margin-left:6px">
			图书名称：<input type="text" name="bookName" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:38px">
			作者：<input type="text" name="bookAuthor" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:22px">
			出版社：<input type="text" name="bookPublisher" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:6px">
			图书类型：<input type="text" name="bookType" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:6px">
			图书定价：<input type="text" name="bookPrice" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:6px">
			图书现价：<input type="text" name="bookNowPrice" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:6px">
			图片链接：<input type="text" name="bookPicture" class="name" /> <font
				color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:38px">
			库存：<input type="text" name="pnum" class="name" /> <font color="red">*</font>
		</div>
		<div style="margin-top:10px;margin-left:6px">
			折扣力度：<select name="sale" size="1">
				<option selected>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
			</select> <font color="red">*</font> &nbsp;&nbsp;是否新品：<select name="newBook"
				size="1">
				<option selected>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
			</select> <font color="red">*</font> &nbsp;&nbsp;销量：<select name="hit"
				size="1">
				<option selected>0</option>
			</select>
		</div>
		<div style="margin-top:10px;">
			图书简介：
			<textarea name="bookIntroduction" class="name"
				style="width: 470px; height: 200px"></textarea>
		</div>
		<div class="middle" style="margin-top:10px;">
			<input style="color:#FFFFFF;font-weight:bolder" type="submit"
				name="submit" value="提交" class="Id" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input style="color:#FFFFFF;font-weight:bolder" type="reset"
				name="reset" value="取消" class="Id" />
		</div>
	</form>
</body>
</html>
