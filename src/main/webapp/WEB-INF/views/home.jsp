<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/homeStyle.css">
</head>
<body>
<div class="main-body">
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div class="main-body-title-member">
		<a href="./member/loginJoinForm">Login&Join</a>
	</div>
</div>


</body>
</html>


