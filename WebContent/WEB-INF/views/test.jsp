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
</head>
<body>
	
	Test Page!!<br/>
	<label>${data}</label>
		<div class="container"
		style="margin-top: 10%; background-image: img/back.jpg">
		<div class="jumbotron">
			<h1><%=basePath.substring(1)%></h1>
			<fieldset style="">
				<legend>Welcome</legend>
				<form action="<%=basePath%>/test/addinfo"
					class="bs-example bs-example-form" role="form"
					style="margin-left: 20%; width: 500px; height: 200px;">
					<div class="input-group h60" style="">
						<span class="input-group-addon">@</span> <input name="nick"
							style="" type="text" class="form-control h60"
							placeholder="nick">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon" >@</span> <input name="age"
							type="text"
							class="form-control h60">
					</div>
					<div class="input-group h60" style="margin-top: 5px;">
						<span class="input-group-addon" >@</span> <input name="nick"
							style="" type="text"
							class="form-control h60">
					</div>
					<div class="input-group h60" style="margin-top: 10px;">
						<input type="submit" value="Update" class="btn btn-primary" style="margin-left: 190px;">
					</div>
					<br>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>