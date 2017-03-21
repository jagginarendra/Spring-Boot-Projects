/**
 * 
 */
package com.bjs;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BJsUtils {

	public static ResponseEntity<HashMap> sendHTTPWCSRequest(String url, JSONObject requestPayload) {

		ResponseEntity<HashMap> response = null;
		Map<String, String> errorMessage = null;

		// Create Request Factory
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClients.createDefault());

		// Set Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate(requestFactory);
		System.out.println("REQUEST" + requestPayload.toString());
		try {
			// Invoke REST API
			response = restTemplate.exchange(new URI(url), HttpMethod.POST,
					new HttpEntity<String>(requestPayload.toString(), headers), HashMap.class);

			
		} catch (RestClientException e) {
			System.out.println("REST CLIENT Exp");
			e.printStackTrace();
			errorMessage.put("error", e.getMessage());
		} catch (URISyntaxException e) {
			System.out.println("URI Exp");
			e.printStackTrace();
			errorMessage.put("error", e.getMessage());
		}
		return response;
	}
}
