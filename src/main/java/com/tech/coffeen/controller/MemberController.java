package com.tech.coffeen.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tech.coffeen.service.CoffeeServiceInerface;

@Controller
public class MemberController {
	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
}
