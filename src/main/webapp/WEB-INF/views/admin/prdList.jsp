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

<h3>상품관리</h3>
<div class="container">
	<!-- 검색 -->		
	<form action="prdList" id="form">
		<input type="text" id="q" name="q" value="${search}" placeholder="상품검색" />
		<input type="submit" value="검색" class="btn1"/>
		
		<select name="price">
			<option >가격순</option>
			<option >가격높은순</option>
			<option >가격낮은순</option>
		</select>
		<select name="size">
			<option >사이즈</option>
			<option>085XS</option>
			<option>090S</option>
			<option >095M</option>
			<option>100L</option>
			<option>105XL</option>
		</select>
	</form>
		총 상품수 : ${searchVo.totRow }	
		<table width="1100" border="1">
			<tr>
				<td>
				<input type='checkbox' name='checkbox' value='selectall' onclick='selectAll(this)'/> 
				</td>
				<td>상품</td>
				<td>상품번호</td>
				<td>상품명</td>
				<td>가격</td>
				<td>재고</td>
				<td>색상</td>
				<td>사이즈</td>
				<td>상품카테고리</td>
				<td>상품등록일</td>
				<td>수정</td>
			</tr>
			<c:forEach items="${plist }" var="list">
				<tr >
					<td>
						<input type="checkbox" name="checkbox" value="${list.p_no }"/>
					</td>
					<td><img src="../_coffee/upload/${list.p_filesrc }" alt="img" width="100px" height="100px"/></td>
					<td class="p_no" id="p_no">${list.p_no }</td>
					<td>
						<em id="${list.p_no }a1">${list.p_name }</em>
						<input type="text" id="${list.p_no }a2" value="${list.p_name }" style="display: none;" />
					</td>
					<td>
						<em id="${list.p_no }a3">${list.p_price }</em>
						<input type="text" id="${list.p_no }a4" value="${list.p_price }" size="4" style="display: none;" />
					</td>
					<td>
						<em id="${list.p_no }a5">${list.p_cnt }</em>
						<input type="text" id="${list.p_no }a6" value="${list.p_cnt }" size="2" style="display: none;" />
					</td>
					<td>${list.p_color }</td>
					<td>${list.p_size }</td>
					<td>${list.p_category }</td>
					<td>${list.p_date }</td>
					<td>
					<button type="button" id="${list.p_no }btn1" onclick="modify(this);" class="btn1">수정</button>
					<button type="button" id="${list.p_no }btn2" onclick="modifydb(this);" style="display: none;" class="btn1">수정완료</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="productAdd">등록</a>	
		<a href="#" onclick="productDelete();">삭제</a>
		<a href="#">차트보기</a>
	<br />
	<br />
	<!-- 페이지 처리 -->
	<div class="product-page">
		<c:if test="${searchVo.page > 1 }">
			<a href="productList?page=1&q=${search}&price=${price }&size=${size }">[처음]</a>
			<a href="productList?page=${searchVo.page-1 }&q=${search}&price=${price }&size=${size }">[이전]</a>
		</c:if>
	
		<c:forEach begin="${searchVo.pageStart }" end="${searchVo.pageEnd }" var="i">
			<c:choose>
				<c:when test="${i eq searchVo.page }">
					<span style="color: red; font-weight: bold">${i }&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="productList?page=${i }&q=${search}&price=${price }&size=${size }" style="text-decoration: none;">${i }&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<c:if test="${searchVo.page < searchVo.totPage }">
			<a href="productList?page=${searchVo.page+1 }&q=${search}&price=${price }&size=${size }">[다음]</a>
			<a href="productList?page=${searchVo.totPage }&q=${search}&price=${price }&size=${size }">[마지막]</a>
		</c:if>
	</div>
</div><br />

</body>
</html>


