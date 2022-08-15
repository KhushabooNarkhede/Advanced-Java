//Using Interfaces allows your classes to extend from some other classes if required. 
//Your Interfaces can have multiple implementations and you can switch between any of them without changing the client code.
//a service is defined by a set of interfaces and classes. 
//The service contains an interface or an abstract class that defines the functionality provided by the service.
//Business logic

package com.lti.springboot.tutorial.services;

import java.util.List;

import com.lti.springboot.tutorial.entity.Department;

import error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException ;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
