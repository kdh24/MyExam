package com.mycompany.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agreement")
public class AgreementController {	
	private static final Logger logger = LoggerFactory.getLogger(AgreementController.class);

	@RequestMapping("/agreementmain")
	public String agreementmain() {
		return "agreement/agreementmain";
	}
	  
}
