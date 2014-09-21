//用户页表单弹出和隐藏
$(document).ready(function() {
	$("#personPswHeader").click(function(){
		$("#pswForm").slideToggle();
	});
	
	$("#changebutton").click(function(){
		$(".baseinfo").css("border-left","1px solid #aaa");
		$(".baseinfo").css("border-right","1px solid #ddd");
		$(".baseinfo").css("border-top","1px solid #aaa");
		$(".baseinfo").css("border-bottom","1px solid #ddd");
		
		$("input.baseinfo").each(function(){
			$(this).removeAttr("readonly");
		});
		
		$("#updateSubtmit").css("display","inline");
		$("#cancelbutton").css("display","inline");
		$("#changebutton").css("display","none");

		
	});
	
	$("#updateSubtmit").click(function(){
		$("input.baseinfo").each(function(){
			$(this).attr("readOnly","true");;
		});
		$("#changebutton").css("display","inline");
		$("#updateSubtmit").css("display","none");
		$("#cancelbutton").css("display","none");
	});
	
	$("#cancelbutton").click(function(){
		$(".baseinfo").css("border","none");
		$("input.baseinfo").each(function(){
			$(this).attr("readOnly","true");
		});
		$("#changebutton").css("display","inline");
		$("#updateSubtmit").css("display","none");
		$("#cancelbutton").css("display","none");
	});
});