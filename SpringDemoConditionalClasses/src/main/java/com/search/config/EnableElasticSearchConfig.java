package com.search.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnableElasticSearchConfig implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Environment env = context.getEnvironment();
		
		return null != env && "elasticsearch".equals(env.getProperty("SEARCHSOURCE")) ;
	}

}
