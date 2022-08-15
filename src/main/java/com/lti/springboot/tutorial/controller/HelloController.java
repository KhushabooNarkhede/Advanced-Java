package com.lti.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

////@RestController is a specialized version of the controller. 
//It includes the @Controller and @ResponseBody annotations,
//Every request handling method of the controller class automatically serializes return objects into HttpResponse.

@RestController
public class HelloController {
	
	//@Value("${welcome.message}")
	private String welcomeMessage;
	
    //The @GetMapping annotation is a specialized version of @RequestMapping annotation that acts as a shortcut for 
	//@RequestMapping(method = RequestMethod.GET).
    //The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression.
	
	@GetMapping("/")
	public String helloworld() {
		return welcomeMessage;
	}

}
