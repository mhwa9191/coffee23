package com.tech.coffeen.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.coffeen.crypt.CryptoUtil;
import com.tech.coffeen.service.CoffeeServiceInerface;
import com.tech.coffeen.service.member.JoinService;
import com.tech.coffeen.service.member.LogOutService;
import com.tech.coffeen.service.member.LoginService;


@Controller
@RequestMapping("/member")
public class MemberController {
	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpSession;
	//로그인 회원가입화면
	@RequestMapping("/loginJoin")
	public String loginForm(Model model) {
		System.out.println("--*--MemberController/loginJoin--*--");
		return "/member/loginJoinForm";
	}
	
	//회원가입기능
	@RequestMapping("/join")
	public String joinform(HttpServletRequest request,Model model) {
		System.out.println("--*--MemberController/join--*--");
		
		model.addAttribute("request",request);
		coffeeServiceInerface = new JoinService(sqlSession);
		coffeeServiceInerface.execute(model);
		
		Map<String, Object> map = model.asMap();
		int joinResult = (Integer) map.get("joinResult");
		System.out.println("가입여부 확인 값"+joinResult);
		
		return joinResult==0? "/error/joinError":"/member/loginJoinForm";
	}
	
	//로그인기능
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public int login(HttpServletRequest request,Model model,CryptoUtil crypt) {
		System.out.println("--*--MemberController/login--*--");
		
		model.addAttribute("request",request);
		model.addAttribute("crypt",crypt);
		
		coffeeServiceInerface = new LoginService(sqlSession,httpSession);
		coffeeServiceInerface.execute(model);
				
		Map<String, Object> map = model.asMap();
		int logincheck_result = (Integer) map.get("logincheck_result"); //ajax return으로 data 줘야해서 model을 다시 풀음
		
		System.out.println("logincheck_result : "+logincheck_result);
		return logincheck_result;
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,Model model) {
		System.out.println("--*--MemberController/logout()--*--");
	
		coffeeServiceInerface = new LogOutService(httpSession);
		coffeeServiceInerface.execute(model);

		return "redirect:/";
	}
}
