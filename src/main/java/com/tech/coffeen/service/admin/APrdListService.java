package com.tech.coffeen.service.admin;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.tech.coffeen.dao.Admin;
import com.tech.coffeen.dao.Product;
import com.tech.coffeen.dto.ProductDto;
import com.tech.coffeen.service.CoffeeServiceInerface;
import com.tech.coffeen.vopage.SearchVO;

public class APrdListService implements CoffeeServiceInerface{
	private SqlSession sqlSession;
	
	public APrdListService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println("APrdListService--**--*");
		
		Map<String ,Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");
		
		SearchVO searchVO=(SearchVO)map.get("searchVO");
		
		Admin dao=sqlSession.getMapper(Admin.class);
		
		String price=request.getParameter("price");
		String size=request.getParameter("size");
		String strPage=request.getParameter("page");
		if (strPage==null) {
			strPage="1";
		}
		int page=Integer.parseInt(strPage);
		searchVO.setPage(page);
		String search=request.getParameter("q");
		
		if (search==null || search.equals("상품명")) {
			search="";
		}
		model.addAttribute("search",search);
		search=search.toUpperCase().replace(" ", "_");
	
		int num=0;
		//처음접속시 null
		if (price ==null || size == null ) {
			price="";
			size="";
		}
		if(price.equals("가격순") && size.equals("사이즈") ) {
			price="";
			size="";
		}else if (price.equals("가격높은순") && size.equals("사이즈")) {
			num=1;
			size="";
		}else if (price.equals("가격높은순") && !size.equals("사이즈")) {
			num=1;	
		}else if (price.equals("가격낮은순") && size.equals("사이즈")) {
			num=2;
			size="";
		}else if (price.equals("가격낮은순") && !size.equals("사이즈")) {
			num=2;
		}
		int total=0;
//		사이즈를 선택하지 않았을떄
		
		total=dao.selectAdminTotCount(search,size);			
//		사이즈를 선택헀을때		
		
		searchVO.pageCalculate(total);
	
		int rowStart=searchVO.getRowStart();
		int rowEnd=searchVO.getRowEnd();
		ArrayList<ProductDto> prdList=dao.prdList(rowStart, rowEnd, search, size, num);		
		
		model.addAttribute("size",size);
		model.addAttribute("price",price);
					
		model.addAttribute("plist",prdList);			
	
		model.addAttribute("totRowcnt",total);
		model.addAttribute("searchVo",searchVO);
	}
	
}
