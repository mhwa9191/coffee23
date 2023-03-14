package com.tech.coffeen.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

	private String m_id; //회원아이디
	private String m_pw_sha; //회원비밀번호sha
	private String m_pw_rsa; //회원비밀번호 rha
	private String m_tel; //회원전화번호
	private String m_email; //회원이메일
	private String m_grade; //회원등급
	private int m_cash; //회원캐시
	private String m_filesrc; //회원사진
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
}
