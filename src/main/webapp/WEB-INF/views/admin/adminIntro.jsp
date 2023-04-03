<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>adminIntro</title>
	<link rel="stylesheet" href="http://localhost:9100/coffeen/_coffee/css/homeStyle.css">
	<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.0/dist/chart.min.js" type="text/javascript"></script>
</head>
<body id="admin-body">

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

<h3>차트</h3>
<%-- <c:forEach items="${orddList}" var="list">
 ${list.p_no } : ${list.sumcnt } </br>
</c:forEach> --%>
	<div>
		<canvas id="myChartOne" width="500" height="400"></canvas>
	</div>

<!-- 상품등록란으로 -->
<div>
	<a href="/coffeen/admin/productList">상품</a>
</div>

<!-- 차트 -->
<script type="text/javascript">
/* 값이동 때문에 동일페이지에서 작업함 */
function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 8; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
var data_arr = [1, 2, 3, 4, 5];
var bg_colors = data_arr.map( item => getRandomColor() );

const myChartOne = document.getElementById('myChartOne').getContext('2d');
const barChartOne =
new Chart(myChartOne,{	
	type:'bar',
	data:{
		labels:[
			"<c:forEach items='${orddList }' var='ordd' varStatus='status'> "
			+"${ordd.p_no}<c:if test='${status.last eq false}'>","</c:if> "
			+"</c:forEach>"
				],
		datasets:[{
			axis: 'y',
			label:'주문수량',
			data:[
				"<c:forEach items='${orddList }' var='ordd' varStatus='status'> "
				+"${ordd.sumcnt }<c:if test='${status.last eq false}'>","</c:if> "
				+"</c:forEach>"
				],
			fill: false,	
			backgroundColor: bg_colors,
			borderWidth:3
		}]
	},
	options:{
		responsive: false,
	    indexAxis: 'y',		
	}
});
</script>

</body>
</html>


