package com.ibm.cio.dsw.webservices.restfulwebservice;

public class HelloBean {
	private String message;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public HelloBean(String message) {
		super();
		this.message = message;
		this.name = "";
	}

	public HelloBean(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}
	
	

}
