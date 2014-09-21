<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	for (int j = 1; j < 3; ++j) {
%>
<style>
.detailBook{width:160px; text-align:center;}
</style>
<dl class="index_goods_type_content">
	<dt>
		<span><%=j%>F</span><b>电子书</b>
	</dt>
	<c:forEach items="${requestScope.list_saleBook}" var="book">
		<dd>
			<a
				href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}">
				<img src="${book.bookPicture }" width="160px" height="160px"
				title="${book.bookName}" />
			</a>
			<div class="detailBook"> 
				<div>
					<a
						href="${pageContext.request.contextPath }/BookInfoServlet?id=${book.bookId}"
						class="index_new_book_title">
						${book.bookName}
					</a>
				</div>
				<div>
					<c:set var="showBookName" value="${book.bookIntroduction} " />
					 <c:choose>
						<c:when test="${fn:length(showBookName) > 10}">
							<c:out value="${fn:substring(showBookName, 0, 20)}......" />
						</c:when>
						<c:otherwise>
							<c:out value="${showBookName}" />
						</c:otherwise>
					</c:choose>
				</div> 
			</div>	
		</dd>
	</c:forEach>
</dl>
<%
	}
%>