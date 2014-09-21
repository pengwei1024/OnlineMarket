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

<title>My JSP '2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/register.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<script type="text/javascript">
	function changeImg(img) {
		img.src = img.src + "?time=" + new Date().getTime();
	}
	function checkForm() {
		var canSub = true;
		//1.非空校验
		canSub = checkNull("userName", "用户名不能为空!") && canSub;
		canSub = checkNull("password", "密码不能为空!") && canSub;
		canSub = checkNull("password2", "确认密码不能为空!") && canSub;
		canSub = checkNull("nickname", "昵称不能为空!") && canSub;
		canSub = checkNull("email", "邮箱不能为空!") && canSub;
		canSub = checkNull("valistr", "验证码不能为空!") && canSub;

		//2.两次密码一致的校验
		var psw1 = document.getElementsByName("password")[0].value;
		var psw2 = document.getElementsByName("password2")[0].value;
		if (psw1 != psw2) {
			document.getElementById("password2_msg").innerHTML = "<font color='red'>两次密码不一致!</font>";
			canSub = false;
		}

		//3.邮箱格式校验:sssss@xxx.xxx.xxx.xxx 
		var email = document.getElementsByName("email")[0].value;
		if (email != null && email != "" && !/^\w+@\w+(\.\w+)+$/.test(email)) {
			document.getElementById("email_msg").innerHTML = "<font color='red'>邮箱格式不正确!</font>";
			canSub = false;
		}

		return canSub;

	}
	function checkNull(name, msg) {
		document.getElementById(name + "_msg").innerHTML = "";
		var objValue = document.getElementsByName(name)[0].value;
		if (objValue == null || objValue == "") {
			document.getElementById(name + "_msg").innerHTML = "<font color='red'>"
					+ msg + "</font>";
			return false;
		}
		return true;
	}
</script>
</head>
<body style="background:#f2f2f2;">
	<div class="main">
		<div class="top"
			onclick="location.href='${pageContext.request.contextPath }'">
			<img src="images/logo.png" /> <img style="width: 150px;height: 40px"
				src="images/register.png" />
		</div>
		<div class="content">
			<form action="${pageContext.request.contextPath}/Register"
				method="POST" onsubmit="return checkForm()">

				<div class="form-group">
					<label class="control-label">用户名</label>
					<input type="text" name="userName" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">密码</label>
					<input type="password" name="userPassword" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">确认密码</label>
					<input type="password" name="userPassword2" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">邮箱</label>
					<input type="email" name="userEmail" class="form-control">
				</div>
				<label class="control-label">验证码</label>
				<div class="form-group">
					<div class="col-sm-8">
				      <input type="text" class="form-control" name="valistr"  >
				    </div>
				    <img src="${pageContext.request.contextPath }/ValiImg"
									style="cursor: pointer" onclick="changeImg(this)" /> <a><font
									color="red">${msg}</font></a>
				  </div>
				<br/>
				<input type="submit" value="立即注册" class="btn btn-primary btn-block" />

			</form>
		</div>

		<div>
			<img src="images/new3.GIF" />
		</div>
	</div>
</body>
</html>
