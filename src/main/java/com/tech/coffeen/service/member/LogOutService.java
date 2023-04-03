package com.tech.coffeen.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.tech.coffeen.service.CoffeeServiceInerface;

public class LogOutService implements CoffeeServiceInerface {
	private HttpSession httpSession;
	
	
	public LogOutService(HttpSession httpSession) {
			this.httpSession = httpSession;
	}

	@Override
	public void execute(Model model) {
		String loginid = (String)httpSession.getAttribute("loginid");
		
		System.out.println("로그아웃하려는아이디 : "+loginid);
		
		httpSession.removeAttribute("loginid");
	}
}
