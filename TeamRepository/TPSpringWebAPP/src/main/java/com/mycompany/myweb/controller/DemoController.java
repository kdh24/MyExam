package com.mycompany.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {	
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@RequestMapping("/demomain")
	public String demomain() {
		return "demo/demomain";
	}
	
}
