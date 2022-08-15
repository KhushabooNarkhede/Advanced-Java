//which can be used as a mechanism for encapsulating storage, retrieval, and search behavior which emulates 
//a collection of objects
//persistence logic
package com.lti.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.springboot.tutorial.entity.Department;

import error.DepartmentNotFoundException;

//@Repository Annotation is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects.
//JpaRepository is a JPA (Java Persistence API) specific extension of Repository.It contains the full API of CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and also API for pagination and sorting.
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
	public Department findOne(Long departmentId);

	public void delete(Long departmentId);

	public Department findOne(long departmentId) throws DepartmentNotFoundException;// for testing purpose
	
}
