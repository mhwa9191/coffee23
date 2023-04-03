package com.tech.coffeen.dao;

import java.util.ArrayList;

import com.tech.coffeen.dto.ProductDto;

public interface Admin {
	
//	상품관리리스트
	public ArrayList<ProductDto> prdList(int rowStart, int rowEnd, String search, String size, int num);
//	상품관리 리스트 페이지
	public int selectAdminTotCount(String search, String size);
//	상품등록
	public void productInsert(String p_name, String p_price, String p_cnt, String p_color,
			String p_size, String p_filesrc, String p_category, String p_info);
}
