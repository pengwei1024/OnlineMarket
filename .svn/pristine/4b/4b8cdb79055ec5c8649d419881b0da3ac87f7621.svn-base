<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>

<dl class="index_right_dl index_right_notice">
	
</dl>

<dl class="index_right_dl index_right_dl_list">
	<dt>新书热销榜</dt>
	<c:forEach items="${requestScope.list_newBook}" var="book" varStatus="statu">
	<dd>
	<span>${statu.count} </span>
		<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookAuthor }:
		<c:choose>
		  <c:when test="${fun:length(book.bookName)>8}">
		    <c:out value="${fun:substring(book.bookName, 0, 8)}......" />
		  </c:when>
		  <c:otherwise>
				<c:out value="${book.bookName}" />
		 </c:otherwise>
		</c:choose>
		</a>
	</dd>
	</c:forEach>
</dl>
<dl class="index_right_dl index_right_dl_list">
	<dt>图书热销总榜</dt>
	<c:forEach items="${requestScope.list_sellingBook}" var="book" varStatus="statu">
	<dd>
	<span>${statu.count} </span>
		<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookAuthor }:
		<c:choose>
		  <c:when test="${fun:length(book.bookName)>8}">
		    <c:out value="${fun:substring(book.bookName, 0, 8)}......" />
		  </c:when>
		  <c:otherwise>
				<c:out value="${book.bookName}" />
		 </c:otherwise>
		</c:choose>
		</a>
	</dd>
	</c:forEach>
</dl>
<dl class="index_right_dl index_right_dl_list">
	<dt>电子书榜</dt>
	<c:forEach items="${requestScope.list_saleBook}" var="book" varStatus="statu">
	<dd>
	<span>${statu.count} </span>
		<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookAuthor }:
		<c:choose>
		  <c:when test="${fun:length(book.bookName)>8}">
		    <c:out value="${fun:substring(book.bookName, 0, 8)}......" />
		  </c:when>
		  <c:otherwise>
				<c:out value="${book.bookName}" />
		 </c:otherwise>
		</c:choose>
		</a>
	</dd>
	</c:forEach>
</dl>
<dl class="index_right_dl index_right_dl_list">
	<dt>读者推荐</dt>
	<c:forEach items="${requestScope.list_sellingBook}" var="book" varStatus="statu">
	<dd>
	<span>${statu.count} </span>
		<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookAuthor }:
		<c:choose>
		  <c:when test="${fun:length(book.bookName)>8}">
		    <c:out value="${fun:substring(book.bookName, 0, 8)}......" />
		  </c:when>
		  <c:otherwise>
				<c:out value="${book.bookName}" />
		 </c:otherwise>
		</c:choose>
		</a>
	</dd>
	</c:forEach>
</dl>
<dl class="index_right_dl index_right_dl_list">
	<dt>猜你喜欢</dt>
	<c:forEach items="${requestScope.list_saleBook}" var="book" varStatus="statu">
	<dd>
	<span>${statu.count} </span>
		<a href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">${book.bookAuthor }:
		<c:choose>
		  <c:when test="${fun:length(book.bookName)>8}">
		    <c:out value="${fun:substring(book.bookName, 0, 8)}......" />
		  </c:when>
		  <c:otherwise>
				<c:out value="${book.bookName}" />
		 </c:otherwise>
		</c:choose>
		</a>
	</dd>
	</c:forEach>
</dl>