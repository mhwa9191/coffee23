<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> <!-- include 사용하려고 -->
	<link rel="stylesheet" href="../resources/css/homeStyle.css">
<title>Insert title here</title>
</head>
<body>
<div class="main-header">
	<div class="main-header-title">
		<h3>
			<a href="/coffeen">Coffee & caffeine</a>
		</h3>
	</div>
	<div class="main-header-title-member">
		<c:if test="${empty sessionScope.loginid }">
		<a href="/coffeen/member/loginJoinForm">Login&Join</a>
		</c:if>
	</div>
	<div class="main-header-title-member_in">
		<c:if test="${not empty sessionScope.loginid }">
		<a href="/coffeen/member/logout">LogOut</a>
		<a href="/coffeen/member/myPage">
			<img alt="member-flaticon" src="resources/img/loginjoin/user.png" >
		</a>
	</c:if>
	</div>
</div>

</body>
</html>