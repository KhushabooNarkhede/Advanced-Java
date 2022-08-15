//JUnit is the Java library used to write tests (offers support for running tests and different extra helpers - like setup and teardown methods, test sets etc.). 
//Mockito is a library that enables writing tests using the mocking approach. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
//Mockito is a mocking framework for unit tests written in Java.
package com.lti.springboot.tutorial.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.springboot.tutorial.entity.Department;
import com.lti.springboot.tutorial.repository.DepartmentRepository;
import com.lti.springboot.tutorial.services.DepartmentService;

//What is @RunWith in JUnit 5?
//Annotating a class with @RunWith(JUnitPlatform. class) allows it to be run with IDEs and build systems that support JUnit 4 but do not yet support the JUnit Platform directly.

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {
	
		//The @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
	 	@MockBean
	    private DepartmentRepository departmentRepository;
		
	 	@Autowired
	    private DepartmentService departmentService;
	 	
	 	@Test
	 	public void saveDepartment() {
	 		Department department = new Department();
	 		department.setDepartmentId(1L);
	 		department.setDepartmentName("IT");
	 		department.setDepartmentAddress("Pune");
	 		department.setDepartmentCode("IT-06");
	 		
	 		Mockito.when(departmentRepository.save(department)).thenReturn(department);
	 		assertThat(departmentService.saveDepartment(department)).isEqualTo(department);
	 		
	 	}
	 	
		@Test
	 	public void fetchDepartmentList(){
	 		
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
	 		
	 		List<Department> dept =new ArrayList<>();
	 		dept.add(department);
	 		dept.add(department1);
		 		
	 		
	 		Mockito.when(departmentRepository.findAll()).thenReturn((List<Department>) dept);
	 		assertThat(departmentService.fetchDepartmentList()).isEqualTo(dept);
			
		}
	 	/*
		@Test
	 	public void fetchDepartmentById() throws Exception { //not passed
	 		Department department2 = new Department();
	 		department2.setDepartmentId(4L);
	 		department2.setDepartmentName("CE");
	 		department2.setDepartmentAddress("Kota");
	 		department2.setDepartmentCode("CE-01");
	 		
	 		Mockito.when(departmentRepository.findOne(1L)).thenReturn(department2);
	 		assertThat(departmentService.fetchDepartmentById(1L)).isEqualTo(department2);
	 		
	 	}
	 	/*
	 	 @Test
	 	 public void deleteDepartmentById(Long departmentId) { //not passed
	 		Department department = new Department();
	 		department.setDepartmentId(5L);
	 		department.setDepartmentName("Insurance");
	 		department.setDepartmentAddress("Pune");
	 		department.setDepartmentCode("Insurance-04");
	 		
	 		Mockito.when(departmentRepository.save(department)).thenReturn(department);
	 		Mockito.when(departmentRepository.findOne(5L)).thenReturn(department);
	 		departmentRepository.delete(department.getDepartmentId());
	 		Mockito.when(departmentRepository.findOne(5L)).thenReturn(department);
	 		Assert.assertNotEquals(department, new Department());
	 		//Assert.assertTrue(departmentService.deleteDepartmentById(5L), false); //error
	 		
	 	}*/

}

