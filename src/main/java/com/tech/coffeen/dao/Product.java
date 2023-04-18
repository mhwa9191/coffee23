package com.tech.coffeen.dao;

import java.util.ArrayList;

import com.tech.coffeen.dto.ProductDto;

public interface Product {
	
	// 상품목록
	public ArrayList<ProductDto> productList();

	// 메인화면 상품
	public ArrayList<ProductDto> productMain();
		
}
