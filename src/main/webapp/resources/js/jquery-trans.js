
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

// 회원가입시 확인
function checkinfo(){
	//alert("aa");
	var m_id = joinForm.m_id.value;
	//alert(m_id);
	var m_pw = joinForm.m_pw.value;
	var m_tel = joinForm.m_tel.value;
	var m_email = joinForm.m_email.value;
//	var checkid_YESorNO = jf.checkid_YESorNO.value;
//	var checkname2_YESorNO = jf.checkname2_YESorNO.value;
	//var m_grade = jf.m_grade.value;
	//var m_cash = jf.m_cash.value;
	let valcheck_pw = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	let valcheck_tel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	let valcheck_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if(m_id==0 || m_id==""){
		alert("아이디를입력하세요")
		return false;
	}else if(checkid_YESorNO=="NO"){
		alert("아이디중복확인하세요")
		return false;
	}else if(m_pw==0 ||m_pw==""){
		alert("비밀번호를입력하세요")
		return false;
	}else if(!valcheck_pw.test(m_pw)||m_pw.length<8){
		alert("비번정규표현식XXXX신호")
		jf.m_pw.focus();
		return false;
	}else if(m_tel==0 || m_tel==""){
		alert("전화번호를입력하세요")
		return false;
	}else if(!valcheck_tel.test(m_tel)){
		alert("전번정규표현식XXXX신호")
		jf.m_tel.focus();
		return false;
	}else if(m_email==0 || m_email==""){
		alert("이메일을입력하세요")
		return false;
	}else if(!valcheck_email.test(m_email)){
		alert("메일정규표현식XXXX신호")
		jf.m_email.focus();
		return false;
	}else{
		return true;
		alert("가입진행신호")
	}
	
}


// 로그인시 확인
function check_id_pw(){
//	alert("로그인버튼눌렀나");
	let loginform_input_id = document.getElementById("login_input-id").value; //input id값
	let loginform_input_pw = document.getElementById("login_input-pw").value; //input password값
	if(!loginform_input_id){ //id를 입력하지않으면
		alert("아이디를입력하세요")
	}else if(!loginform_input_pw){ //pw를 입력하지않으면
		alert("비밀번호를입력하세요")
	}else {
		console.log("ajax");
		$.ajax({ // 작동 오류해결필요 -- ajax/libs/ script 추가 + function사용하는 button의 type button으로 지정하여 해결
			 type:'POST',
			 url:'../member/login',
			 data:"login_m_id="+loginform_input_id+"&login_m_pw="+loginform_input_pw,
			 dataType:'text',
			 success:function(result){
//						alert("ajax 값확인"+result);
				if(result==0){ 
					alert("아이디비밀번호를확인하세요");
					window.location.href="../member/loginJoinForm";
				}else if(result==1){ 
					alert("로그인성공");
					window.location.href="../"; //로그인성공시 메인페이지로이동
				}
			},
			error:function(e){        
		            console.log(e);
		            alert("로그인에 실패하셨습니다.");
		    }
		});
	}
	
}