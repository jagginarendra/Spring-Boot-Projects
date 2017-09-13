package com.dao.solr.impl;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.dao.GreetingDAO;
import com.search.config.EnableSolrConfig;

@Component
@Conditional(EnableSolrConfig.class)
public class SolrGreetingDAOImpl implements GreetingDAO {

	@Override
	public String getMessage() {
		
		return "Hi from Solr";
	}

}
