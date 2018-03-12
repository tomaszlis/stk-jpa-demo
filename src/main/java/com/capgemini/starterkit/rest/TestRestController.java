package com.capgemini.starterkit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRestController {

	@RequestMapping("/test")
	public String runForTest() {
		return "Tu coś będzie";
	}

}
