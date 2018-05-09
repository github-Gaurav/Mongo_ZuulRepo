package crudApp.crudDemo.model;

import java.util.ArrayList;
import java.util.List;
import crudApp.crudDemo.entity.User;

public class Response {
	
	private String statusCode;
	private String statusMessage;
	private List<User> userData = new ArrayList();
	
	
	public Response(String statusCode, String statusMessage, List<User> userData) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.userData = userData;
	}


	public Response(String statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


	public List<User> getUserData() {
		return userData;
	}


	public void setUserData(List<User> userData) {
		this.userData = userData;
	}
	
}
