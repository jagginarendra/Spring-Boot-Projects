package com.boot.rest.controller;

import java.util.Collections;

import javax.validation.ConstraintViolationException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(value = "/violationtest",produces = MediaType.APPLICATION_JSON_VALUE)
	public void violationtest() {
		System.out.println("violationtest()");
		throw new ConstraintViolationException("constaint is violated", Collections.EMPTY_SET);
	}

	@GetMapping(value = "/exceptiontest",produces = MediaType.APPLICATION_JSON_VALUE)
	public void exceptiontest() throws Exception {
		System.out.println("exceptiontest()");
		throw new Exception("genreic exception");
	}

	@GetMapping(value = "/test" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String test(){
		
		System.out.println("test()");
		return "working fine";
	}
	
}
