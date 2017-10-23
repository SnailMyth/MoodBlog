<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<c:import url="head.jsp"></c:import>
<style type="text/css">
.h60 {
	height: 60px;
}
</style>
<script type="text/javascript">

	function signUp(){
		var username = document.getElementById("username").value.trim();
		var password = document.getElementById("password").value.trim();
		var repassword = document.getElementById("repassword").value.trim();
		if (password != repassword) {
			alert("两次密码不一致!");
			return;
		}
		$.ajax({
			type: "POST",
			url: baseUrl+"/add",
			dataType : "json",
			data : {
				username : username,
				passwd : password
			},
			success : function(data) {
				if (data.error != null) {
					alert(data.error_message);
				}else{
					window.location.href="<%=basePath%>
	/";
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="container" style="margin-top: 10%; height: 500px;">
		<div class="jumbotron">
			<h1><%=basePath.substring(1)%></h1>
			<fieldset style="height: 350px;">
				<legend>Welcome</legend>
				<form action="<%=basePath%>/add" class="bs-example bs-example-form"
					role="form" style="margin-left: 20%; width: 500px; height: 200px;">
					<div class="input-group h60" style="">
						<span class="input-group-addon">@</span> <input id="username"
							style="" style="" type="text" class="form-control h60"
							placeholder="username">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon">@</span> <input id="password"
							placeholder="password" style="" type="password"
							class="form-control h60">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon">@</span> <input id="repassword"
							placeholder="repeat password" style="" type="password"
							class="form-control h60">
					</div>
					<div class="input-group h60"
						style="margin-top: 10px; float: right;">
						<input id="b_signup" type="button" value="Sign Up"
							class="btn btn-primary" style="margin-left: 10px;"
							onclick="signUp()">
					</div>
					<br>
				</form>
			</fieldset>
		</div>
	</div>

</body>
</html>
