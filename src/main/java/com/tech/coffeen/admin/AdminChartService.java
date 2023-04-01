package com.tech.coffeen.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.dao.OrderDetail;
import com.tech.coffeen.dto.OrderDetailDto;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class AdminChartService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	
	public AdminChartService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("AdminChartService--**--*");
		
//		Map<String , Object> map=model.asMap();
//		HttpServletRequest request=
//				(HttpServletRequest)map.get("request");
		OrderDetail ordd=sqlSession.getMapper(OrderDetail.class);
		List<OrderDetailDto> orddList=ordd.orddChartList();
	
		model.addAttribute("orddList",orddList);
	}
	
}
