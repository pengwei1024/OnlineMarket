<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- header -->
<jsp:include page="header.jsp" flush="true" />

<link rel="stylesheet" type="text/css" href="css/product.css" />
<div id="content">
	<div class="book_intro_panel">
		<div id="ShowPictureBox">
			<img src="${book.bookPicture }">
		</div>
		<div id="ShowBigPictureBox"></div>
		<div class="book_intro_desp">
			<div>${book.bookName}</div>
			<div style="width:500px;">${book.bookIntroduction}</div>
			<div>
				<a href="#">${book.bookAuthor}</a>著
			</div>
			<div>
				<img src="images/icon_star.jpg" />已有<a href="#">${book.hit}</a>人评价,
				100%好评
			</div>
			<div>
				京 东 价：<span class="price">¥${book.bookPrice}</span>
			</div>
			<div>
				<div id="city_list">
					<span>配送至:</span> <select class="prov"></select> <select
						class="city" disabled="disabled"></select> <select class="dist"
						disabled="disabled"></select>
				</div>
			</div>
			<div>
				<span>购买数量:</span> <b class="book_intro_desp_mul"></b> <input
					type="text" value="1" /> <b class="book_intro_desp_add"></b>
				<c:if test="${book.pnum>0}">
					<font color="blue">有货</font>
				</c:if>
				<c:if test="${book.pnum<=0}">
					<font color="red">缺货</font>
				</c:if>
			</div>
			<div class="product_intro_btn_buy">
				<button onclick="location.href='${pageContext.request.contextPath }/AccouCartServlet?id=${book.bookId }'"> </button>
				<button onclick="location.href='${pageContext.request.contextPath }/AddToCartServlet?id=${book.bookId }'"></button>
			</div>
		</div>
	</div>
	<div class="book_content_panel clear">
		<!-- 相关书籍推荐 -->
		<div class="left">
			<h4>相关书籍推荐</h4>
			<ul>
				<%
					for (int i = 0; i < 10; ++i) {
				%>
				<li><img src="images/23525592-1_l_1.jpg"> <a href="#">好孩子：三分天注定，七分靠教育</a>
					<span> <img src="images/icon_star.jpg" /> <span>(20条评论)</span>
				</span> <span>￥19.50[6.1折]</span></li>
				<%
					}
				%>
			</ul>
		</div>
		<!-- 书籍详细介绍和评论 -->
		<div class="left">
			<p>Q: 咦，这里做什么的?</p>
			<p>A: 这里显示书籍的详细介绍和用户评价</p>
			${book.bookIntroduction}
		</div>
	</div>
	<div class="clear"></div>
</div>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.cityselect.js"></script>
<script type="text/javascript" src="js/jquery.JNMagnifier.js"></script>
<script type="text/javascript" src="js/city.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#ShowPictureBox").JNMagnifier({
			renderTo : "#ShowBigPictureBox"
		});
		$("#city_list").citySelect({
			prov : "北京",
			nodata : "none"
		});
	});
</script>

<!-- footer -->
<jsp:include page="footer.jsp" flush="true" />