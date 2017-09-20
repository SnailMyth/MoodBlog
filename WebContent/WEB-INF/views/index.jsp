<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String basePath = request.getContextPath();
	
%>
<c:import url="head.jsp"></c:import>
<style type="text/css">
.h60 {
	height: 60px;
}
</style>
<script type="text/javascript">


</script>
</head>
<body>
	<c:import url="head.jsp"></c:import>
	<div class="container"
		style="margin-top: 10%; background-image: img/back.jpg">
		<div class="jumbotron">
			<h1><%=basePath.substring(1)%></h1>

			<hr>
			<label>welcome ${sessionScope.user.getUsername()}</label>
			<a href="<%=basePath%>/loginout">Login Out</a>

		</div>
	</div>

</body>
</html>