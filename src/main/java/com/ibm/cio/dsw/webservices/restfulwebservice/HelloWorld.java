package com.ibm.cio.dsw.webservices.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/helloBean")
	public HelloBean helloBean() {
		return new HelloBean("Hello Bean!", "Owen");
	}
	
	@GetMapping("/helloVar/{name}")
	public HelloBean helloVar(@PathVariable String name) {
		return new HelloBean(String.format("Hello Bean, %s", name));
	}
	

}
