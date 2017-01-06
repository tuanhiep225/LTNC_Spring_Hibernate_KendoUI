<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container" style="width: 70%; margin-left: 15%">
	<h1 class="typoh2">Đặt hàng trực tuyến</h1>
	<div class="register" style="margin-left: 3%; margin-top: 25px">
		<form action="/LTNC/authen_order" method="post">
			<input type="text" hidden="true" name="customerId" value="${sessionScope.customer.customerId}">
			<input placeholder="Họ tên" name="name" type="text" required="" value="${sessionScope.customer.name}"/>
			<input placeholder="Email" name="email" type="email" required="" value="${sessionScope.customer.email}"/>
			<input placeholder="Điện thoại" name="sdt" type="text" required="" value="${sessionScope.customer.phone}" style="margin-top: 15px;"/>
			<input placeholder="Địa chỉ" name="diaChi" type="text" required="" value="${sessionScope.customer.address}" style="margin-top: 15px;"/>
			<div class="sign-up">
				<input style="width: 15%; background-color: #a7292f; height: 40px"
					type="submit" value="Đặt hàng" /> 
				<input style="width: 15%; background-color: #969090; height: 40px" type="button" value="Hủy" id="huydathang"/>
			</div>
		</form>
	</div>
	<script>
	$('#huydathang').click(function(){
		window.location.href = "http://localhost:8080/LTNC/home"
	})
	
	</script>
</div>