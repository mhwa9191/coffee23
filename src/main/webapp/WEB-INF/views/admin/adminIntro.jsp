<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>adminIntro</title>
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/homeStyle.css">

</head>
<body id="admin-body">

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

<h3>차트</h3>
<c:forEach items="${orddList}" var="list">
 ${list.p_no } : ${list.sumcnt } </br>
</c:forEach>




</body>
</html>


