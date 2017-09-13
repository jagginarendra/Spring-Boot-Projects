package com.dao.elastic.impl;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.dao.GreetingDAO;
import com.search.config.EnableElasticSearchConfig;

@Component
@Conditional(EnableElasticSearchConfig.class)
public class ElasticGreetingDAOImpl implements GreetingDAO{

	@Override
	public String getMessage() {
		
		return "Hi from Elastic Search";
	}

}
