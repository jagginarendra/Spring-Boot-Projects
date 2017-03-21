package com.bjs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;

public class BJsCustomAuthentication implements AuthenticationProvider {

	public BJsCustomAuthentication() {
		System.out.println("BJsCustomAuthentication()");
	}

	@CrossOrigin(origins = "*")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		// to get request details from angular request
		System.out.println("principal=" + authentication.getDetails());

		System.out.println("BJsCustomAuthentication authenticate()");

		if ("jagginarendra".equalsIgnoreCase(username)) {

			Map<String, String> userDetails = new HashMap<String, String>();
			userDetails.put("logonId", username);
			userDetails.put("logonPassword", password);

			JSONObject requestPayload1 = new JSONObject(userDetails);
			ResponseEntity<HashMap> response = BJsUtils.sendHTTPWCSRequest(
					"https://localhost:8000/wcs/resources/store/10201/loginidentity?updateCookies=true",
					requestPayload1);

			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("USER"));

			WCSResponse wcsResponse = new WCSResponse();

			System.out.println("response=" + response);

			HashMap<String, String> responseBody = response.getBody();
			System.out.println("responseBody=" + responseBody);

			wcsResponse.setPersonalizationID(responseBody.get("personalizationID"));
			wcsResponse.setUserID(responseBody.get("userId"));
			wcsResponse.setWcToken(responseBody.get("WCToken"));
			wcsResponse.setWcTrustedToken(responseBody.get("WCTrustedToken"));

			/*
			 * String httpStatusCode = response.getStatusCode().toString();
			 * System.out.println("httpStatusCode="+ httpStatusCode);
			 * org.springframework.http.HttpHeaders httpHeader =
			 * response.getHeaders(); System.out.println("httpHeader="+
			 * httpHeader);
			 */

			System.out.println("calling authentication.getCredentials()");

			return new UsernamePasswordAuthenticationToken(wcsResponse, authentication.getCredentials(), grantedAuths);

		} else if ("bill".equalsIgnoreCase(username) && "abc123".equalsIgnoreCase(password)) {

			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));

			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
					grantedAuths);

		} else {
			throw new BadCredentialsException("User not found by given credentails");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.AuthenticationProvider#
	 * supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
		// return false;
	}

	/*
	 * public static ResponseEntity<HashMap> sendHTTPWCSRequest(String url,
	 * JSONObject requestPayload) {
	 * 
	 * ResponseEntity<HashMap> response = null; Map<String, String> errorMessage
	 * = null;
	 * 
	 * // Create Request Factory ClientHttpRequestFactory requestFactory = new
	 * HttpComponentsClientHttpRequestFactory( HttpClients.createDefault());
	 * 
	 * // Set Headers HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * 
	 * RestTemplate restTemplate = new RestTemplate(requestFactory);
	 * System.out.println("REQUEST"+requestPayload.toString());
	 * 
	 * try { // Invoke REST API response = restTemplate.exchange(new URI(url),
	 * HttpMethod.POST, new HttpEntity<String>(requestPayload.toString(),
	 * headers), HashMap.class);
	 * 
	 * System.out.println("RESPONSE"+response.toString());
	 * 
	 * } catch (RestClientException e) { System.out.println("REST CLIENT Exp");
	 * e.printStackTrace(); errorMessage.put("error", e.getMessage()); } catch
	 * (URISyntaxException e) { System.out.println("URI Exp");
	 * e.printStackTrace(); errorMessage.put("error", e.getMessage()); } return
	 * response; }
	 */

}
