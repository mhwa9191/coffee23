package com.tech.coffen.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.dao.Product;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class ProductListService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	private HttpSession httpSession;
	
	public ProductListService(SqlSession sqlSession,HttpSession httpSession) {
		this.sqlSession = sqlSession;
		this.httpSession = httpSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("ProductListService--**--*");
		
		Map<String ,Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		//로그인 세션
		httpSession = request.getSession();
		String loginId = (String)httpSession.getAttribute("loginid");
		
		Product Pdao=sqlSession.getMapper(Product.class);
		model.addAttribute("productList",Pdao.productList());
		
		
	}
}
