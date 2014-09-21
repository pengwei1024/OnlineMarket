<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp" flush="true" />

<link rel="stylesheet" type="text/css" href="css/order.css" />
<div id="content">
	<div class="container">
		<h2>我的订单</h2>
		<form action="${pageContext.request.contextPath }/OrderServlet"
			method="post">
			<div class="form-group">
				<label class="control-label">收货地址</label>
				<div>
					<textarea name="receiverAddress" rows="3" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">收件人</label>
				<div>
					<input type="text" name="receiverName" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">联系电话</label>
				<div>
					<input type="text" name="receiverTel" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">备注信息</label>
				<div>
					<textarea rows="5" name="orderRemark" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">支付方式</label><br /> <label
					class="radio-inline"> <input type="radio" name="payType"
					checked value="在线支付">在线支付
				</label> <label class="radio-inline"> <input type="radio"
					name="payType" value="货到付款">货到付款
				</label>
			</div>

		</form>
		<button id="finish_btn" class="btn btn-success">下一步</button>
		<dl class="order_info">
			<dt>核对订单信息</dt>
			<dd>
				<b>收货人信息</b>
				<div>
					收件人:<span class="user_name"></span>&nbsp;&nbsp;电话:<span class="user_phone"></span>
				</div>
				<div>送件地址：<span class="user_address"></span></div>
			</dd>
			<dd>
				<b>支付及配送方式</b>
				<div>支付方式：<span class="user_pay_type"></span></div>
				<div>在线支付 快递 中小件商品 工作日、双休日与假日均可送货</div>
			</dd>
			<dd>
				<b>发票信息</b>
				<div>普通发票（纸质） 个人 明细</div>
				<div>温馨提示：发票的开票金额不包括京东卡/京东E卡、优惠券和京豆支付部分</div>
			</dd>
			<dd>
				<b>商品清单</b>
				<c:if test="${empty sessionScope.cartmap}">
						<h2>
							<a href="${pageContext.request.contextPath }/BookListServlet">购物车空空如也</a>
						</h2>
				</c:if>
			    <c:if test="${not empty sessionScope.cartmap}">
						<table class="table table-striped">
							<tr>
								<th>商品名称</th>
								<th>商品单价</th>
								<th>购买数量</th>
								<th>库存状态</th>
								<th>总价</th>

							</tr>
							<c:set var="money" value="0" />
							<c:forEach items="${sessionScope.cartmap}" var="entry">
								<tr>
									<td>${entry.key.bookName }</td>
									<td>${entry.key.bookPrice }元</td>
									<td>${entry.value}件</td>
									<td><c:if test="${entry.value<=entry.key.pnum}">
											<font color="blue">有货</font>
										</c:if> <c:if test="${entry.value>entry.key.pnum}">
											<font color="red">缺货</font>
										</c:if></td>
									<td>${entry.key.bookPrice * entry.value }元<c:set
											var="money"
											value="${money + entry.key.bookPrice * entry.value }" />
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="pay_btn">
							<font>总价:${money }元</font>
							 <button id="submit_order"></button>
						</div>
					</c:if>
					<div>
				   
					</div>
				</div>
			</dd>
		</dl>

</div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$("#submit_order").bind("click",function(){
		$("form").submit();
	});
	$("#finish_btn").bind("click", function() {
		if ($(this).html().trim() == "下一步") {
			$("form").css("display", "none");
			$(".order_info").css("display", "block");
			$(this).html("上一步");
			
			$(".user_name").html($("input[name='receiverName']").val());
			$(".user_phone").html($("input[name='receiverTel']").val());
			$(".user_address").html($("textarea[name='receiverAddress']").val());
			$(".user_pay_type").html($("input[name='payType']:checked").val());
			
		} else {
			$("form").css("display", "block");
			$(this).html("下一步");
			$(".order_info").css("display", "none");
		}
	});
</script>
<jsp:include page="footer.jsp" flush="true" />