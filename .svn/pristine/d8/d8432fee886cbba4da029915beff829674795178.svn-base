<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/basic.css">
	<style type="text/css">
		 #header{
			height:100%;
			background: #3083eb;
			border-bottom: 1px solid #1f74df;
			box-shadow:0 0 5px #ccc;
			position:relative;
		}
		#header>h2{
			color:#fcfcfc;
			font-weight:700;
			font-size:22px;
			position:absolute;
			top:11px;
			left:15px;
			text-shadow:0 0 5px #333;
		}
		#header>ul{position:absolute;right:20px;top:15px;}
		#header>ul li{
			float:left;
			margin:0 10px;
			color:#fff;
			cursor:pointer;
		}
		#header>ul li:hover{
			color:yellow;
		}
		#header>ul li>span{
			background:red;
			padding:0px 6px;
			border-radius:10px;
			margin-left:4px;
		}
		#header>ul li:last-child>img{
			margin-left:5px;
		}
		#header>ul li:last-child{
			position:relative;
		}
		#header>ul li:last-child:hover ol{
			display:block;
		}
		#header>ul li:last-child ol{
		    width:500px;
			position:absolute;
			display:none;
			right:0;
		}
		#header>ul li:last-child ol li{
			float:right;
			color:#fff;
			font-size:8px;
			color:#dcdcdc;
		}
	</style>
  </head>
  
  <body>
    	<header id="header">
    		<h2>传习在线书城后台管理</h2>
    		<ul>
    			<li>最新订单<span class="num">1</span></li>
    			<li>买家留言<span class="num">4</span></li>
    			<li>舞影凌风<img src="<%=basePath %>admin/images/admin_user_dropmenu.png"/>
    				<ol>
    					<li>查看站点</li>
    					<li>退出登录</li>
    				</ol>
    			</li>
    		</ul>
    	</header>
  </body>
</html>
