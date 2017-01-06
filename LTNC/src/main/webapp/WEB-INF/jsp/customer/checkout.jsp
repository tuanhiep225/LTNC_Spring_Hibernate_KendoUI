<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mta.th12a.tuanhiep.model.Products" %>
<%@page import="mta.th12a.tuanhiep.dto.Cart" %>
<div class="banner10" id="home1">
		<div class="container">
		</div>
	</div>
<%
	Cart cart=new Cart();
	if(session.getAttribute("cart")!=null)
	{
		cart=(Cart)session.getAttribute("cart");
	}
%>
<div class="checkout">
		<div class="container">
			<h3>Giỏ hàng của bạn có: <span>${sessionScope.cart.countItem()} Sản Phẩm</span></h3>

			<div class="checkout-right">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>Thứ Tự</th>	
							<th>Sản Phẩm</th>
							<th>Số Lượng</th>
							<th>Tên Sản Phẩm</th>
							<th>Màu Sắc</th>
							<th>Kích Thước</th>
							<th>Giá</th>
							<th>Xóa</th>
						</tr>
					</thead>
					<%if(cart!=null){ %>
					<c:forEach items="<%=cart.getCartItem().entrySet()%>" var="item" varStatus="loop">
					<tr class="rem${loop.index+1}">
						<td class="invert">${loop.index+1}</td>
						<td class="invert-image"><a href="single.html"><img src="${pageContext.request.contextPath}/resources/customer_user/images/${item.value.product.productImage}" alt=" " class="img-responsive" /></a></td>
						<td class="invert">
							 <div class="quantity"> 
								<div class="quantity-select" data-id="${item.value.product.productStoreId}">                           
									<div class="entry value-minus">&nbsp;</div>
									<div class="entry value"><span>${item.value.quantity}</span></div>
									<div class="entry value-plus active">&nbsp;</div>
								</div>
							</div>
						</td>
						<td class="invert">${item.value.product.productName}</td>
						<td class="invert">${item.value.product.productColorName}</td>
						<td class="invert">${item.value.product.productSizeName}</td>
						<td class="invert">${item.value.product.price}</td>
						<td class="invert">
							<div class="rem">
								<div class="close${loop.index+1}" data-id="${item.value.product.productStoreId}"> </div>
							</div>
							<script>$(document).ready(function(c) {
								$('.close${loop.index+1}').on('click', function(c){
									var id=$(this).data('id');
									debugger
									$.ajax({
										url:'/LTNC/cart/delete',
										type:'POST',
										dataType:'',
										data:{
											productStoreId:id,
										},
										success:function(e){
											if(e.status==1)
											{
												$('.rem${loop.index+1}').fadeOut('slow', function(c){
													$('.rem${loop.index+1}').remove();
												});
												$('#tinhtongtien').html('<div>Tổng tiền: '+e.total+'</div>')
												$('#tongtien_head').html(e.total+' ('+e.count+' Sản Phẩm)')
											}
										}
									})
									});	  
								});
						   </script>
						</td>
					</tr>
					</c:forEach>
					<%} %>
								<!--quantity-->
									<script>
									$('.value-plus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
										divUpd.text(newVal);
										var id=$(this).parent().data('id');
										$.ajax({
											url:'/LTNC/cart/update',
											type:'POST',
											dataType:'',
											data:{
												productStoreId:id,
												soLuong:newVal
											},
											success:function(e){
												if(e.status==1)
													{
														$('#tinhtongtien').html('<div>Tổng tiền: '+e.total+'</div>')
														$('#tongtien_head').html(e.total+' ('+e.count+' Sản Phẩm)')
													}
											}
										});
									});

									$('.value-minus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
										if(newVal>=1) divUpd.text(newVal);
										var id=$(this).parent().data('id');
										$.ajax({
											url:'/LTNC/cart/update',
											type:'POST',
											dataType:'',
											data:{
												productStoreId:id,
												soLuong:newVal
											},
											success:function(e){
												if(e.status==1)
												{
													$('#tinhtongtien').html('<div>Tổng tiền: '+e.total+'</div>')
													$('#tongtien_head').html(e.total+' ('+e.count+' Sản Phẩm)')
												}
											}
										});
									});
									</script>
								<!--quantity-->
				</table>
			</div>
			<div class="checkout-left">	
				<div class="checkout-left-basket" id="tinhtongtien">
					<div>Tổng tiền : <%=cart.total() %> VNĐ</div>
				</div>
				<div class="checkout-right-basket">
					<a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Tiếp Tục Mua Hàng</a>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>