<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DataTables | Gentellela</title>

    <!-- Bootstrap -->
    <tiles:insertAttribute name="resource_css"/>
    <script src="${pageContext.request.contextPath}/resources/KendoJs/js/jquery.min.js"></script>
    <!-- Kendo -->
     <script src="http://cdnjs.cloudflare.com/ajax/libs/jszip/2.4.0/jszip.js"></script>
      <script src="${pageContext.request.contextPath}/resources/KendoJs/js/kendo.all.min.js"></script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <%@ include file="/WEB-INF/layout/menu.jsp" %>
        <!-- top navigation -->
        <%@ include file="/WEB-INF/layout/top_nav.jsp" %>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
          <div>
 				<tiles:insertAttribute name="content"/>
          </div>
            
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
		<tiles:insertAttribute name="footter"/>
        <!-- /footer content -->
      </div>
    </div>

        <tiles:insertAttribute name="resource_scripts"/>
  </body>
</html>