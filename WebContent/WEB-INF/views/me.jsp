<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="head.jsp"></c:import>
<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/responsive.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/colorbox.css" type="text/css"
	media="screen">

<script type="text/javascript" src="js/colorbox.js"></script>
<script type="text/javascript" src="js/timeliner.min.js"></script>


<script>
	function item(month, data) {
		this.month = month;
		this.data = data;
	}

	function translateJson(data) {
		var i = 0;
		var txt = "<div id=\"timelineContainer\" class=\"timelineContainer\"><div class=\"timelineToggle\"><p><a class=\"expandAll\">open</a></p></div><br class=\"clear\">";
		for ( var time in data) {
			txt = txt + "<div class='timelineMajor'>";
			txt = txt + "<h2 class='timelineMajorMarker'><span>" +time+"</span></h2>";
			var artiles = data[time];
			for (var num in artiles) {
				txt = txt + "<dl class=\"timelineMinor\"><dt id=\"item"+i+"\"><a>"+artiles[num].title+"</a></dt>";
				//<dd class="timelineEvent" id="item1EX" style="display: none;"><h3>1955年8月28日</h3><p></p><br class="clear"></dd>
				txt = txt +"<dd class=\"timelineEvent\" id=\"item"+i+"EX\" style=\"display: none;\">"+artiles[num].des+"</p><br class=\"clear\"></dd></dl>";
				i ++;
			}
			txt = txt + "</div>";
		}
		txt = txt + "<br class=\"clear\"></div>";
		
		$("#content").html(txt);
		$.timeliner({
			startOpen : [ '#item0EX' ]
		});
		
		$.timeliner({
			timelineContainer : '#timelineContainer_2'
		});
		// Colorbox Modal
		$(".CBmodal").colorbox({
			inline : true,
			initialWidth : 100,
			maxWidth : 682,
			initialHeight : 100,
			transition : "elastic",
			speed : 750
		});
		
	}

	$(window).load(function() {
		var url = baseUrl + "/list/2";
		$.getJSON(url, function(json) {

			translateJson(json.data);

		});
	});

	$(document).ready(function() {
		
		
	});
</script>
<style>
</style>

<title>Insert title here</title>
</head>
<body>
	<div>
		<%@ include file="header.jsp"%>
	</div>

	<article>
	<div class="container">
		<div class="banner">
			<p data-scroll-reveal="enter top over 2s">我们不停的翻弄着回忆，却再也找不回那时的自己</p>
			<p data-scroll-reveal="enter left over 2s after 1s">人生，是一场盛大的遇见。若你懂得，就请珍惜。</p>
			<p data-scroll-reveal="enter bottom over 2s after 2s">无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候.</p>
		</div>
		<h1>线性时间轴</h1>
		<h2>民权运动1954-1964</h2>
		<div id="content">
			
		</div>
	</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>