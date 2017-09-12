package com.hotel.hotelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/template")
	public String template(){
		return "template";
	}

}
