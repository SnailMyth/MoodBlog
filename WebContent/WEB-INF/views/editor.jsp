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
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<!-- <link rel="stylesheet" type="text/css" href="css/demo.css" /> -->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/mdialog.css">
<script src="js/classie.js"></script>
<style type="text/css">
.content_word {
	padding-right: 15px;
}

.title {
	margin-top: 50px;
}

button {
	margin-left: 10px;
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/zepto.min.js"></script>
<script type="text/javascript" src="js/mdialog.js"></script>
<script type="text/javascript">
	function push() {
		var title = $('input[name=title]').val().trim();
		var tag = $('input[name=tag]').val().trim();
		var id = $('input[name=id]').val().trim();
		var data = CKEDITOR.instances.editor.getData();
		$.ajax({
			type : "POST",
			url : baseUrl+"/add",
			data : {
				id:id,
				title:title,
				tag:tag,
				id:id,
				content:data
			},
			dataType:"json",
			success : function(msg) {
				console.log(msg);
				if (msg.data == true) {
					new TipBox({type:'success',str:'操作成功',hasBtn:true});
					location.reload();
				}else{
					new TipBox({type:'error',str:'对不起,出错了!',hasBtn:true});
				}
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
					<form>
						<input type="text" name="id" value="${sessionScope.user.id}"
							style="display: none;">
						<section style="height:130px;background:#f9f7f6;max-"> <label
							style="margin-left: 10px; margin-top: 20px; font-size: 15px; color: black;">标题</label>
						<span class="input input--minoru" style="max-width: 820px;">
							<input class="input__field input__field--minoru" type="text"
							id="input-1" width="800px" name="title" />
						</span> <label
							style="margin-left: 10px; margin-top: 20px; font-size: 15px; color: black;">标签</label>
						<span class="input input--minoru" style="max-width: 820px;">
							<input class="input__field input__field--minoru" type="text"
							id="input-2" width="800px" name="tag" />
						</span> </section>
						<textarea name="editor" id="editor" rows="10" cols="80">
                		This is my textarea to be replaced with CKEditor.
            			</textarea>
					</form>
					<div style="float: right;">
						<button style="margin-right: 10px; margin-bottom: 5px;"
							class="btn btn-info" onclick="push()">submit</button>
					</div>
				</div>
			</div>
		</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
	<script>
		(function() {
			// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
			if (!String.prototype.trim) {
				(function() {
					// Make sure we trim BOM and NBSP
					var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
					String.prototype.trim = function() {
						return this.replace(rtrim, '');
					};
				})();
			}

			[].slice.call(document.querySelectorAll('input.input__field'))
					.forEach(function(inputEl) {
						// in case the input is already filled..
						if (inputEl.value.trim() !== '') {
							classie.add(inputEl.parentNode, 'input--filled');
						}

						// events:
						inputEl.addEventListener('focus', onInputFocus);
						inputEl.addEventListener('blur', onInputBlur);
					});

			function onInputFocus(ev) {
				classie.add(ev.target.parentNode, 'input--filled');
			}

			function onInputBlur(ev) {
				if (ev.target.value.trim() === '') {
					classie.remove(ev.target.parentNode, 'input--filled');
				}
			}
		})();
	</script>
	<script type="text/javascript">
		CKEDITOR.replace('editor', {
			uiColor : '#9AB8F3'
		});
	</script>


</body>
</html>
