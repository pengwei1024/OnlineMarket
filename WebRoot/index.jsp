<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<jsp:include page="header.jsp" flush="true" />
<link rel="stylesheet" type="text/css"
	href="css/lrtk.css" />
<link rel="stylesheet" type="text/css"
	href="css/index.css" />
<div id="content">
	<div class="activity_panel">
		<img src="images/event_0805.jpg" />
	</div>
	<div class="index_content_panel" >
		<div class="index_container_left">
			<%@include file="./includes/index_container_left.jsp" %>
		</div>
		<div class="index_container_center">
			<%@include file="./includes/index_container_center.jsp" %>
		</div>
		<div class="index_container_right">
			<%@include file="./includes/index_container_right.jsp" %>
		</div>
	</div>
	<div class="clear">
		<%@include file="./includes/index_goods_type_content.jsp" %>
	</div>
</div>


<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="js/jquery.superslide.2.1.1.js"></script>
<script type="text/javascript">
	$(function() {

		$("#sidebar-menu > ul > li").hover(function() {
			$(this).addClass("selected");
			$(".menu-panel", this).addClass("selected");
			var bgImg = $(".menu-item", this).css("background-image");
			bgImg = bgImg.replace(".", "-hover.");
			$(".menu-item", this).css("background-image", bgImg);
		}, function() {
			$(this).removeClass("selected");
			$(".menu-panel", this).removeClass("selected");
			var bgImg = $(".menu-item", this).css("background-image");
			bgImg = bgImg.replace("-hover.", ".");
			$(".menu-item", this).css("background-image", bgImg);
		});

		$(".index_focus").hover(function() {
			$(this).find(".prev,.next").fadeTo("show", 0.1);
		}, function() {
			$(this).find(".prev,.next").hide();
		});
		$(".prev,.next").hover(function() {
			$(this).fadeTo("show", 0.7);
		}, function() {
			$(this).fadeTo("show", 0.1);
		});
		$(".index_focus").slide({
			titCell : ".num ul",
			mainCell : ".index_focus_ul",
			effect : "fold",
			autoPlay : true,
			delayTime : 700,
			autoPage : true
		});
		//显示最新动态
		$.ajax({
			"url":"article",
			"type":"get",
			"data":"action=getList",
			success:function(msg){
				$(".index_right_notice").html(msg);
			}
		});
	});
</script>

<jsp:include page="footer.jsp" flush="true" />

