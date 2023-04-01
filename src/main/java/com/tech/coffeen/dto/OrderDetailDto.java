package com.tech.coffeen.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {

	private String ordd_num; //상품주문번호
	private String ord_num; //주문번호
	private String p_no; //상품번호
	private int ordd_cnt; //주문수량
	
	private int sumcnt;// 주문상세 차트
	
	public OrderDetailDto() {
		// TODO Auto-generated constructor stub
	}
}
