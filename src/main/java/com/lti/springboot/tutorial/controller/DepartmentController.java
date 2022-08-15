//Controller class contains public methods called Action methods. Controller and its action method handles incoming browser requests, retrieves necessary model data and returns appropriate responses.
package com.lti.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.springboot.tutorial.entity.Department;
import com.lti.springboot.tutorial.services.DepartmentService;

import error.DepartmentNotFoundException;

@RestController
//@RestController is a specialized version of the controller.It includes the @Controller and @ResponseBody annotations,Every request handling method of the controller class automatically serializes return objects into HttpResponse.
public class DepartmentController {
	
	//The @Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished.
	//The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism 
	@Autowired
	private DepartmentService departmentService;
	
	//What are loggers in spring boot? -->logging use for generate logs of application (if we got error hence u can trace it )
	//Spring Boot uses Commons Logging for all internal logging but leaves the underlying log implementation open.
	//The purpose of logging is to create an ongoing record of application events. Log files can be used to review any event within a system, including failures and state transformations. Consequently, log messages can provide valuable information to help pinpoint the cause of performance problems.
	private final Logger log =
	            LoggerFactory.getLogger(DepartmentController.class);
		
		
	//@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST) .@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
	//@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object. Spring automatically deserializes the JSON into a Java type, assuming an appropriate one is specified.
	//The @Valid annotation is a key feature of Bean Validation, as it allows to validate object graphs with a single call to the validator. To make use of it all fields that should be recursively checked should be annotated with @Valid
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	//The @GetMapping annotation is a specialized version of @RequestMapping annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	//The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression.
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		log.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	//@PathVariable annotation is used to extract the value of the template variables and assign their value to a method variable
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	//The DELETE HTTP method is used to delete the resource and @DeleteMapping annotation maps the HTTP DELETE requests onto specific handler methods of a Spring controller.
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department delete Successfully..!!";
	}
	
	//Annotation for mapping HTTP PUT requests onto specific handler methods.
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
		
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
