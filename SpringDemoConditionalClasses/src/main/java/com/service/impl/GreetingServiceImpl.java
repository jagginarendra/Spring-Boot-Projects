package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.GreetingDAO;
import com.service.GreetingService;

@Component
public class GreetingServiceImpl implements GreetingService{

	@Autowired
	private GreetingDAO greetingDAO;
	
	@Override
	public String getMessage() {
		
		return greetingDAO.getMessage();
	}

}
