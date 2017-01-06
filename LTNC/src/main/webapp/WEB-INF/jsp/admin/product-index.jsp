<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
              <div id="grid-product"></div>
              <div id="nhaphang"></div>
              </div>
</div>
<script type="text/x-kendo-template" id="template">
<div class="k-edit-form-container">
<div class="row">
		<div class="k-edit-label col-sm-3">
    		<label for="productCorlor" style="">Màu Sắc</label>
		</div>
		<div class="col-sm-7">
    		<input id="productCorlor" style="width: 100%;" />
		</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productSize" style="">Size</label>
	</div>
	<div class="col-sm-7">
    	<input  id="productSize" style="width:  100%;" />
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productQuantity" style="">Số Lượng</label>
	</div>
	<div class="col-sm-7">
    	<input id="productQuantity" style="width:  100%;" />
<div class="k-widget k-tooltip k-tooltip-validation k-invalid-msg" style="margin: 0.5em; display: none;" data-for="productQuantity" role="alert"><span class="k-icon k-i-warning"> </span>Số lượng không được để trống<div class="k-callout k-callout-n"></div></div>
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productGiaNhap" style="">Giá Nhập</label>
	</div>
	<div class="col-sm-7">
    	<input " id="productGiaNhap" style="width:  100%;" />
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productGiaBan" style="">Giá Bán</label>
	</div>
	<div class="col-sm-7">
    	<input id="productGiaBan" style="width:  100%;" />
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productSale" style="">Sale</label>
	</div>
	<div class="col-sm-7">
    	<input id="productSale" style="width:  100%;" />
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productNgayNhap" style="">Ngày Nhập</label>
	</div>
	<div class="col-sm-7">
    	<input id="productNgayNhap" style="width:  100%;" />
	</div>
</div>
<div class="row" style="margin-top:15px;">
	<div class="k-edit-label col-sm-3">
    	<label for="productGhiChu" style="">Ghi Chú</label>
	</div>
	<div class="col-sm-7">
    	<input class="k-input k-textbox" id="productGhiChu" style="width:  100%;" />
	</div>
</div>
<div class="k-edit-buttons k-state-default row" style="margin-top:25px;">
	<div style="float:right;padding-right:40px;">
    	<a class="k-button k-button-icontext" id="updateDatHang">
        	<span class="k-icon k-i-update"></span>
        	Đặt Hàng
    	</a>
	</div>
	<div style="float:right;margin-right:10px">
    	<a class="k-button k-button-icontext" id="cancelDatHang">
        	<span class="k-icon k-i-cancel"></span>
        	Hủy
    	</a>
	</div>
</div>
</div>
</script>
<style type="text/css">
    .customer-photo {
        display: inline-block;
        width: 90px;
        height: 90px;
        background-size: 90px 90px;
        background-position: center center;
        vertical-align: middle;
        line-height: 90px;
        box-shadow: inset 0 0 1px #999, inset 0 0 10px rgba(0,0,0,.2);
        margin-left: 5px;
    }
    .btn-grid-nhaphang {
    width: 75px;
    height: 26px;
    margin-top: 1px !important;
    padding-top: 0px !important;
    }
    .k-button {
    text-transform:none !important;
    border-radius:10px;
    padding: 5px 5px;
    border-width: 0px;
    min-width: 45px !important;
    }
    .k-edit-form-container {
       width: 471px !important;
    } 
   .k-edit-label {
   margin-left: 0%;
}
   .col-sm-3 {
    width: 25% !important;
}
</style>
<script src="${pageContext.request.contextPath}/resources/tuychinh/product.js"></script>