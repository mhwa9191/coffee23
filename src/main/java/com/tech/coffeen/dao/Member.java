package com.tech.coffeen.dao;

import com.tech.coffeen.dto.MemberDto;

public interface Member {
	
	//회원가입 + 가입여부확인차 반환값을 받음
	public int join(String m_id, String m_tel, String m_email, String sha, String encryStr);
		
	// 로그인  확인
	public MemberDto getsharsa(String m_id);
}
