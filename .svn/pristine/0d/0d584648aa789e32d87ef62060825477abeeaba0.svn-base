<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="css/pbl.css" />
<link rel="stylesheet" type="text/css" href="css/book.css" />
<jsp:include page="header.jsp"></jsp:include>


<div id="content">
	<div class="book_nav left">
		<img src="images/dog.png" />
		<%
			for (int i = 0; i < 2; i++) {
		%>
		<dl>
			<dt>商品惠</dt>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
			<dd>新书上架</dd>
		</dl>
		<%
			}
		%>
	</div>
	<div class="containter left">
		<div id="waterfall">
			<c:forEach items="${requestScope.list}" var="book">
				<dl>
					<dt>
						<a target="blank"
							href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookName}</a>
					</dt>
					<dd>
						<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">
						<img src="${book.bookPicture}" alt="${book.bookName}"
							width="160px" height="160px" /></a>
					</dd>
					<dd>
						<p>
							<c:set var="introduce" value="${book.bookIntroduction}" />
							<c:choose>
								<c:when test="${fn:length(introduce) > 10}">
									<c:out value="${fn:substring(introduce, 0, 10)}......" />
								</c:when>
								<c:otherwise>
									<c:out value="${book.bookIntroduction}" />
								</c:otherwise>
							</c:choose>
						</p>
					</dd>
					<dd class="more">
						<span>¥${book.bookNowPrice}</span> 
						<span onclick="location.href='${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}'">查看详情</span>
					</dd>
				</dl>
			</c:forEach>
		</div>
	</div>
</div>
<div class="clear"></div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/pbl.js"></script>
<script type="text/javascript">
	$(window).scroll(function() {
		if ($(window).scrollTop() > 100) {
			$("#content .book_nav").css({
				'position' : 'fixed',
				'top' : '20px'
			});
			$(".containter").css({
				'marginLeft' : '200px'
			});
			$("#content .book_nav>img").css('display', 'inline');
		} else {
			$("#content .book_nav").css({
				'position' : 'relative'
			});
			$(".containter").css({
				'marginLeft' : '0'
			});
			$("#content .book_nav>img").css('display', 'none');
		}
	});
</script>
<jsp:include page="footer.jsp"></jsp:include>
