package com.tech.coffeen.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.coffeen.service.CoffeeServiceInerface;

@Controller
@RequestMapping("/member")
public class MemberController {
	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/joinForm")
	public String joinform(Model model) {
		System.out.println("--*--MemberController/joinform--*--");
		return "/member/joinForm";
	}
	
}
