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
	$(document).ready(function() {
		$.timeliner({
			startOpen : [ '#19550828EX', '#19630828EX' ]
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
					<a class="expandAll">+ 全部展开</a>
				</p>
			</div>
			<br class="clear">
			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1954</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19540517">
						<a>布朗诉教育委员会</a>
					</dt>
					<dd class="timelineEvent" id="19540517EX" style="display: none;">
						<h3>1954年5月17日</h3>
						<p>美国最高法院相传一致9-0决定在布朗诉托皮卡教育局案，打开大门，民权运动最终种族融合在美国社会的各个方面。推翻Plessy
							v. Ferguson（1896），法院裁定“隔离的教育设施是不平等的。</p>

					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->
			</div>
			<!-- /.timelineMajor -->

			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1955</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19550828">
						<a>艾莫特·泰尔</a>
					</dt>
					<dd class="timelineEvent" id="19550828EX" style="display: none;">
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

			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1957</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19570904">
						<a>小石城</a>
					</dt>
					<dd class="timelineEvent" id="19570904EX" style="display: none;">
						<h3>September 4, 1957</h3>


						<p>
							Three years removed from the Brown v. Board of Education
							decision, Arkansas Gov. Orval Faubus orders the National Guard to
							stop nine black students from attending the all-white Little Rock
							Central High School. President Dwight D. Eisenhower intervenes by
							federalizing the National Guard and deploying Army troops to
							protect the students, stripping the state of power. Media
							coverage of the physical and verbal harassment the black students
							were subjected to is reported and broadcast around the world. In
							the end, they successfully integrate Central High. <sup>5</sup>
						</p>

						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->
			</div>
			<!-- /.timelineMajor -->

			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1961</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19610504">
						<a>自由乘车运动</a>
					</dt>
					<dd class="timelineEvent" id="19610504EX" style="display: none;">
						<h3>May 4, 1961</h3>

						<p>
							The first of many civil rights “Freedom Rides” leaves Washington,
							D.C., for New Orleans. The Freedom Riders want to test the
							validity of the Supreme Court’s decision to outlaw racial
							segregation in bus terminals and through interstate bus travel.<sup>6</sup>
							Angry white mobs – with the blessing of Alabama law enforcement –
							meet the convoy in Anniston and Birmingham, brutally beating the
							Freedom Riders and firebombing one of the buses.<sup>7</sup>
						</p>
						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->
			</div>
			<!-- /.timelineMajor -->

			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1963</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19630828">
						<a>“我有一个梦想”</a>
					</dt>
					<dd class="timelineEvent" id="19630828EX" style="display: none;">
						<h3>August 28, 1963</h3>

						<p>In one of the largest gatherings in the nation’s capital
							and one of the first to be broadcast live on national television,
							at least 200,000 civil rights protesters stage a March on
							Washington concluding at the Lincoln Memorial. The march is
							dedicated to jobs and freedom and takes place 100 years after
							the&nbsp;Emancipation Proclamation. The highlight of the event is
							Martin Luther King Jr.’s historic “I Have a Dream” speech.</p>

						<blockquote>
							I have a dream that one day this nation will rise up and live out
							the true meaning of its creed: "We hold these truths to be
							self-evident: that all men are created equal."
							<div class="attribution">&mdash;Martin Luthar King Jr.</div>
						</blockquote>

						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->

			</div>
			<!-- /.timelineMajor -->

			<div class="timelineMajor">
				<h2 class="timelineMajorMarker">
					<span>1964</span>
				</h2>
				<dl class="timelineMinor">
					<dt id="19640702">
						<a>民权法案</a>
					</dt>
					<dd class="timelineEvent" id="19640702EX" style="display: none;">
						<h3>July 2, 1964</h3>
						<p>
							President Lyndon B. Johnson signs the Civil Rights Act of 1964,
							mandating equal opportunity employment, and complete
							desegregation of schools and other public facilities. It also
							outlaws unequal voter registration requirements.<sup>13</sup>
							Although it would take years for these changes to take effect in
							communities around the country, the law is a monumental victory
							for the civil rights movement.
						</p>

						<br class="clear">
					</dd>
					<!-- /.timelineEvent -->
				</dl>
				<!-- /.timelineMinor -->
				<dl class="timelineMinor">
					<dt id="19641014">
						<a>诺贝尔和平奖</a>
					</dt>
					<dd class="timelineEvent" id="19641014EX" style="display: none;">
						<h3>October 14, 1964</h3>
						<p>Martin Luther King Jr. is awarded the Nobel Peace Prize; at
							35, he is the youngest recipient.</p>
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