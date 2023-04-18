<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/pstyle.css" />
</head>
<body id="home-body">
<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
<h3>전체</h3>

<div class="productNormalPackage">
<ul class="productList">
<c:forEach items="${productList}" var="plist">
	<li>
		<div class="pdtthumbnail" >
			<a href="productDetail?pname=${plist.p_name }&pfilesrc=${plist.p_filesrc}">
			<img src="../_coffee/upload/${plist.p_filesrc}" alt="" />
			</a>
		</div>
		<div class="pdtinfo">
		<div class="pdtname">
			<a href="productDetail?pname=${plist.p_name}&pfilesrc=${plist.p_filesrc}">
			${plist.p_name}
			</a>
		</div>
		<div class="pdtprice">
			<p><fmt:formatNumber value="${plist.p_price}" pattern="###,###"/>원</p>
		</div>
		</div>
	</li>	
</c:forEach>
</ul>
</div>

</body>
</html>