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

	$(window).load(function() {
		var url = baseUrl + "/list/2";
		console.log(url);
		$.getJSON(url, function(json) {
			console.log(json.data);
			for(var i = 0;i < json.data.length;i++){
				var time = Number(json.data[i].time);
				var day = moment.unix(time);
				console.log(day.format("HH:MM"));
			}
			
		});
	});

	$(document).ready(function() {
		$.timeliner({
			startOpen : [ '#item1']
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
		<div id="timelineContainer" class="timelineContainer">
			<div class="timelineToggle">
				<p>
					<a class="expandAll">open</a>
				</p>
			</div>
			<br class="clear">


			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1955</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19550828">
						<a>艾莫特·泰尔</a>
					</dt>
					<dd class="timelineEvent" id="item1" style="display: none;">
						<h3>1955年8月28日</h3>
						<p>十四岁的非裔美国人埃米特被残忍杀害后，据说与白人妇女在访问亲戚在密西西比州。这是第一次，黑人和白人记者报道这次审判的集大成者”之一的第二十世纪最令人震惊的和持久的故事。”白被告，Roy
							Bryant和J.W.
							Milam，都被一个白人陪审团仅67分钟；后来他们详细描述为看杂志（付给他们4000美元）他们杀了为止。母亲坚持开放的棺材，和他残缺的身体，强大的图像引起强烈的反应，在全国和世界。</p>

						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->


				<dl class="timelineMinor">
					<dt id="19551201">
						<a>罗萨公园</a>
					</dt>
					<dd class="timelineEvent" id="19551201EX" style="display: none;">
						<h3>December 1, 1955</h3>
						<p>
							The arrest of Rosa Parks, a 42-year-old African-American
							seamstress and civil rights activist who refused to give up her
							bus seat to a white passenger, sets off a long anticipated bus
							boycott by residents of Montgomery, Ala. The 13-month protest and
							ensuing litigation eventually make it to the U.S. Supreme Court,
							which declares that segregation on public buses is
							unconstitutional.<sup>4</sup> The Montgomery bus boycott brings
							the Rev. Dr. Martin Luther King Jr. and his nonviolent approach
							to social change to the forefront of the civil rights movement.
						</p>

						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->
			</div>
			<!-- /.timelineMajor -->
			<br class="clear">
		</div>
		<!--timelineContainer -->
	</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>