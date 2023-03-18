<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Sign in</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> <!-- ajax 사용시 필요 -->
  <script type="text/javascript" src="../resources/js/jquery-trans.js"></script>

  <link rel="stylesheet" href="../resources/css/loginStyle.css">
  
</head>
<body>
<div class="container">
	<div class="welcome">
	    <div class="pinkbox">
	      <div class="signup nodisplay">
	        <h1>register</h1>
	        <form action="join" method="post" enctype="multipart/form-data" name="joinForm" onsubmit="return checkinfo();">
				<input type="text" placeholder="id" name="m_id" id="m_id">
				<input type="tel" placeholder="tel" name="m_tel">
				<input type="email" placeholder="email" name="m_email">
				<input type="password" placeholder="password" name="m_pw">
				<input type="password" placeholder="confirm password" name="m_pw_conf">
				<button class="button submit">create account </button>
	        </form>
	      </div>
	      <div class="signin">
	        <h1>sign in</h1>
	        <form class="more-padding">
				<input type="text" placeholder="username" name="login_input-id" id="login_input-id">
				<input type="password" placeholder="password" name="login_input-pw" id="login_input-pw">
				<div class="checkbox">
				  <input type="checkbox" id="remember" /><label for="remember">remember me</label>
				</div>
				<button class="button submit" onclick="check_id_pw()" type="button">login</button> <!-- type button 지정하지 않으면 오류발생 -->
	        </form>
	      </div>
	    </div>
	    <div class="leftbox">
			<h2 class="title"><span>Coffee</span>&<br>caffeine</h2>
			<p class="desc">pick your perfect <span>Coffee</span></p>
			<img class="flower smaller" src="../resources/img/loginjoin/coffee_latte.png" alt="coffee_latte" border="0">
			<p class="account">have an account?</p>
			<button class="button" id="signin">login</button>
	    </div>
	    <div class="rightbox">
			<h2 class="title"><span>Coffee</span>&<br>caffeine</h2>
			<p class="desc"> pick your perfect <span>Coffee</span></p>
			<img class="flower" src="../resources/img/loginjoin/coffee-flower.jpg"/>
			<p class="account">don't have an account?</p>
			<button class="button" id="signup">sign up</button>
		</div>
	</div>
</div>

     
</body>
</html>