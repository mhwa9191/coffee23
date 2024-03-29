package com.tech.coffeen.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.coffeen.crypt.CryptoUtil;
import com.tech.coffeen.dao.Member;
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
		
		CryptoUtil crypt = (CryptoUtil) map.get("crypt");
		
		int joinResult=0; //가입여부확인값
		
		String uploadPath=request.getSession().getServletContext().getRealPath("/");
	    System.out.println("uploadpathhhhh:"+uploadPath);
		
	    String path = "C:\\2023spring\\sprProject\\coffee\\src\\main\\webapp\\resources\\upload";
	    MultipartRequest req = null;
	    try {
	    	req=
	  	          new MultipartRequest(request, path, 1024*1024*20, "utf-8",
	  	                new DefaultFileRenamePolicy());
	    	System.out.println("req : "+req);
	    	
	    	String m_id = req.getParameter("m_id");
			String m_pw = req.getParameter("m_pw");
			String m_tel = req.getParameter("m_tel");
			String m_email = req.getParameter("m_email");
			
			System.out.println(m_id+"::"+m_pw+"::"+m_tel+"::"+m_email);
			
			String sha="";
			try {
				sha=CryptoUtil.sha512(m_pw);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sha Exception: "+e);
			}
			System.out.println("sha512방식 암호화 : "+sha);
			
			String key2=sha;
			String encryStr = "";
			try {
				encryStr = CryptoUtil.encryptAES256(m_pw, key2);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("encryStr Exception: "+e);
			}
			System.out.println("양방향암호화 : "+encryStr);
			
			Member dao = sqlSession.getMapper(Member.class);
			joinResult=dao.join(m_id,m_tel,m_email,sha,encryStr);	
	    	
		} catch (Exception e) {
			System.out.println("경로 오류 req Exception: "+e);
			//경로오류일때 req.getParameter NullPointerException 오류발생
			//가입에 실패한 것을 알려야함
		} 
	    
	   model.addAttribute("joinResult",joinResult); //가입여부알림
		
	}

}
