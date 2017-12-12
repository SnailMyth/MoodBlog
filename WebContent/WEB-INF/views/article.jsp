<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
<c:import url="head.jsp"></c:import>
<link rel="stylesheet" href="css/calendar.css">
<style type="text/css">
.content_word {
	padding-right: 15px;
}

.title {
	margin-top: 50px;
}

#calendar {
	font: 500 14px 'roboto';
	color: #333;
	background-color: #fafafa;
}
ul, ol, li {
	list-style: none;
	padding: 0;
	margin: 0;
}

</style>
<script type="text/javascript">


$(window).load(function() {
	var url=baseUrl+"/get/4";
	console.log(url);
	$.getJSON(url, function(json){
		  console.log(json);
		  $(".content").html(json.data.content);
		  $(".title").html("<strong>"+json.data.title+"</strong>");
		  
		});
});
	//$(document).ready(function() {

	//});
</script>
</head>
<body>
	<div>
		<%@ include file="header.jsp"%>
	</div>
	<article style="width:1400px;">
	<div class="container">
		<div class="banner">
			<p data-scroll-reveal="enter top over 2s">我们不停的翻弄着回忆，却再也找不回那时的自己</p>
			<p data-scroll-reveal="enter left over 2s after 1s">人生，是一场盛大的遇见。若你懂得，就请珍惜。</p>
			<p data-scroll-reveal="enter bottom over 2s after 2s">无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候.</p>
		</div>
		<div class="container"
			style="margin-left: 0px; margin-right: 0px; background: #fff; padding: 0px;">
			<div class="container"
				style="padding-left: 0px; padding-right: 0px; margin: 10px;">
				<div class="row">
					<div class="col-md-3">
						<div id="calendar">
							<div id="ca" style="margin-top:20px;"></div>
						</div>
					</div>
					<div class="col-md-9">
						<!-- 标题 -->
						<h1 class="content_word title">文章标题</h1>
						<!-- 标题 -->
						<div class="content_word author"></div>
						<!-- 文章内容 -->
						<font size="3"><div class="content_word content"></div></font>

						<div class="content_word foot">this is fragment foot of
							article</div>

						<!-- 文章底部作者信息 -->
						<div class="content_word footer_author">this is author
							details</div>


						<!-- 文章评论列表 -->
						<div class="comment-list">
							<!-- 用户评论 -->
							<div class="new_commit"></div>
							<div class="normal-comment-list"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
	
	<script src="js/calendar.js"></script> 
<script>
    $('#ca').calendar({
        width: 300,
        height: 270,
        data: [
			{
			  date: '2015/12/24',
			  value: 'Christmas Eve'
			},
			{
			  date: '2015/12/25',
			  value: 'Merry Christmas'
			},
			{
			  date: '2016/01/01',
			  value: 'Happy New Year'
			}
		],
        onSelected: function (view, date, data) {
            console.log('view:' + view);
            console.log('data:' + (data || 'None'));
        }
    });
</script>
</body>
</html>
