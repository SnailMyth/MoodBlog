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
<script type="text/javascript">
	
</script>
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
		<div class="container"
			style="margin-left: 0px; margin-right: 0px; background: #fff; padding: 0px;">
			<div class="container"
				style="padding-left: 0px; padding-right: 0px; margin: 10px;">
				<div class="row">
					<div class="col-md-3">
						<div class="b-categories-filter" style="margin: 10px;">
							<h4
								class="f-primary-b b-h4-special f-h4-special--gray f-h4-special">blog
								categories</h4>
							<ul>
								<li><a class="f-categories-filter_name" href="#">Web
										Design</a></li>
								<li><a class="f-categories-filter_name" href="#">Smart
										Phone</a></li>
								<li><a class="f-categories-filter_name" href="#">Latop</a></li>
								<li><a class="f-categories-filter_name" href="#">Apple
										Store</a></li>
								<li><a class="f-categories-filter_name" href="#">Wordpress
										Theme</a></li>
								<li><a class="f-categories-filter_name" href="#">Web
										Design</a></li>
								<li><a class="f-categories-filter_name" href="#">Sport</a></li>
								<li><a class="f-categories-filter_name" href="#">Fashion</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-9">
						<!-- 标题 -->
						<h1 class="content_word title"><%= %>
						
						
						</h1>
						<!-- 标题 -->
						<div class="content_word author">this is fragment of author</div>
						<!-- 文章内容 -->
						<div class="content_word content">this is fragment of
							article</div>

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
</body>
</html>
