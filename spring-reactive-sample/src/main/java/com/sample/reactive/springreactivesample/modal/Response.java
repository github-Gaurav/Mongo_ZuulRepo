package com.sample.reactive.springreactivesample.modal;

import java.util.ArrayList;
import java.util.List;

/**
 * Pojo class for the response.
 * @author ampandey
 *
 */
public class Response {
	private String statusCode;
	private String message;
	
	private List<PersonEntity> list=new ArrayList();;

	public Response(){
		
	}
	
	public Response(String statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public Response(String statusCode, String message,List<PersonEntity> list) {
		this.statusCode = statusCode;
		this.message = message;
		this.list=list;
		}
	
	public Response(String statusCode, String message,PersonEntity entity) {
		this.statusCode = statusCode;
		this.message = message;
		list.add(entity);	
		}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	public List<PersonEntity> getList() {
		return list;
	}

	public void setList(List<PersonEntity> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", message=" + message + ", Data=" + list + "]";
	}
	
	
}
