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
<style type="text/css">
.content_word {
	padding-right: 15px;
}

.title {
	margin-top: 50px;
}
button{
margin-left: 10px;
margin-top: 10px;
margin-bottom: 10px;
}
</style>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">

function show(){
	var data = CKEDITOR.instances.editor.getData();
	console.log(data);
}
function test(){
	$.ajax({
		   type: "GET",
		   url: baseUrl+"/test",
		   success: function(msg){
		     alert( "Data Saved: " + msg );
		   }
	});
}
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
			style="margin-left: 0px; margin-right: 0px; background: #fff; padding: 0px; color: #333;">
			<div class="container"
				style="padding-left: 0px; padding-right: 0px; margin: 10px;">
				<div class="row"
					style="display: inherit; margin-left: 0px; margin-right: 0px">
					<button class="btn btn-info" onclick="test()">submit</button>
					<font size="5px" color="black"><b style="margin-left: 30px;">Editor
							your mind</b></font>
					<form>
						<textarea name="editor" id="editor" rows="10" cols="80">
                		This is my textarea to be replaced with CKEditor.
            			</textarea>
					</form>
					<button class="btn btn-info" onclick="show()">submit</button>
				</div>
			</div>
		</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
<script type="text/javascript">
	CKEDITOR.replace( 'editor',{
	    uiColor: '#9AB8F3'
	});
</script>


</body>
</html>
