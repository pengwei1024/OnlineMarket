
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="index_focus">
	<ul class="index_focus_ul">
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/0.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/1.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/2.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/3.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/4.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/5.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/6.jpg" /></a></li>
		<li><a href="javascript:void(0)" target="_blank"><img
				src="images/7.jpg" /></a></li>
	</ul>
	<a class="prev" href="javascript:void(0)"></a> <a class="next"
		href="javascript:void(0)"></a>
	<div class="num">
		<ul></ul>
	</div>
</div >
<dl class="index_new_book">
	<dt><a name='newBook'>新书上架</a></dt>
	<c:forEach items="${requestScope.list_newBook}" var="book">
		<dd>
			<a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">
				<img src="${book.bookPicture }" width="160px" height="160px"
				title="${book.bookName}" />
			</a> <a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}"
				class="index_new_book_title"><c:set var="showBookName"
					value="${book.bookName} " /> <c:choose>
					<c:when test="${fn:length(showBookName) > 10}">
						<c:out value="${fn:substring(showBookName, 0, 10)}......" />
					</c:when>
					<c:otherwise>
						<c:out value="${showBookName}" />
					</c:otherwise>
				</c:choose> </a> <span class="index_new_book_author">${book.bookAuthor }</span> <span
				class="index_new_book_price">¥${book.bookPrice }</span>
		</dd>
	</c:forEach>
</dl>
<dl class="index_new_book">
	<dt><a name='saleBook'>特价书籍</a></dt>
	<c:forEach items="${requestScope.list_saleBook}" var="book">
		<dd>
			<a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">
				<img src="${book.bookPicture }" width="160px" height="160px"
				title="${book.bookName}" />
			</a> <a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}"
				class="index_new_book_title"><c:set var="showBookName"
					value="${book.bookName} " /> <c:choose>
					<c:when test="${fn:length(showBookName) > 10}">
						<c:out value="${fn:substring(showBookName, 0, 10)}......" />
					</c:when>
					<c:otherwise>
						<c:out value="${showBookName}" />
					</c:otherwise>
				</c:choose> </a> <span class="index_new_book_author">${book.bookAuthor }</span> <span
				class="index_new_book_price">¥${book.bookPrice }</span>
		</dd>
	</c:forEach>
</dl>
<dl class="index_new_book">
	<dt><a name='sellingBook'>畅销书籍</a></dt>
	<c:forEach items="${requestScope.list_sellingBook}" var="book">
		<dd>
			<a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">
				<img src="${book.bookPicture }" width="160px" height="160px"
				title="${book.bookName}" />
			</a> <a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}"
				class="index_new_book_title"> <c:set var="showBookName"
					value="${book.bookName} " /> <c:choose>
					<c:when test="${fn:length(showBookName) > 10}">
						<c:out value="${fn:substring(showBookName, 0, 10)}......" />
					</c:when>
					<c:otherwise>
						<c:out value="${showBookName}" />
					</c:otherwise>
				</c:choose>
			</a> <span class="index_new_book_author">${book.bookAuthor }</span> <span
				class="index_new_book_price">¥${book.bookPrice }</span>
		</dd>
	</c:forEach>
</dl>