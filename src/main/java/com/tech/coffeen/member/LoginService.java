package com.tech.coffeen.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.crypt.CryptoUtil;
import com.tech.coffeen.dao.Member;
import com.tech.coffeen.dto.MemberDto;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class LoginService implements CoffeeServiceInerface{

	private SqlSession sqlSession;
	private HttpSession httpSession;
	
	
	public LoginService(SqlSession sqlSession,HttpSession httpSession) {
		this.sqlSession = sqlSession;
		this.httpSession = httpSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("LoginService--**--*");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		CryptoUtil crypt = (CryptoUtil) map.get("crypt");
	
		Member dao = sqlSession.getMapper(Member.class);
		
		String m_id = request.getParameter("login_m_id");
		String m_pw = request.getParameter("login_m_pw");
		
		System.out.println("아이디비번확인 : "+m_id + m_pw);
		
		int logincheck_result = -1; //로그인 확인결과
		
		MemberDto dto = dao.getsharsa(m_id);
		if(dto==null) {
			logincheck_result = 0;
			System.out.println("회원정보에아이디없음 확인용");
			model.addAttribute("logincheck_result",logincheck_result); //로그인확인결과
		}else {
			String sha = dto.getM_pw_sha();
			String rsa = dto.getM_pw_rsa();
			System.out.println("확인용 : "+sha+rsa);			
			
			String decryptStr = "";
						
			System.out.println("============================ ");
				try {
					decryptStr=CryptoUtil.decryptAES256(rsa,sha );
					System.out.println("복호화된 데이터 : "+decryptStr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("복호화된 데이터실패 : ");
				} 
				System.out.println("============================ ");
				

			if(m_pw.equals(decryptStr)) { //로그인성공일때
				System.out.println("로그인완료"); //확인용
				httpSession = request.getSession();
				httpSession.setAttribute("loginid", m_id); //세션에 아이디등록
				System.out.println("세션등록아이디 확인 : "+httpSession.getAttribute("loginid")); //확인용
				logincheck_result = 1;
			}else{ //로그인실패일때
				System.out.println("비밀번호틀림확인용");
				logincheck_result = 0;
			}
			model.addAttribute("logincheck_result",logincheck_result); //로그인확인결과
		}
		
	}
	
}
