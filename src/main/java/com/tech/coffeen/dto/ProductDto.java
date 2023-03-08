package com.tech.coffeen.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

	private String p_no; //상품번호
	private String p_name; //사품이름
	private int p_price; //상품가격
	private int p_cnt; //상품재고
	private String p_color; //상품색상
	private String p_size; //상품사이즈
	private String p_filesrc; //상품사진
	private Date p_date; //상품입고일
	private String p_category; //상품카테고리
	private String p_info; //상품정보
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
}
