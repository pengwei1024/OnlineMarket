<%@ page language="java" import="java.util.*,com.cxft.onlinemarket.dao.*,
com.cxft.onlinemarket.model.*,com.cxft.onlinemarket.utils.*" 
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminPATH = basePath+"admin";
int aid =Integer.parseInt(request.getParameter("aid"));
BbsDao dao =new BbsDao();
BBS bbs = dao.get(aid);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/bootstrap.min.css">
  </head>
  
  <body style="padding:10px;">
   <form action="article" method="post">
   <input type="hidden" name="action" value="updateArticle"/>
   <input type="hidden" name="bbsid" value="<%=bbs.getBbsId() %>"/>
   <div class="form-group">
    <label>请输入公告的标题</label>
     <div class="row" style="padding:0 17px;">
    	<input type="text" name="title" value="<%=bbs.getTitle() %>" class="col-md-6 form-control">
    </div>
  </div>
  <div class="form-group">
    <label>请输入公告的内容</label>
    <textarea id="editor_id" name="content" style="width:100%;height:400px;">
    <%=bbs.getContent() %>
   </textarea>
  </div>
   <input type="submit" class="btn btn-primary btn-block"/>
    </form>
   
<script charset="utf-8" src="admin/includes/editor/kindeditor.js"></script>
<script charset="utf-8" src="admin/includes/editor/lang/zh_CN.js"></script>
<script>
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script> 
</body>
</html>
