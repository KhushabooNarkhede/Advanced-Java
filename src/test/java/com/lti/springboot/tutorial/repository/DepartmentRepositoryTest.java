package com.lti.springboot.tutorial.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.springboot.tutorial.entity.Department;

//@DataJpaTest is used to test JPA repositories. It is used in combination with @RunWith(SpringRunner. class) 
@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
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
	 		
	 		//Save into in memory database
	 		 testEntityManager.persist(department);
	         testEntityManager.persist(department1);

	         //Retrieve all tickets
	         List<Department> dept = (List<Department>) departmentRepository.findAll();

	         Assert.assertEquals(2, dept.size());
	 }

}
