<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>adminIntro</title>
	<script type="text/javascript" src="http://localhost:9100/coffeen/_coffee/js/jquery-admin.js"></script>
	
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/homeStyle.css">
</head>
<body id="admin-body">

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

<h3>상품등록</h3>
<div class="addproduct"> 
	<form action="productInsert" method="post" enctype="multipart/form-data"
	onsubmit="return prdInsertcheck();">
		상품 
		<input type="text" name="p_name" /> <br />
		가격 
		<input type="text" name="p_price" /><br />
		재고 
		<input type="text" name="p_cnt" /><br />
	    색상 
	    <input type="text" name="p_color" /><br />
	    사이즈 
	    <input type="text" name="p_size"> <br />  
	    상품이미지
	    <input type="file" name="p_filesrc" class="productfile"/>  <br /> 
	    상품카테고리  
	    <input type="text" name="p_category" /><br />
	    상품내용  
	    <textarea name="p_info"></textarea><br />
    <input type="submit" value="상품등록" class="btn1"/><br />
</form>	
</div>



</body>
</html>


