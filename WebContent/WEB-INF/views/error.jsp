<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String basePath = request.getContextPath();
%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-2.1.4.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
.h60 {
	height: 60px;
}
</style>
</head>
<body>
	
	Error Page!!<br/>
	<label>${ex.getMessage()}</label>
</body>
</html>