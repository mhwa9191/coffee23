
window.onload = function() {
	document.getElementById("signup").onclick = function () {
		document.getElementsByClassName("pinkbox")[0].style.transform="translateX(80%)";
		document.getElementsByClassName("signin")[0].classList.add('nodisplay');
		document.getElementsByClassName("signup")[0].classList.remove('nodisplay');
	};
	
	document.getElementById("signin").onclick = function () {
		document.getElementsByClassName("pinkbox")[0].style.transform="translateX(0%)";
		document.getElementsByClassName("signup")[0].classList.add('nodisplay');
		document.getElementsByClassName("signin")[0].classList.remove('nodisplay');
	};
};

