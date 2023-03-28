<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> <!-- include 사용하려고 -->
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/homeStyle.css">
<title>Insert title here</title>
</head>
<body>
<div class="main-header">
	
		<h3 class="main-header-title">
			<a href="/coffeen">Coffee & caffeine</a>
		</h3>
	
		<c:if test="${empty sessionScope.loginid }">
	<ul class="main-header-title-member">
		<li><a href="/coffeen/member/loginJoin">Login&Join</a></li>
	</ul>
		</c:if>
		<c:if test="${not empty sessionScope.loginid }">
	<ul class="main-header-title-member_in">
		<li><a href="/coffeen/member/logout">LogOut</a></li>
		<li><a href="/coffeen/member/myPage">
			<img alt="member-flaticon" src="http://localhost:9100/coffeen/_coffee/img/loginjoin/user.png" >
		</a></li>
	</ul>
	</c:if>
</div>

</body>
</html>