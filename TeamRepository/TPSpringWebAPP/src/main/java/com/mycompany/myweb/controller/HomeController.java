package com.mycompany.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.service.MemberService;

@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		logger.info("■CTL■ index 페이지 호출");
		return "index";
	}
	
	
	/////////// 지워질대상 
	@RequestMapping("/manual")
	public String manual() {
		logger.info("■CTL■ manual 페이지 호출");
		return "manual";
	}
	
	

}
