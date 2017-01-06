<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
              <div id="grid-category"></div>
                <%-- <div class="x_panel">
                  <div class="x_title">
                    <h2>Admin <small>Danh Mục</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>Tên</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${listCategory}" var="category">
                        <tr>
                          <td>${category.categoryName }</td>
                          <td width="100px;">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                        <span style="width:20px;" class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="${pageContext.request.contextPath}/category/update/${category.categoryId}">Sửa</a></li>
                                        <li><a href="${pageContext.request.contextPath}/category/delete/${category.categoryId}">Xóa</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div> --%>
              </div>
</div>
<style>
 .k-button {
    text-transform:none !important;
    border-radius:10px;
    padding: 5px 5px;
    border-width: 0px;
    min-width: 45px !important;
    }
</style>
<script src="${pageContext.request.contextPath}/resources/tuychinh/category.js"></script>