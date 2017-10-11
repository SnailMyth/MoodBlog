<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


function register(){
	window.location.href="<%=basePath%>/register"; 
}



function login(){
	var username = document.getElementById("username").value.trim();
	var password = document.getElementById("password").value.trim();
	
	$.ajax({
		type: "POST",
		url: "<%=basePath%>/login",
			dataType : "json",
			data : {
				j_username : username,
				j_password : password
			},
			success : function(data) {
				if (data.data == null) {
					alert(data.error_message);
				}else{
					alert("aa");
				}
			}
		});
	}
</script>
</head>
<body>
<!-- window.location.href="<%=basePath%>/index";  -->
	<div class="container"
		style="margin-top: 10%; background-image: img/back.jpg">
		<div class="jumbotron">
			<h1><%=basePath.substring(1)%></h1>
			<fieldset style="">
				<legend>Welcome</legend>
				<form method="POST" class="bs-example bs-example-form" action="<c:url value='j_spring_security_check'/>"
					style="margin-left: 20%; width: 500px; height: 200px;">
					<div class="input-group h60" style="">
						<span class="input-group-addon">@</span> <input id="username" name="j_username"
							type="text" class="form-control h60" placeholder="username">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon">@</span> <input id="password" name="j_password"
							type="password" class="form-control h60">
					</div>
					<div class="input-group h60" style="margin-top: 10px;">
						<input type="submit" value="Sign In" class="btn btn-primary"
							style="margin-left: 190px;"  /> <input
							type="button" value="Sign Up" class="btn btn-primary b_sign"
							style="margin-left: 10px;" onclick="register()" />
					</div>
					<br>
				</form>
			</fieldset>
		</div>
	</div>

</body>
</html>
