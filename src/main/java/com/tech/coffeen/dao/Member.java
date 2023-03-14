package com.tech.coffeen.dao;

public interface Member {
	
	//회원가입
	public void join(String m_id, String m_tel, String m_email, String sha, String encryStr);
		
}
