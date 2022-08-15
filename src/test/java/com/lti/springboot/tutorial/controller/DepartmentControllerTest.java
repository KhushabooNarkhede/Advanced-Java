package com.lti.springboot.tutorial.controller;
/*l
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.springboot.tutorial.entity.Department;
import com.lti.springboot.tutorial.services.DepartmentService;

//JUnit class or its parent class is annotated with @RunWith, JUnit framework invokes the specified class as a test runner instead of running the default runner. 
//@WebMvcTest annotation is used for Spring MVC tests. It disables full auto-configuration and instead apply only configuration relevant to MVC tests. The WebMvcTest annotation auto-configure MockMvc instance as well.
@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartmentController.class, secure = false)
public class DepartmentControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

//We can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
    @MockBean
    private DepartmentService departmentService;
    
    @Test
	 public void fetchDepartmentList() throws Exception{
    	 String URI = "/departments/fetchDepartmentList";
    	 Department department = new Department();
	 		department.setDepartmentId(2L);
	 		department.setDepartmentName("CE");
	 		department.setDepartmentAddress("Delhi");
	 		department.setDepartmentCode("CE-01");
	 		
	 		Department department1 = new Department();
	 		department1.setDepartmentId(3L);
	 		department1.setDepartmentName("HR");
	 		department1.setDepartmentAddress("Nashik");
	 		department1.setDepartmentCode("HR-1");
	 		
    
		    List<Department> dept = new ArrayList<>();
		    dept.add(department);
		    dept.add(department1);
		
		    String jsonInput = this.converttoJson(dept);
		
		    Mockito.when(departmentService.fetchDepartmentList()).thenReturn(dept);
		    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		    String jsonOutput = mockHttpServletResponse.getContentAsString();
		
		    assertThat(jsonInput).isEqualTo(jsonOutput);
    }

	private String converttoJson(List<Department> dept)throws JsonProcessingException {
		  ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(dept);
	}
	
}
*/
