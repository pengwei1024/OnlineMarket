<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp" flush="true" />
<link href="css/personalcenter.css" rel="stylesheet">
<div id="content">
	<div class="personHeader"><strong>个人中心</strong></div>
	<div class="personContent">
		<div class="personInfoHeader">
			<div>基本信息修改</div>
		</div>
		<form
			action="${pageContext.request.contextPath}/ChangeUserInfoServlet?value=1"
			method="post" id="baseinfoForm" name="myform">
			<div>
				<a>用户名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<input class="baseinfo" type="text" name="userName" placeholder="${user.userName}" value="${user.userName}" readonly="true" />
			</div>
			<br>
			<div>
				<a>邮箱： ${user.userEmail}</a>
			</div>
			<br>
			<div>
				<a>身份证类型：
					<input type="radio" name="cardType" checked="checked" vaule="身份证" /> 身份证 
					<input type="radio" name="cardType" vaule="学生证" />学生证 
				 	<input type="radio" name="cardType" vaule="军人证" />军人证
			 	</a>
			</div>
			<br> 
			<div>
				<a>证件号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<%--<c:set var="testStr" value="${user.cardNumber}"></c:set>
				 <c:choose>
					<c:when test="${fun:length(testStr) > 10}">
						<c:out value="${fun:substring(testStr, 0, 4)}......" />
					</c:when>
					<c:otherwise>
						<c:out value="${testStr}" />
					</c:otherwise>
				</c:choose> --%>
				<input class="baseinfo" type="password" name="cardNumber"  value= "${user.cardNumber}" readonly="true">
			</div>
			<br>
			 <div>
			 	<a>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			 	<input class="baseinfo" type="text" name="sex" value="${user.sex}" readonly="true" /> 
			 </div>
			 <br> 
			 <div>
			 	<a>所在城市：&nbsp;&nbsp;</a>
			 	<input class="baseinfo" type="text" name="city" value="${user.city}" readonly="true" />
			 </div>
			 <br>
			 <div>
				<a> 居住地：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				 <input class="baseinfo" type="text" name="userAddress" value="${user.userAddress}" readonly="true" /> 
			</div>
			<br>
			<div>
				<a>联系电话：&nbsp;&nbsp;</a>
				<input class="baseinfo" type="text" name="userTel" value="${user.userTel}" readonly="true" />
			</div>
			<br> 
			<div>
				<a>上次修改时间：${user.registerTime}</a>
			</div>
			<br> 
			<input id="changebutton" class="pswSubtmit" type="button" value="修改" />
			<input id="updateSubtmit" class="pswSubtmit" type="submit" value="更新" />
			<input id="cancelbutton" class="pswSubtmit" type="reset" value="取消" />
		</form>
		<hr>
		<div id="personPswHeader">
			<div>用户密码修改</div>
		</div>
		<form
			action="${pageContext.request.contextPath}/ChangeUserInfoServlet?value=2"
			method="post" id="pswForm">
			<div>
				<a>原密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<input type="password" name="old_userPassword" />
			</div>
			<br>
			<div>
				<a>新密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<input type="password" name="new_userPassword" />
			</div>
			<br>
			<div>
				<a>确认密码：&nbsp;&nbsp;</a>
				<input type="password" name="new_userPassword_check" />
			</div>
			<br>
			<input class="pswSubtmit" type="submit" value="提交" />
		</form>
	</div>

<input type="hidden" id="info" value="${requestScope.Info}" />
<script type="text/javascript">
	var infos = document.getElementById("info").value;
	if (infos == "updatesucess") {
		alert("个人资料更新成功！");
	}
	if (infos == "failInfo") {
		alert("数据更新失败！");
	}
	if (infos == "worng") {
		alert("原始密码错误！请输入正确密码");
	}
</script>
</div>
<!-- footer -->
<jsp:include page="footer.jsp" flush="true" />
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/personal-center.js"></script>

