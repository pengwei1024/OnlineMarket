<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="css/logistics.css"/>
<div id="content">
	<div class="logistics_info_panel"> 
		<div class="logistics_tip"><span>物流动态</span></div>
		<h4>订单状态：${requestScope.status}</h4>
		<h4>快递公司：${requestScope.com}</h4>
		<h4>快递号：123</h4>
	<ul class="logistics_info">
		<%
		List<Map<String,String>> list =(List<Map<String,String>>)request.getAttribute("data");
		for(Map<String,String> map :list){
	%>
		<li><%=map.get("time") %>
		<span><%=map.get("context") %></span>
		</li>
	<% } %>
	</ul>
	</div>
	<div class="clear"></div>
	
</div>

