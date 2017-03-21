package com.bjs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer {

	public CustomTokenEnhancer() {
		System.out.println("CustomTokenEnhancer()");
	}

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		System.out.println("Custom Token Enhancer Initialized");

		WCSResponse wcsResponse = (WCSResponse) authentication.getPrincipal();
		authentication.getOAuth2Request().getRequestParameters();

		final Map<String, Object> additionalInfo = new HashMap<>();
		
		additionalInfo.put("wcsResponse", wcsResponse);

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

		return accessToken;
	}

}
