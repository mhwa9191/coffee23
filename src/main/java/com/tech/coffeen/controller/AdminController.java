package com.tech.coffeen.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.coffeen.service.CoffeeServiceInerface;
import com.tech.coffeen.service.admin.APrdDeleteService;
import com.tech.coffeen.service.admin.APrdInsertService;
import com.tech.coffeen.service.admin.APrdListService;
import com.tech.coffeen.service.admin.AdminChartService;
import com.tech.coffeen.vopage.SearchVO;


@Controller
@RequestMapping("/admin")
public class AdminController {

	CoffeeServiceInerface coffeeServiceInerface;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpSession;
	
	// 관리자 시작화면
	@RequestMapping("/intro")
	public String adminintro(HttpServletRequest request, Model model) {
		//System.out.println("adminintro---");
		
		model.addAttribute("request", request);
		
		coffeeServiceInerface=new AdminChartService(sqlSession);
		coffeeServiceInerface.execute(model);
		
		return "/admin/adminIntro";
	}
	
	// 관리자 상품관리 현황 리스트
	@RequestMapping("/productList")
	public String productList(HttpServletRequest request, SearchVO searchVO, Model model) {
//		System.out.println("/admin/productList");
		model.addAttribute("request", request);
		model.addAttribute("searchVo", searchVO);
		coffeeServiceInerface=new APrdListService(sqlSession);
		coffeeServiceInerface.execute(model);
		
		return "admin/prdList";
	}
	
	// 관리자 상품관리 상품등록란
	@RequestMapping("/productAdd")
	public String productAdd(Model model) {
		System.out.println("/admin/productAdds");
		return "admin/prdAdd";
	}
	
	// 관리자 상품관리 상품등록
	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
	public String productInsert(HttpServletRequest request, Model model) {
//		System.out.println("/admin/productInsert");

		model.addAttribute("request", request);
		coffeeServiceInerface=new APrdInsertService(sqlSession);
		coffeeServiceInerface.execute(model);
		return "redirect:/admin/productList";
	}
	
	// 관리자 상품관리 현황 리스트 삭제
	@RequestMapping(value = "/adminProductDelete", method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int admin_productDelete(HttpServletRequest request, 
			@RequestParam(value="checkBoxArr[]") List<String> checkBoxArr, Model model)  {
//		System.out.println("/admin/admin_productDelete");

		model.addAttribute("request", request);
	    model.addAttribute("checkBoxArr",checkBoxArr);

	    coffeeServiceInerface = new APrdDeleteService(sqlSession);
	    coffeeServiceInerface.execute(model);
		Map<String , Object> map=model.asMap();
		int delnum=(Integer)map.get("delnum");
	  return delnum;
	}
}
