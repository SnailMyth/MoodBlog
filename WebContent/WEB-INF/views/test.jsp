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
</style>
</head>
<body>
	<div class="container">
		<div class="error ${param.error == true ? '' : 'hide'}">
			登陆失败<br>
			${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
		</div>
		<c:url value="/login" var="loginUrl" />
		<form method="post"
			action="${loginUrl}"
			style="width: 260px; text-align: center">
			<fieldset>
				<legend>登陆</legend>
				用户： <input type="text" name="j_username" style="width: 150px;"
					value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /><br />
				密码： <input type="password" name="j_password" style="width: 150px;" /><br />
				<input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆<br />
				<input type="submit" value="登陆" /> <input type="reset" value="重置" />
				
			</fieldset>
		</form>
	</div>

</body>
</html>