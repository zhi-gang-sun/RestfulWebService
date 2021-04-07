package com.ibm.cio.dsw.webservices.restfulwebservice.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@RequestMapping("/filter")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
}
