package com.tech.coffeen.dao;

import java.util.List;

import com.tech.coffeen.dto.OrderDetailDto;

public interface OrderDetail {

	// 주문상세 차트 
	public List<OrderDetailDto> orddChartList();
}
