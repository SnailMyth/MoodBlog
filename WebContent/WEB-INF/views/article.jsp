


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="head.jsp"></c:import>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<!-- 标题 -->
		<h1 class="title">this is article Title</h1>
		<!-- 标题 -->
		<div class="author">
			this is fragment of author
		</div>
		<!-- 文章内容 -->
		<dir class="content">
			this is fragment of article
		</dir>
		
		<dir class="foot">
			this is fragment foot of article
		</dir>
		
		<!-- 文章底部作者信息 -->
		<div class="footer_author">
			this is author details
		</div>
		
		<!-- 文章评论列表 -->
		<div class="comment-list">
			<!-- 用户评论 -->
			<div class="new_commit">
				
			</div>
			<div class="normal-comment-list">
			
			</div>
		</div>
		
		
		
		
	</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>