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
<script type="text/javascript">
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
		<div class="l-main-container">
			<div class="l-inner-page-container" style="padding-top: 10px;">
				<div class="container"
					style="margin-top: 0px; margin-left: 20px; margin-right: 20px; padding-top: 10px;">
					<div class="row">
						<div class="col-md-9 col-md-push-3">
							<div class="b-blog-listing__block">
								<div class="b-blog-listing__block-top">
									<div class=" view view-sixth">
										<img data-retina="" src="img/blog/blog_listing.jpg" alt="">

									</div>
								</div>
								<div class="b-infoblock-with-icon b-blog-listing__infoblock">
									<a href="#"
										class="b-infoblock-with-icon__icon f-infoblock-with-icon__icon fade-in-animate hidden-xs">
										<i class="fa fa-pencil"></i>
									</a>
									<div
										class="b-infoblock-with-icon__info f-infoblock-with-icon__info">
										<a href="#"
											class="f-infoblock-with-icon__info_title b-infoblock-with-icon__info_title f-primary-l b-title-b-hr f-title-b-hr">
											Mauris ac risus neque, ut pulvinar risus </a>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text f-primary-b b-blog-listing__pretitle">
											By <a href="#" class="f-more">Stephen Brock</a> In <a
												href="#" class="f-more">Lifestyle</a>, <a href="#"
												class="f-more">Photography</a> Posted May 24th, 2017 <a
												href="#"
												class="f-more b-blog-listing__additional-text f-primary"><i
												class="fa fa-comment"></i>12 Comments</a>
										</div>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text c-primary b-blog-listing__text">
											Pendisse blandit ligula turpis, ac convallis risus fermentum
											non. Duis vestibulum quis quam vel accumsan. Nunc a vulputate
											lectus. Vestibulum eleifend nisl sed massa sagittis
											vestibulum. Vestibulum pretium blandit tellus, sodales
											volutpat sapien varius vel. Phasellus tristique cursus erat,
											a placerat tellus laoreet eget. Blandit ligula turpis, ac
											convallis risus fermentum non. Duis vestibulum quis.</div>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text">
											<a href="#" class="f-more f-primary-b">Read more</a>
										</div>
									</div>
								</div>
							</div>
							<div class="b-blog-listing__block">
								<div class="b-video-player b-blog-listing__block-top">
									<iframe src="" width="870" height="460" frameborder="0"
										webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
								</div>
								<div class="b-infoblock-with-icon b-blog-listing__infoblock">
									<a href="#"
										class="b-infoblock-with-icon__icon f-infoblock-with-icon__icon fade-in-animate hidden-xs">
										<i class="fa fa-video-camera"></i>
									</a>
									<div
										class="b-infoblock-with-icon__info f-infoblock-with-icon__info">
										<a href="#"
											class="f-infoblock-with-icon__info_title b-infoblock-with-icon__info_title f-primary-l b-title-b-hr f-title-b-hr">
											This Is Vimeo video post </a>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text f-primary-b b-blog-listing__pretitle">
											By <a href="#" class="f-more">Stephen Brock</a> In <a
												href="#" class="f-more">Lifestyle</a>, <a href="#"
												class="f-more">Photography</a> Posted May 24th, 2017 <a
												href="#"
												class="f-more b-blog-listing__additional-text f-primary"><i
												class="fa fa-comment"></i>12 Comments</a>
										</div>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text c-primary b-blog-listing__text">
											Pendisse blandit ligula turpis, ac convallis risus fermentum
											non. Duis vestibulum quis quam vel accumsan. Nunc a vulputate
											lectus. Vestibulum eleifend nisl sed massa sagittis
											vestibulum. Vestibulum pretium blandit tellus, sodales
											volutpat sapien varius vel. Phasellus tristique cursus erat,
											a placerat tellus laoreet eget. Blandit ligula turpis, ac
											convallis risus fermentum non. Duis vestibulum quis.</div>
										<div
											class="f-infoblock-with-icon__info_text b-infoblock-with-icon__info_text">
											<a href="#" class="f-more f-primary-b">Read more</a>
										</div>
									</div>
								</div>
							</div>

							<div class="b-pagination f-pagination">
								<ul>
									<li><a href="#">First</a></li>
									<li><a class="prev" href="#"><i
											class="fa fa-angle-left"></i></a></li>
									<li class="is-active-pagination"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a class="next" href="#"><i
											class="fa fa-angle-right"></i></a></li>
									<li><a href="#">Last</a></li>
								</ul>
							</div>
						</div>
						<div class="visible-xs-block visible-sm-block b-hr"></div>
						<div class="col-md-3 col-md-pull-9">
							<div class="row">
								<div class="col-md-12">
									<div class="b-form-row b-input-search">
										<input class="form-control" type="text"
											placeholder="Enter your keywords" /> <span
											class="b-btn b-btn-search f-btn-search fa fa-search fa-2x"></span>
									</div>
								</div>
							</div>
							<div class="row b-col-default-indent">
								<div class="col-md-12">
									<div class="b-categories-filter">
										<h4
											class="f-primary-b b-h4-special f-h4-special--gray f-h4-special">blog
											categories</h4>
										<ul>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Web Design</a> <span
												class="b-categories-filter_count f-categories-filter_count">12</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Smart Phone</a> <span
												class="b-categories-filter_count f-categories-filter_count">23</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Latop</a> <span
												class="b-categories-filter_count f-categories-filter_count">12</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Apple Store</a> <span
												class="b-categories-filter_count f-categories-filter_count">23</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Wordpress Theme</a> <span
												class="b-categories-filter_count f-categories-filter_count">12</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Web Design</a> <span
												class="b-categories-filter_count f-categories-filter_count">23</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Sport</a> <span
												class="b-categories-filter_count f-categories-filter_count">12</span>
											</li>
											<li><a class="f-categories-filter_name" href="#"><i
													class="fa fa-plus"></i> Fashion</a> <span
												class="b-categories-filter_count f-categories-filter_count">23</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-md-12">
									<h4
										class="f-primary-b b-h4-special  f-h4-special--gray f-h4-special">popular
										postes</h4>

									<div
										class="b-blog-short-post b-blog-short-post--img-hover-bordered b-blog-short-post--w-img f-blog-short-post--w-img row">
										<div
											class="b-blog-short-post b-blog-short-post--img-hover-bordered b-blog-short-post--w-img f-blog-short-post--w-img row">
											<div
												class="b-blog-short-post--popular col-md-12  col-xs-12 f-primary-b">
												<div class="b-blog-short-post__item_img">
													<a href="#"><img data-retina
														src="img/gallery/sm/gallery_1.jpg" alt="" /></a>
												</div>
												<div class="b-remaining">
													<div
														class="b-blog-short-post__item_text f-blog-short-post__item_text">
														<a href="#">Phasellus id mattis dolorunc et erat
															hendrerit, tincidunt</a>
													</div>
													<div
														class="b-blog-short-post__item_date f-blog-short-post__item_date f-primary-it">
														10, January, 2014</div>
												</div>
											</div>
											<div
												class="b-blog-short-post--popular col-md-12  col-xs-12 f-primary-b">
												<div class="b-blog-short-post__item_img">
													<a href="#"><img data-retina
														src="img/gallery/sm/gallery_2.jpg" alt="" /></a>
												</div>
												<div class="b-remaining">
													<div
														class="b-blog-short-post__item_text f-blog-short-post__item_text">
														<a href="#">Vel eleifend id ullamcorper eu velit</a>
													</div>
													<div
														class="b-blog-short-post__item_date f-blog-short-post__item_date f-primary-it">
														14, January, 2014</div>
												</div>
											</div>
											<div
												class="b-blog-short-post--popular col-md-12  col-xs-12 f-primary-b">
												<div class="b-blog-short-post__item_img">
													<a href="#"><img data-retina
														src="img/gallery/sm/gallery_2.jpg" alt="" /></a>
												</div>
												<div class="b-remaining">
													<div
														class="b-blog-short-post__item_text f-blog-short-post__item_text">
														<a href="#">Lorem ipsum dolor sit amet purus vitae
															magna rhoncus</a>
													</div>
													<div
														class="b-blog-short-post__item_date f-blog-short-post__item_date f-primary-it">
														10, January, 2014</div>
												</div>
											</div>
											<div
												class="b-blog-short-post--popular col-md-12  col-xs-12 f-primary-b">
												<div class="b-blog-short-post__item_img">
													<a href="#"><img data-retina
														src="img/gallery/sm/gallery_3.jpg" alt="" /></a>
												</div>
												<div class="b-remaining">
													<div
														class="b-blog-short-post__item_text f-blog-short-post__item_text">
														<a href="#">Fusce vitae dui sit amet lacus rutrum
															convallis</a>
													</div>
													<div
														class="b-blog-short-post__item_date f-blog-short-post__item_date f-primary-it">
														10, January, 2014</div>
												</div>
											</div>
											<div
												class="b-blog-short-post--popular col-md-12  col-xs-12 f-primary-b @@hidden">
												<div class="b-blog-short-post__item_img">
													<a href="#"><img data-retina
														src="img/gallery/sm/gallery_1.jpg" alt="" /></a>
												</div>
												<div class="b-remaining">
													<div
														class="b-blog-short-post__item_text f-blog-short-post__item_text">
														<a href="#">Fusce vitae dui sit amet lacus rutrum
															convallis</a>
													</div>
													<div
														class="b-blog-short-post__item_date f-blog-short-post__item_date f-primary-it">
														10, January, 2014</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<h4
										class="f-primary-b b-h4-special f-h4-special--gray f-h4-special">tags
										cloud</h4>
									<div>
										<a class="f-tag b-tag" href="#">Dress</a> <a
											class="f-tag b-tag" href="#">Mini</a> <a class="f-tag b-tag"
											href="#">Skate animal</a> <a class="f-tag b-tag" href="#">Lorem
											ipsum</a> <a class="f-tag b-tag" href="#">literature</a> <a
											class="f-tag b-tag" href="#">Baroque</a> <a
											class="f-tag b-tag" href="#">Dress</a> <a class="f-tag b-tag"
											href="#">Mini</a> <a class="f-tag b-tag" href="#">Skate
											animal</a> <a class="f-tag b-tag" href="#">Lorem ipsum</a> <a
											class="f-tag b-tag" href="#">literature</a> <a
											class="f-tag b-tag" href="#">Baroque</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
