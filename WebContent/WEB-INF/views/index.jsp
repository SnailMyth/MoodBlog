<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<div class="container"
		style="margin-top: 10%; background-image: img/back.jpg">
		<div class="jumbotron">
			<h1><%=basePath.substring(1)%></h1>
			<fieldset style="">
				<legend>Welcome</legend>
				<form action="<%=basePath%>/login"
					class="bs-example bs-example-form" role="form"
					style="margin-left: 20%; width: 500px; height: 200px;">
					<div class="input-group h60" style="">
						<span class="input-group-addon">@</span> <input name="username"
							style="" style="" type="text" class="form-control h60"
							placeholder="username">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon" >@</span> <input name="password"
							style="" style="" type="password"
							class="form-control h60">
					</div>
					<div class="input-group h60" style="margin-top: 10px;"">
						<input type="submit" value="Sign In" class="btn btn-primary" style="margin-left: 190px;">
						<input type="button" value="Sign Up" class="btn btn-primary" style="margin-left: 10px;">
					</div>
					<br>
				</form>
			</fieldset>
		</div>
	</div>

</body>
</html>