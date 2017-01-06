<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Nhóm 3</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="${pageContext.request.contextPath}/resources/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
              <span>Xin chào</span>
                <h2>Tuấn Hiệp</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="${pageContext.request.contextPath}/admin/category/index"><i class="fa fa-home"></i> Danh Mục</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/brand/index"><i class="fa fa-home"></i> Thương Hiệu</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/product-color/index"><i class="fa fa-home"></i> Màu Sắc</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/product-size/index"><i class="fa fa-home"></i> Kích Thước</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/product/index"><i class="fa fa-home"></i> Sản Phẩm</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/customer/index"><i class="fa fa-home"></i> Khách Hàng</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/product-store/index"><i class="fa fa-home"></i> Store</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/order/index"><i class="fa fa-home"></i> Đơn Đặt Hàng</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/order-detail/index"><i class="fa fa-home"></i> Chi Tiết Đơn Hàng</a></li>
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <!-- /menu footer buttons -->
          </div>
        </div>