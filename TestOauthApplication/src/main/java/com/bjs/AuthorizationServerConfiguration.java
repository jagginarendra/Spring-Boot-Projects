package com.bjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	public AuthorizationServerConfiguration() {
		
		System.out.println("AuthorizationServerConfiguration()");
	}
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		System.out.println("AuthorizationServerConfiguration configure()");
		endpoints.authenticationManager(authenticationManager).tokenEnhancer(tokenEnhancer()).tokenStore(tokenStore());
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		System.out.println("OAUTH CLIENT CONFIGURED in AuthorizationServerConfiguration !!!");
		
		clients.inMemory().withClient("my-trusted-client")
		.authorizedGrantTypes("password", "authorization_code",
				"refresh_token", "implicit")
		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		.scopes("read", "write", "trust").resourceIds("sparklr")
		.accessTokenValiditySeconds(60).
		and()
		.withClient("my-client-with-registered-redirect")
		.authorizedGrantTypes("authorization_code").authorities("ROLE_CLIENT")
		.scopes("read", "trust").resourceIds("sparklr")
		.redirectUris("http://anywhere?key=value").
		and()
		.withClient("my-client-with-secret")
		.authorizedGrantTypes("refresh_token", "password")
		.authorities("ROLE_CLIENT").scopes("read").resourceIds("sparklr").accessTokenValiditySeconds(65)
		.secret("secret");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.checkTokenAccess("isAuthenticated()");
	}

}
