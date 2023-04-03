package com.tech.coffeen.service.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.coffeen.dao.Admin;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class APrdInsertService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	
	public APrdInsertService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("APrdInsertService--**--*");
		
		Map<String , Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		Admin dao=sqlSession.getMapper(Admin.class);
		
		String path="C:\\2023spring\\sprProject\\coffee\\src\\main\\webapp\\resources\\upload";
		MultipartRequest req=null;
		try {
			req=new MultipartRequest(request, path, 1024*1024*20, "utf-8",
					new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		String p_name=req.getParameter("p_name");
		String p_price=req.getParameter("p_price");
		String p_cnt=req.getParameter("p_cnt");
		String p_color=req.getParameter("p_color");
		String p_size=req.getParameter("p_size");
		String p_filesrc=req.getFilesystemName("p_filesrc");
		String p_category=req.getParameter("p_category");
		String p_info=req.getParameter("p_info");
//		System.out.println(p_name+"::"+p_price+"::"+p_cnt+"::"+
//		p_color+"::"+p_size+"::"+p_filesrc+"::"+p_category+"::"+p_info);

		dao.productInsert(p_name,p_price,p_cnt,p_color,p_size,
				p_filesrc,p_category,p_info);
	}
	
}
