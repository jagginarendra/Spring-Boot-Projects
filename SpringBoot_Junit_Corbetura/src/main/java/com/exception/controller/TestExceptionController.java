package com.exception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.model.Inventory;
import com.exception.service.RogersService;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/v1/")
public class TestExceptionController {

	@Autowired
	RogersService service;

	@RequestMapping("/testexception/{input}")
	public Inventory getRequestForExceptionTest(@PathVariable String input) {

		if (input != null && input.trim().length() > 0)

			return service.getMessage(input);

		else

			return null;

	}

}
