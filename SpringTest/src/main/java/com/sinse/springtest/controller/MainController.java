package com.sinse.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/board/main")
	public String getMain() {
		
		return "board/main";
	}

}
