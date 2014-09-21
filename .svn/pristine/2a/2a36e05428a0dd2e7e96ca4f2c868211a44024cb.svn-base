<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.model.*" pageEncoding="utf-8"%>
<%
BBS bbs = (BBS)request.getAttribute("data");
if(bbs == null)
    response.sendRedirect("article?aid="+request.getParameter("aid"));
%>
<jsp:include page="header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="css/article.css"/>
<div id="content">
	<% if(bbs!=null){ %>
	<h2><%=bbs.getTitle() %></h2>
	<div class="article_time">时间：<%=bbs.getInTime()%></div>
	<article>
		<%=bbs.getContent()%>
	</article>
	<br/><br/>
	<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
	<% } %>
</div>
<jsp:include page="footer.jsp"></jsp:include>