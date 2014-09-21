<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String themePath = basePath;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=themePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=themePath%>css/login.css">


</head>

<body style="background:#f2f2f2;">
	<div class="makeup1" onclick="location.href='${pageContext.request.contextPath }'">
		<img src="<%=themePath%>/images/logo.png" />
		<img  style="width: 150px;height: 40px"src="<%=themePath%>/images/login.png" />
	</div>
	<div class="content">
		<div class="container_left">
			<img class="Img" src="<%=themePath%>/images/login_back.png">
		</div>
		<div class="container_right">
			<form action="${pageContext.request.contextPath }/Login"
				method="post" name="lgForm">
				<h2>用户登录</h2>
				<div class="form-group">
		   			 <label>Email</label>
		    		 <input type="email" name="userEmail" class="form-control">
		   		 </div>
		   		 <div class="form-group">
		   			 <label>Password</label>
		    		 <input type="password" name="userPassword" class="form-control">
		   		 </div>
				<input type="submit" name="submit"
						value="登 录"  class="btn btn-primary btn-block" />
			</form>
			<a href="register.jsp">没有账号？立即注册</a>
		</div>
	</div>
	<div class="makeup2">
		<img src="<%=themePath%>/images/new2.GIF" />
	</div>
	<input type="hidden" id="info" value="${requestScope.Info}" />
	<script type="text/javascript">
		var infos = document.getElementById("info").value;
		if (infos == "Notactive") {
			alert("账号未激活，请登陆邮箱激活账号！！");
		}
		if (infos == "login_error") {
			alert("登录失败，用户密码错误！！");
		}
		if (infos == "no_login") {
			alert("您还没登陆，请先登录账号！");
		}
		if (infos == "NoPermission") {
			alert("该账号被冻结，请联系管理员！");
		}
	</script>
</body>
</html>
