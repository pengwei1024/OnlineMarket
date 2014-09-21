<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="css/orderList.css"/>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
<div class="personHeader"><strong>我的订单</strong></div>
	<c:forEach items="${requestScope.list}" var="olf">
  		<h3>订单号:${olf.user_ID }<br></h3>
  		<table class="order_info" style="width:100%">
  			<tr>
  			<td>用户名:${olf.userName}</td>
  			<td>订单金额 :${olf.money }</td>
  			<td>下单时间 :${olf.ordertime }</td>
  			</tr>
  			<tr>
  				<td>收件人：${olf.receiverName}</td>
  				<td>收货地址 :${olf.receiverAddress }</td>
  				<td>
  					联系电话：${olf.receiverTel}
  				</td>
  			</tr>
  			<tr class="order_state">
  				<td colspan="3">
  				支付状态 :<c:if test="${olf.paystate=='0'}">
				<font color="red"><c:out value="未支付"></c:out> </font>
				<button class="btn btn-danger">立即支付</button>
				</c:if>
				<c:if test="${olf.paystate=='1'}">
				<font color="orang"><c:out value="已支付"></c:out> </font>
				<button class="btn btn-warning">提醒发货</button>
				</c:if>
				<c:if test="${olf.paystate=='2'}">
				<font color="blue"><c:out value="已发货"></c:out> </font>
				<button class="btn btn-info search_logistis">查看物流</button>
				</c:if>
  					
  				</td>
  			</tr>
  		</table>
		<table  class="table">
			<tr>
				<th>商品名称</th>
				<th>商品种类</th>
				<th>购买数量</th>
				<th>商品单价</th>
				<th>总金额</th>
			</tr>	
			<c:forEach items="${olf.bookMap}" var="entry">
				<tr>
					<td ><img height="50px" src='${entry.key.bookPicture}'/>${entry.key.bookName }</td>
					<td>${entry.key.bookType }</td>
					<td>${entry.value }</td>
					<td>${entry.key.bookPrice }</td>
					<td>${entry.key.bookPrice * entry.value }</td>
				</tr>
			</c:forEach>
		</table>
		<hr style="padding:10px 0;"/>
  	</c:forEach>
</div>
<style type="text/css">
  		.modal-content{
  			min-height:450px;
  		}
  		.modal-content iframe{
  			width:100%;
  			height:100%;
  		}
  	</style>
<div id="myModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
  	
    <div class="modal-content">
    <iframe src="http://localhost:8080/OnlineMarket/logistics"></iframe>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(".search_logistis").click(function(){
		$('#myModal').modal('toggle');
	});
	
</script>
<jsp:include page="footer.jsp"></jsp:include>
