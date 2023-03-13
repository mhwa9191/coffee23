package com.tech.coffeen.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.coffeen.service.CoffeeServiceInerface;

public class JoinService implements CoffeeServiceInerface{

	private SqlSession sqlSession;
	
	public JoinService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("JoinService--**--*");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
				
		String uploadPath=request.getSession().getServletContext().getRealPath("/");
	    System.out.println("uploadpathhhhh:"+uploadPath);
		
	    String path = "C:\\2022spring\\springProject\\coffee\\src\\main\\webapp\\resources\\upload";
	    MultipartRequest req = null;
	    try {
	    	req=
	  	          new MultipartRequest(request, path, 1024*1024*20, "utf-8",
	  	                new DefaultFileRenamePolicy());
	    	System.out.println("req : "+req);
		} catch (Exception e) {
			
		} 
	    
		String m_id = req.getParameter("m_id");
		String m_pw = req.getParameter("m_pw");
		String m_tel = req.getParameter("m_tel");
		String m_email = req.getParameter("m_email");
		
		System.out.println(m_id+"::"+m_pw+"::"+m_tel+"::"+m_email);
		
	}

}
