package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.GreetingService;

@RestController
public class DemoController {

	@Autowired
	GreetingService greetingService;
	
	@RequestMapping(value="/greeting")
	public String getMessage(){
		
		return greetingService.getMessage();
		
	}
}
