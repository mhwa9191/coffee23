package com.tech.coffeen.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.coffeen.member.JoinService;
import com.tech.coffeen.service.CoffeeServiceInerface;


@Controller
@RequestMapping("/member")
public class MemberController {
	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/loginJoinForm")
	public String loginForm(Model model) {
		System.out.println("--*--MemberController/loginForm--*--");
		return "/member/loginJoinForm";
	}
	@RequestMapping("/join")
	public String joinform(HttpServletRequest request,Model model) {
		System.out.println("--*--MemberController/join--*--");
		
		model.addAttribute("request",request);
		coffeeServiceInerface = new JoinService(sqlSession);
		coffeeServiceInerface.execute(model);
		return "/member/loginJoinForm";
	}
	
}
