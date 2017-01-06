<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login/Logout animation concept</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  
  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>

      <link rel="stylesheet" href="/LTNC/resources/login/css/style.css">

  
</head>

<body>
  <div class="cont">
  <div class="demo">
    <div class="login">
      <div class="login__check"></div>
      <div class="login__form">
      	<form:form action="login" method="POST" commandName="loginDTO">
      	<div class="login__row">
          <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
          <form:input path="userName" type="text" class="login__input name"/>
        </div>
        <div class="login__row">
          <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
          <form:input path="passWord" type="password" class="login__input pass"/>
        </div>
        <form:button type="submit" class="login__submit">Sign in</form:button>
        <p class="login__signup">Don't have an account? &nbsp;<a>Sign up</a></p>
      	</form:form>
        
      </div>
    </div>
    
  </div>
</div>
    <script src="${pageContext.request.contextPath}/resources/KendoJs/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/login/js/index.js"></script>

</body>
</html>
