package com.bjs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	public ResourceServer() {
		System.out.println("ResourceServer()");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.requestMatcher(
				new OrRequestMatcher(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/admin/beans")))
				.authorizeRequests().anyRequest().access("#oauth2.hasScope('read')");

	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("sparklr");
	}

}
