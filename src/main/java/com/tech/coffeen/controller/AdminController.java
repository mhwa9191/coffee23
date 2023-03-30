package com.tech.coffeen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.coffeen.service.CoffeeServiceInerface;

@Controller
@RequestMapping("/admin")
public class AdminController {

	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpSession;
	
	// 관리자 시작화면
	@RequestMapping("/adminIntro")
	public String adminintro(HttpServletRequest request, Model model) {
		//System.out.println("adminintro---");
		
		model.addAttribute("request", request);
		return "/admin/adminIntro";
	}
	
}
