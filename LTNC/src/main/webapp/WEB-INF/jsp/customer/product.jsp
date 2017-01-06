<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- banner -->
	<div class="banner5" id="home1">
		<div class="container">
			<h2>Women Shirts & Tops<span>up to</span> Flat 30% <i>Discount</i></h2>
		</div>
	</div>
<!-- //banner -->
<!-- breadcrumbs -->
	<div class="breadcrumb_dress">
		<div class="container">
			<ul>
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a> <i>/</i></li>
				<li>Shirts & Tops</li>
			</ul>
		</div>
	</div>
<!-- //breadcrumbs -->

<!-- dresses -->
	<div class="dresses">
		<div class="container">
			<div class="w3ls_dresses_grids">
				<div class="col-md-4 w3ls_dresses_grid_left">
					<div class="w3ls_dresses_grid_left_grid">
						<h3>Danh Mục</h3>
						<div class="w3ls_dresses_grid_left_grid_sub">
							<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<c:forEach items="${listCategory}" var="item">
								<div class="panel panel-default">
									<div class="panel-heading" role="tab" id="headingOne">
									  <h4 class="panel-title asd">
										<a class="pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
										  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><i class="glyphicon glyphicon-minus" aria-hidden="true"></i>
										  ${item.parentCategory.categoryName}
										</a>
									  </h4>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
									  <div class="panel-body panel_text">
										<ul>
										<c:forEach items="${item.childCategory}" var="subitem">
											<li><a href="${pageContext.request.contextPath}/product/${subitem.categoryId}">${subitem.categoryName}</a></li>
										</c:forEach>
											
										</ul>
									  </div>
									</div>
								  </div>
							</c:forEach>

							</div>
						</div>
					</div>
					<div class="w3ls_dresses_grid_left_grid">
						<div class="dresses_img_hover">
							<img src="${pageContext.request.contextPath}/resources/customer_user/images/60.jpg" alt=" " class="img-responsive" />
							<div class="dresses_img_hover_pos">
								<h4>For Kids <span>40%</span><i>Discount</i></h4>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 w3ls_dresses_grid_right">
					<div class="col-md-6 w3ls_dresses_grid_right_left">
						<div class="w3ls_dresses_grid_right_grid1">
							<img src="${pageContext.request.contextPath}/resources/customer_user/images/64.jpg" alt=" " class="img-responsive" />
							<div class="w3ls_dresses_grid_right_grid1_pos1">
								<h3>Blue <span>Checks</span> Shirt</h3>
							</div>
						</div>
					</div>
					<div class="col-md-6 w3ls_dresses_grid_right_left">
						<div class="w3ls_dresses_grid_right_grid1">
							<img src="${pageContext.request.contextPath}/resources/customer_user/images/65.jpg" alt=" " class="img-responsive" />
							<div class="w3ls_dresses_grid_right_grid1_pos">
								<h3>White <span>Classy</span> Top</h3>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>

					<div class="w3ls_dresses_grid_right_grid2">
						<div class="w3ls_dresses_grid_right_grid2_left">
							<h3>Showing Results: 0-1</h3>
						</div>
						<div class="w3ls_dresses_grid_right_grid2_right">
							<select name="select_item" class="select_item">
								<option selected="selected">Default sorting</option>
								<option>Sort by popularity</option>
								<option>Sort by average rating</option>
								<option>Sort by newness</option>
								<option>Sort by price: low to high</option>
								<option>Sort by price: high to low</option>
							</select>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="w3ls_dresses_grid_right_grid3">
					<!-- Hình Ảnh Show -->
					<c:forEach items="${listProduct}" var="item">
						<div class="col-md-4 agileinfo_new_products_grid agileinfo_new_products_grid_dresses">
							<div class="agile_ecommerce_tab_left dresses_grid">
								<div class="hs-wrapper hs-wrapper2">
									<img src="${pageContext.request.contextPath}/resources/customer_user/images/${item.productImage}" alt=" " class="img-responsive" />
									<div class="w3_hs_bottom w3_hs_bottom_sub1">
										<ul>
											<li>
												<a href="#" data-toggle="modal" data-target="#myModal6" ><span class="glyphicon glyphicon-eye-open" data-id="${item.productId}" data-img="${item.productImage}" aria-hidden="true"></span></a>
											</li>
										</ul>
									</div>
								</div>
								<h5><a href="single.html">${item.productName}</a></h5>
								<div class="simpleCart_shelfItem">
									<p><span>$420</span> <i class="item_price">$340</i></p>
								</div>
							</div>
						</div>
					</c:forEach>
						<div class="clearfix"> </div>
					<!-- //Hình ảnh show -->
					</div>

					<div class="modal video-modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModal6">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
								</div>
								<section>
									<div class="modal-body">
										<div class="col-md-5 modal_body_left">
										</div>
										<div class="col-md-7 modal_body_right">
											<h4>a good look women's Long Skirt</h4>
											
											<div class="rating">
												<div class="rating-left">
													<img src="${pageContext.request.contextPath}/resources/customer_user/images/star-.png" alt=" " class="img-responsive" />
												</div>
												<div class="rating-left">
													<img src="${pageContext.request.contextPath}/resources/customer_user/images/star-.png" alt=" " class="img-responsive" />
												</div>
												<div class="rating-left">
													<img src="${pageContext.request.contextPath}/resources/customer_user/images/star-.png" alt=" " class="img-responsive" />
												</div>
												<div class="rating-left">
													<img src="${pageContext.request.contextPath}/resources/customer_user/images/star.png" alt=" " class="img-responsive" />
												</div>
												<div class="rating-left">
													<img src="${pageContext.request.contextPath}/resources/customer_user/images/star.png" alt=" " class="img-responsive" />
												</div>
												<div class="clearfix"> </div>
											</div>
											<h5>Kích Thước</h5>
											<div class="kichthuoc">
												<ul>
												</ul>
											</div>
											<h5>Color</h5>
											<div class="color-quality">
												<ul>
												</ul>
											</div>
											<div class="modal_body_right_cart simpleCart_shelfItem">
												<p><span>$320</span> <i class="item_price">$250</i></p>
												<p><a class="item_add" href="#">Thêm vào giỏ hàng</a></p>
											</div>
										</div>
										<div class="clearfix"> </div>
									</div>
								</section>
							</div>
						</div>
					</div>
					<script>
					$('.glyphicon-eye-open').click(function(){
						debugger
						var id=$(this).data('id');
						var img=$(this).data('img');
						$('.modal_body_left').html('<img src="${pageContext.request.contextPath}/resources/customer_user/images/'+img+'" alt=" " class="img-responsive" />')
						$('.item_add').attr('data-id',id);
						$('.kichthuoc ul').html('');
						$('.color-quality ul').html('');
						$.ajax({
							url:"/LTNC/cart/getlistcolor",
							type:'POST',
							dataType:'json',
							data:{
								id:id
							},
							success:function(list)
							{
								for(var i=0;i<list.length;i++)
								{
									if($('.color-quality ul').find('.'+list[i].productColorCss).length==0)
									$('.color-quality ul').append('<li><a href="#" class="'+list[i].productColorCss+'"><input name="mausac" type="radio" value="'+list[i].productColorId+'"/>'+list[i].productColorName+'</a></li>')
								}
							}
						})
						
						$.ajax({
							url:"/LTNC/cart/getlistsize",
							type:'POST',
							dataType:'json',
							data:{
								id:id
							},
							success:function(list)
							{
								for(var i=0;i<list.length;i++)
								{
									if($('.kichthuoc ul').find('.kichthuoc'+list[i].productSizeId).length==0)
									$('.kichthuoc ul').append('<li><a href="#" class="kichthuoc'+list[i].productSizeId+'"><span>'+list[i].productSizeName+'</span><input name="kichthuoc" type="radio" value="'+list[i].productSizeId+'" style="margin-left:5px;"/></a></li>')
								}
								
							}
						})
					});
					$('.item_add').click(function(){
						undefined
						var kichthuoc= parseInt($('input[name=kichthuoc]:checked', '.kichthuoc').val());
						var mausac=parseInt($('input[name=mausac]:checked', '.color-quality').val());
						var id=$(this).data('id');
						if(typeof kichthuoc=='NaN'||typeof mausac=='NaN')
						{
							if($('.simpleCart_shelfItem').find('.error-mgs').length==0)
							$('.simpleCart_shelfItem').append('<div class="error-mgs" style="color:red">Vui lòng chọn đầy đủ kích thước và màu sắc !</div>')
						}
						else
							{
							debugger
								$.ajax({
									url:"/LTNC/cart/insert",
									type:'POST',
									dataType:'json',
									data:{
										productId:id,
										sizeId:kichthuoc,
										colorId:mausac,
										soLuong:1
									},
									success:function(response)
									{
										debugger
										if(response.status==1)
											{
											debugger
												$('#tongtien_head').html(response.total+' ('+response.count+' Sản Phẩm)')
												if($('.simpleCart_shelfItem').find('.error-mgs').length>0)
													$('.error-mgs').remove();
												$('#myModal6').modal('hide');
											}
										else
											{
											if($('.simpleCart_shelfItem').find('.error-mgs').length==0)
												$('.simpleCart_shelfItem').append('<div class="error-mgs" style="color:red">Kích thước hoặc Màu sắc này đã hết, vui lòng chọn lại !</div>');
											else
												$('.error-mgs').html('Kích thước hoặc Màu sắc này đã hết, vui lòng chọn lại !')
											}
									}
								})
							}
					});
					</script>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>