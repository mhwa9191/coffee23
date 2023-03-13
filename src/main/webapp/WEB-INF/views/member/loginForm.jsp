<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Sign in</title>
  <script type="text/javascript" src="../resources/js/jquery-trans.js"></script>
  <link rel="stylesheet" href="../resources/css/loginStyle.css">
</head>
<body>
<div class="container">
	<div class="welcome">
	    <div class="pinkbox">
	      <div class="signup nodisplay">
	        <h1>register</h1>
	        <form autocomplete="off">
				<input type="text" placeholder="username">
				<input type="tel" placeholder="tel">
				<input type="email" placeholder="email">
				<input type="password" placeholder="password">
				<input type="password" placeholder="confirm password">
				<button class="button submit">create account </button>
	        </form>
	      </div>
	      <div class="signin">
	        <h1>sign in</h1>
	        <form class="more-padding" autocomplete="off">
				<input type="text" placeholder="username">
				<input type="password" placeholder="password">
				<div class="checkbox">
				  <input type="checkbox" id="remember" /><label for="remember">remember me</label>
				</div>
				<button class="button submit">login</button>
	        </form>
	      </div>
	    </div>
	    <div class="leftbox">
			<h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
			<p class="desc">pick your perfect <span>bouquet</span></p>
			<img class="flower smaller" src="https://image.ibb.co/d5X6pn/1357d638624297b.jpg" alt="1357d638624297b" border="0">
			<p class="account">have an account?</p>
			<button class="button" id="signin">login</button>
	    </div>
	    <div class="rightbox">
			<h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
			<p class="desc"> pick your perfect <span>bouquet</span></p>
			<img class="flower" src="https://preview.ibb.co/jvu2Un/0057c1c1bab51a0.jpg"/>
			<p class="account">don't have an account?</p>
			<button class="button" id="signup">sign up</button>
		</div>
	</div>
</div>

     
</body>
</html>