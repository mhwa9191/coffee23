<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page isErrorPage = "true" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
<title>에러 발생</title>
<style type="text/css">
div{display: flex;
}
#error-text{ 
text-align:center;
margin: 50px auto;
height: 100px;
background-color: rgb(253,249,250) ;
color:#7A3E65;
 }
</style>
</head>
<body>

<div>
<img alt="error" src="http://localhost:9100/coffeen/_coffee/img/error.png"> <br/>
	<div id="error-text">
		죄송합니다. <br/>
		요청 처리 과정에서 에러가 발생하였습니다.<br/>
		빠른 시간 내에 문제를 해결하도록 하겠습니다.<br/>
	</div>
	<a href="/coffeen">go home</a>
</div>
</body>
</html>
