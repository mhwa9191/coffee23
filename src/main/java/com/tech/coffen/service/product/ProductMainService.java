package com.tech.coffen.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.dao.Product;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class ProductMainService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	private HttpSession httpSession;
	
	public ProductMainService(SqlSession sqlSession,HttpSession httpSession) {
		this.sqlSession = sqlSession;
		this.httpSession = httpSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("ProductMainService--**--*");
		
		Map<String ,Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		Product pDao=sqlSession.getMapper(Product.class);
//		model.addAttribute("prodctMain",pDao.productMain());
	
	}
}
