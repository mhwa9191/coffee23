<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/homeStyle.css">
</head>
<body id="home-body">

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
<a href="./product/productList">전체상품</a>

<h2>판매량 top5</h2>
<br />
<h4>전체상품 top5</h4>
<h6></h6>
<ul class="productChart">
<c:forEach items="${productMain }" var="pMain">
	<li>
		<div class="pdtthumbnail">
			<a href="../product/productDetail?pname=${pMain.p_name }&pfilesrc=${pMain.p_filesrc }">
			<img src="../resources/img/productimg/${pMain.p_filesrc }.jpg" alt="" />
			</a>
		</div>
		<div class="pdtdetail">
			<p class="pname">
			<a href="../product/productDetail?pname=${pMain.p_name }&pfilesrc=${pMain.p_filesrc }">
			${pMain.p_name}
			</a>
			</p>
			<p class="pcolor">
				<span>${pChart.p_color}</span>
			</p>
			<p class="pprice">
				<span><fmt:formatNumber value="${pMain.p_price}" pattern="###,###"/>원</span>
			</p>
		</div>
	</li>	
</c:forEach>
</ul>


</body>
</html>


