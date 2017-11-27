
<%
	String basePath = request.getContextPath();
%>
<script type="text/javascript" src="js/scrollReveal.js"></script>
<div class="mask-l"
	style="background-color: #fff; width: 100%; height: 100%; position: fixed; top: 0; left: 0; z-index: 9999999;"></div>
<header>
	<div class="container b-header__box b-relative" style="float: left;">
		<div class="b-header-r b-right b-header-r--icon" style="float: left;">
			<nav class="b-top-nav f-top-nav b-right j-top-nav">
				<ul class="b-top-nav__1level_wrap">
					<li
						class="b-top-nav__1level f-top-nav__1level is-active-top-nav__1level f-primary-b"><a
						href="<%=basePath%>/index"><i class="fa fa-home b-menu-1level-ico"></i>Home <span
							class="b-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span></a>
					</li>
					<li class="b-top-nav__1level f-top-nav__1level f-primary-b"><a
						href="#"><i class="fa fa-music b-menu-1level-ico"></i>Music <span
							class="b-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span></a></li>
					<li class="b-top-nav__1level f-top-nav__1level f-primary-b"><a
						href="<%=basePath%>/blog"><i
							class="fa fa-code b-menu-1level-ico"></i>Blog <span
							class="b-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span></a>
					</li>
					<li
						class="b-top-nav__1level f-top-nav__1level f-primary-b b-top-nav-big">
						<a href="<%=basePath%>/write"><i class="fa fa-gamepad b-menu-1level-ico"></i>Dota<span
							class="b-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span></a>
					</li>
					<li class="b-top-nav__1level f-top-nav__1level f-primary-b"><a
						href="<%=basePath%>/me"><i class="fa fa-info b-menu-1level-ico"></i>Contact
							me<span class="b-ico-dropdown"><i
								class="fa fa-arrow-circle-down"></i></span></a></li>
				</ul>
			</nav>
		</div>
	</div>
	<div style="float: right; margin-top: 30px; margin-right: 20px;">
		<label>${sessionScope.user.getUsername()}</label><br /> <a
			href="<%=basePath%>/loginout">login out</a>
	</div>
	<div style="float: right; margin-top: 30px; margin-right: 5px;">
		<i class="fa fa-odnoklassniki b-menu-1level-ico"></i>
	</div>
</header>

