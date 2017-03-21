package com.bjs;

public class WCSResponse {

	private String wcToken;

	private String userID;

	private String wcTrustedToken;

	private String personalizationID;

	private String statusCode;

	private String jSessionCode;

	private String wcPersistent;

	private boolean isWcSessionEstablished;

	public String getWcToken() {
		return wcToken;
	}

	public void setWcToken(String wcToken) {
		this.wcToken = wcToken;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getWcTrustedToken() {
		return wcTrustedToken;
	}

	public void setWcTrustedToken(String wcTrustedToken) {
		this.wcTrustedToken = wcTrustedToken;
	}

	public String getPersonalizationID() {
		return personalizationID;
	}

	public void setPersonalizationID(String personalizationID) {
		this.personalizationID = personalizationID;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getjSessionCode() {
		return jSessionCode;
	}

	public void setjSessionCode(String jSessionCode) {
		this.jSessionCode = jSessionCode;
	}

	public String getWcPersistent() {
		return wcPersistent;
	}

	public void setWcPersistent(String wcPersistent) {
		this.wcPersistent = wcPersistent;
	}

	public boolean isWcSessionEstablished() {
		return isWcSessionEstablished;
	}

	public void setWcSessionEstablished(boolean isWcSessionEstablished) {
		this.isWcSessionEstablished = isWcSessionEstablished;
	}

}
