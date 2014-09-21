<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.model.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchInterface.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/searchInterface.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <jsp:include page="header.jsp" flush="true"/>
  <div class="content">
  <div class="direction">图书>搜索"<span class="pamameter"><%=request.getAttribute("key") %></span>"</div>
 <div class="content_left">
 <span class="definition">相关分类</span>
 <div class="menu">
 <ul>
<li><a>励志与成功</a></li>
<li><a>心理学</a></li>
<li><a>科普书籍</a></li>
<li><a>儿童图书</a></li>
<li><a>计算机图书</a></li>
<li><a>饮食文化</a></li>
<li><a>生理健康</a></li>
<li><a>管理</a></li>
</ul>
 </div>
 <span class="definition" style="color:red">更多+</span>
 <div class="under_content_left">
<img src="http://img13.360buyimg.com/da/jfs/t388/70/7677367/38525/1f0665bf/5405a686N10b726c9.gif" width="207" height="80"><br><br>
<img src="http://img13.360buyimg.com/da/jfs/t196/173/932008140/47211/62e248a3/539ecc0eN0b6764e9.jpg" width="207" height="80">
 </div>
 
 </div>
 <div class="content_top">
<div style="background:#f2f2f2;height:25px;"><span style="color:#FF0000;">"参数"</span>找到"对象数量"件相关商品</div>
<div class="content_top_top">
<ul>
<li><strong>客户评分:</strong></li>
<li>五星级</li>
<li>四星级及以上</li>
<li>三星级及以上</li>
<li>二星级及以上</li>
<li>一星级</li>
</ul>
<hr style="margin:5px;">
<ul>
<li><strong>折扣:</strong></li>
<li>0-3折</li>
<li>3-5折</li>
<li>5-7折</li>
<li>7折以上</li>
</ul>
<hr style="margin:5px;">
<ul>
<li><strong>价格:</strong></li>
<li>0-39</li>
<li>40-79折</li>
<li>80-199折</li>
<li>200-299</li>
<li>300以上</li>
</ul>
<hr style="margin:5px;">
</div>
<div class="content_top_bottom">
<span>排序</span>
<ul>
<li>相关度</li>
<li>销量</li>
<li>价格</li>
<li>折扣</li>
<li>评价数</li>
<li>上架时间</li>
<li>出版时间</li>
</ul></div>
<div style="margin-top:15px;">库存</div>
</div>
 <div class="content_main">
 <% List<Book> list=(List<Book>)request.getAttribute("list");
 for(Book book:list){ 
 %>
<div class="example">
 <div class="example-left"><img width="160" height="160" 
  src="<%=book.getBookPicture() %>"   class="err-product"></div>
<div class="example-center">
<h4><%= book.getBookIntroduction()%></h4>
京东价：<%= book.getBookPrice()%>
<hr>
 <ul>
<li><%= book.getBookPublisher()%></li>
<li>出版时间</li>
<li>顾客评价</li>
<li><%= book.getPnum()%></li>
</ul>

</div>
<div class="example-bottom">
<a><span class="shoppingcar">加入购物车</span></a>
<a><span class="shoppingcar">关注</span></a>
</div>
</div>
<hr>
 <%} %>
 </div>

  <div class="searchbox">
  <p style="margin-left:250px;">重新搜索<input  style="height:40px ;width:400px;""type="text"/>
  <input  style="background:#f2f2f2;height:40px;width:70px;"  type="submit" value="搜索"/></p>
  </div>
 </div>
   
  <jsp:include page="footer.jsp" flush="true"/>
  </body>
</html>
