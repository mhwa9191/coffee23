package com.tech.coffeen.service.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.dao.Admin;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class APrdDeleteService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	
	public APrdDeleteService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
//		System.out.println("---APrdDeleteService");
		
		Map<String , Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		List<String> checkBoxArr=(List<String>)map.get("checkBoxArr");
		Admin dao=sqlSession.getMapper(Admin.class);
		int delnum=0;
		for (String str : checkBoxArr) {
//			System.out.println("삭제할 checkbox APrdDeleteService : "+str);
			dao.Checkdelete(str);
			delnum+=1;
		}
//		System.out.println("삭제값 APrdDeleteService :: "+delnum);
		model.addAttribute("delnum",delnum);
	}
}
