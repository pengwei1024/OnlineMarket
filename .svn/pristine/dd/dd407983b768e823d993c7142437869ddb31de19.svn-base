var holy={};
//工具栏
holy.toolBar=function(){
	
};
//瀑布流
holy.wFall=function (){
	var box = $('#waterfall').children("dl");
	var boxer = [];//存放内容的数组
	var timer;
	var total = box.length;
	var dlNo=0;//页面中已经生成的dl数量
	var i=0;//源dl的索引值
	$.each(box,function(){boxer.push($(this).html());});//获取源内容，生成数组
	$('#waterfall').html("<div class='col' id='colA'></div><div class='col' id='colB'></div><div class='col' id='colC'></div><div class='col' id='colD'></div><div id='addMore'>显示更多</div>");//生成新的框架结构
	var colA=$('#colA');
	var colB=$('#colB');
	var colC=$('#colC');
	var colD=$('#colD');
	var hA,hB,hC,hD;//四栏的高度
	function show(showdlNo){//添加新内容，参数为添加的数量
		for(var n=0;n<showdlNo;n++){
			hA = colA.height();
			hB = colB.height();
			hC = colC.height();
			hD = colD.height();
			if(i==total){i=0;}
			if(hA<=hB&&hA<=hC&&hA<=hD){colA.append("<dl id='wf"+dlNo+"'>"+boxer[i++]+"</dl>");
			}else if(hB<=hC&&hB<=hD){colB.append("<dl id='wf"+dlNo+"'>"+boxer[i++]+"</dl>");
			}else if(hC<=hD){colC.append("<dl id='wf"+dlNo+"'>"+boxer[i++]+"</dl>");
			}else{colD.append("<dl id='wf"+dlNo+"'>"+boxer[i++]+"</dl>");}
			$('#wf'+dlNo++).fadeIn('300');
		}
	}
	show(8);//页面初始显示八个dl
	$(window).scroll(function(){
		if(dlNo<40){//设置页面中的滚动可显示dl的数量
			clearTimeout(timer);
			timer = setTimeout(function(){
				if($(document).scrollTop()+$(window).height()>$(document).height()-300){show(4);}
			},500);
		}else{$('#addMore').fadeIn('200');}
	});
	$('#addMore').click(function(){show(8)});
}
//小剧还是屈服在了ie6的淫威之下
holy.fixie6=function (){
	$('head').append("<script src='/skin/holy/iepng.js' type='text/javascript'></script><style>#killie6{height:140px;padding:40px 200px 0px;background:#fff;font-size:16px;border-bottom:5px solid #444;color:#222}#killie6 h1{text-align:center;font-size:20px;border-bottom:1px dashed #ddd;}#killie6 a{text-decoration:underline;padding-right:1em;color:#800;}#toolbar{position:'absolute'}#killie6 a:hover{color:red}.skin_a,.skin_b,.skin_c,body{background-position:center 180px;}</style>");
	$('body').prepend("<div id='killie6'><h1>老大，麻烦您更新下浏览器吧！</h1><p>矮油，就说你的，这么老的浏览器您怎么还在用啊，太out啦！提示下哈，博客中的部分特效您有可能无法正常查看哦！推荐您使用<a href='http://chrome.360.cn/'>360极速浏览器</a>或　<a href='http://www.google.com/chrome/?hl=zh-CN'>谷歌浏览器</a>，尝试体验更酷炫的页面效果吧！</a></p></div>");
	EvPNG.fix('div,a,span');
	$(window).scroll(function(){$('#toolbar').css({top:$(document).scrollTop()+$(window).height()/2});});
}
//切换域名 
holy.fixurl=function (){
	var hostname=window.location.hostname;
	if(hostname=="bh-lay.com"){window.location.hostname="bh-lay.com"}
	/*话说小剧也蛮无耻的(#‵′)凸*/
}
$(document).ready(function(){
//修正域名 ie6、7
	holy.fixurl();
	if($.browser.msie){if($.browser.version=="6.0"||$.browser.version=="7.0"){holy.fixie6();}}
//工具栏
	if($('#toolbar').length==0){holy.toolBar();}
	if($('#uyan_frame').length>0){holy.flyTo('#uyan_frame','给说个话呗','reply');}
	if($(".article").length>0){holy.readMode('.article','.main','.sidebar');}
	
//使用插件、函数
	if($('.article img').length>0){$('.article img').gallery();}
	if($('.photo img').length>0){$('.photo img').gallery();}

	if($('#keyboard').length>0){
		$('#keyboard').autoKey();
		holy.checkForm();
	}
	
	if($("#tabOne").length>0){holy.tab('#tabOne');}
	if($("#tabTwo").length>0){holy.tab('#tabTwo');}
	
	if($('.picText').length>0){showDetail('.picText div');}

	if($('#lay_accordion').length>0){holy.accordion();}
	if($('.grid').length>0){$('.grid img').showTitle();}
	
	if($('#focusTitle').length>0){diySkin();}
	if($('#aboutme').length>0){medetail();}
	if($('#serviceList').length>0){serviceList();}
	
	if($('#waterfall').length>0){holy.wFall();}
	if($('.codeArea').length>0){$('head').append("<script src='/skin/holy/codeArea.js' type='text/javascript'></script>");}
	if($(".shutdown").length>0){$('.shutdown').shutDown();}
});