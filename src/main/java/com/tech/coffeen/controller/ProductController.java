package com.tech.coffeen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.coffeen.service.CoffeeServiceInerface;
import com.tech.coffen.service.product.ProductListService;


@Controller
@RequestMapping("/product")
public class ProductController {
	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpSession;
	//로그인 회원가입화면
	@RequestMapping("/productList")
	public String productList(HttpServletRequest request,Model model) {
		System.out.println("--*--ProductController/productList--*--");
		
		model.addAttribute("request",request);
		coffeeServiceInerface=new ProductListService(sqlSession, httpSession);
		coffeeServiceInerface.execute(model);
		
		return "/product/productList";
	}
	
	
}
