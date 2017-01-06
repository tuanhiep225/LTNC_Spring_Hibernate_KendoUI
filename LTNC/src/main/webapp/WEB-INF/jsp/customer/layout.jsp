<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Women's Fashion a Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Women's Fashion Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="${pageContext.request.contextPath}/resources/customer_user/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/resources/customer_user/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/resources/customer_user/css/fasthover.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="${pageContext.request.contextPath}/resources/customer_user/js/jquery.min.js"></script>
<!-- //js -->
<!-- countdown -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/customer_user/css/jquery.countdown.css" />
<!-- //countdown -->
<!-- cart -->
<script src="${pageContext.request.contextPath}/resources/customer_user/js/simpleCart.min.js"></script>
<!-- cart -->
<!-- for bootstrap working -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/customer_user/js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- start-smooth-scrolling -->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
<!-- //end-smooth-scrolling -->
</head>
	
<body>
<!-- header -->
	<%-- <%@ include file="/WEB-INF/jsp/customer/partial_layout/header.jsp" %> --%>
	<tiles:insertAttribute name="homeheader"/>
<!-- //header -->
<%-- <%@ include file="/WEB-INF/jsp/customer/index.jsp" %> --%>
<tiles:insertAttribute name="homecontent"/>
<!-- footer -->
<%-- <%@ include file="/WEB-INF/jsp/customer/partial_layout/footer.jsp" %> --%>
	<tiles:insertAttribute name="homefooter"/>
<!-- //footer -->
</body>
</html>