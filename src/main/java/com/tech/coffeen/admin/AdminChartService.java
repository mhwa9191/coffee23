package com.tech.coffeen.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.crypt.CryptoUtil;
import com.tech.coffeen.dao.Member;
import com.tech.coffeen.dto.MemberDto;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class AdminChartService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	
	public AdminChartService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("AdminChartService--**--*");
		
		Map<String , Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		
	}
	
}
