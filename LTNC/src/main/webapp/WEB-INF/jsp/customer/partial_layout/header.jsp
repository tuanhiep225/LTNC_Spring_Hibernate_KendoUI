<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="mta.th12a.tuanhiep.model.Customers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						Don't Wait, Login now!</h4>
				</div>
				<div class="modal-body modal-body-sub">
					<div class="row">
						<div class="col-md-8 modal_body_left modal_body_left1" style="border-right: 1px dotted #C2C2C2;padding-right:3em;">
							<div class="sap_tabs">	
								<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
									<ul>
										<li class="resp-tab-item" aria-controls="tab_item-0"><span>Sign in</span></li>
										<li class="resp-tab-item" aria-controls="tab_item-1"><span>Sign up</span></li>
									</ul>		
									<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
										<div class="facts">
											<div class="register">
												<div>		
													<input id="UserName" name="Email" placeholder="UserName" type="text" required="">						
													<input id="PassWord" name="Password" placeholder="Password" type="password" required="">										
													<div class="sign-up">
														<input id="dangnhap" type="submit" value="Sign in"/>
													</div>
												</div>
											</div>
										</div> 
										<script>
											$('#dangnhap').click(function(){
												$.ajax({
													url:'/LTNC/customer/authen',
													dataType :'json',
													data:{
														userName:$('#UserName').val(),
														passWord:$('#PassWord').val()
													},
													type:'POST',
													success:function(e)
													{
														if(e!=null)
															{
															var a= $('.tab-1').find('.thongbao').length;
															if(a>0)
																{
																	$('.thongbao').remove();
																}
															$('.nameCustomer').html(e.customer.name);
															$('#myModal88').modal('hide');
															location.reload();
															}
														
														else
															{
																var a= $('.tab-1').find('.thongbao').length;
																if(a>0)
																	{
																		$('.thongbao').remove();
																	}
																
																$('.tab-1').append('<div class="thongbao" style="color:red; margin-top:10px;">Tên đăng nhập hoặc mật khẩu không đúng</div>')
															}
													}
												})
											})
										</script>
									</div>	

									<div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
										<div class="facts">
											<div class="register">
												<form action="#" method="post">			
													<input placeholder="Name" name="Name" type="text" required="">
													<input placeholder="Email Address" name="Email" type="email" required="">	
													<input placeholder="Password" name="Password" type="password" required="">	
													<input placeholder="Confirm Password" name="Password" type="password" required="">
													<div class="sign-up">
														<input id="signup" type="submit" value="Create Account"/>
													</div>
												</from>
											</div>
										</div>
									</div> 			        					            	      
								</div>	
							</div>
							<script src="${pageContext.request.contextPath}/resources/customer_user/js/easyResponsiveTabs.js" type="text/javascript"></script>
							<script type="text/javascript">
								$(document).ready(function () {
									$('#horizontalTab').easyResponsiveTabs({
										type: 'default', //Types: default, vertical, accordion           
										width: 'auto', //auto or any width like 600px
										fit: true   // 100% fit in a container
									});
								});
							</script>
							<div id="OR" class="hidden-xs">
								OR</div>
						</div>
						<div class="col-md-4 modal_body_right modal_body_right1">
							<div class="row text-center sign-with">
								<div class="col-md-12">
									<h3 class="other-nw">
										Sign in with</h3>
								</div>
								<div class="col-md-12">
									<ul class="social">
										<li class="social_facebook"><a href="#" class="entypo-facebook"></a></li>
										<li class="social_dribbble"><a href="#" class="entypo-dribbble"></a></li>
										<li class="social_twitter"><a href="#" class="entypo-twitter"></a></li>
										<li class="social_behance"><a href="#" class="entypo-behance"></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="header">
		<div class="container">
			<div class="w3l_login">
				<a href="#" data-toggle="modal" data-target="#myModal88"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
				<div class="nameCustomer" style="margin-top:10px;color:orange;">${sessionScope.customer.name}</div>
			</div>
			<div class="w3l_logo">
				<h1><a href="index.html">Women's Fashion<span>For Fashion Lovers</span></a></h1>
			</div>
			<div class="search">
				<input class="search_box" type="checkbox" id="search_box">
				<label class="icon-search" for="search_box"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></label>
				<div class="search_form">
					<form action="#" method="post">
						<input type="text" name="Search" placeholder="Search...">
						<input type="submit" value="Send">
					</form>
				</div>
			</div>
			<div class="cart box_1">
				<a href="${pageContext.request.contextPath}/cart/checkout">
					<div class="total" id="tongtien_head">
						${sessionScope.cart.total()} (${sessionScope.cart.countItem()} Sản Phẩm)</div>
					<img src="${pageContext.request.contextPath}/resources/customer_user/images/bag.png" alt="" />
				</a>
				<p><a href="javascript:;" class="simpleCart_empty">Giỏ Hàng</a></p>
				<div class="clearfix"> </div>
			</div>	
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="navigation">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header nav_2">
					<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div> 
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/home" class="act">Home</a></li>	
						<!-- Mega Menu -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Sản Phẩm<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-3">
								<div class="row">
								<c:forEach items="${listCategory}" var="item">
									<div class="col-sm-3">
										<ul class="multi-column-dropdown">
											<h6>${item.parentCategory.categoryName }</h6>
											<c:forEach items="${item.childCategory }" var="subItem">
											<li><a href="${pageContext.request.contextPath}/product/${subItem.categoryId}">${subItem.categoryName}</a></li>
											</c:forEach>
										</ul>
									</div>
								</c:forEach>
 									<div class="col-sm-2">
									</div>
									<div class="col-sm-4">
										<div class="w3ls_products_pos">
											<h4>50%<i>Off/-</i></h4>
											<img src="${pageContext.request.contextPath}/resources/customer_user/images/1.jpg" alt=" " class="img-responsive" />
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</ul>
						</li>
						<li><a href="about.html">Về Chúng Tôi</a></li>
						<li><a href="mail.html">Email</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>