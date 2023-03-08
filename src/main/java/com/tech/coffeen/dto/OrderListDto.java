package com.tech.coffeen.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListDto {

	private String ord_num; //주문번호
	private String m_id; //회원아이디
	private Date ord_date; //주문일자
	private String ord_pay; //결제형태
	private int ord_totprice; //결제총액
	private String ord_state; //처리상태
	
	public OrderListDto() {
		// TODO Auto-generated constructor stub
	}
}
