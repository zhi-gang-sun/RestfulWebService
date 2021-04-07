package com.ibm.cio.dsw.webservices.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	/**
	 * the first versioning approach: URI
	 * @return
	 */
	@GetMapping("v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Owen Sun");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Owen", "Sun"));
	}
	
	/**
	 * the second approach: request parameter
	 * @return
	 */
	
	@GetMapping(value="/person", params = "version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Owen Sun");
	}
	
	@GetMapping(value="/person", params = "version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Owen", "Sun"));
	}
	
	/**
	 * the third approach: header parameter
	 */
	@GetMapping(value="/person", headers = "version=1")
	public PersonV1 headerv1() {
		return new PersonV1("Owen Sun");
	}
	
	@GetMapping(value="/person", headers = "version=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Owen", "Sun"));
	}
	
}
