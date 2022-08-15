//write business logic implementation
//one service can have multiple implementation class

package com.lti.springboot.tutorial.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.springboot.tutorial.entity.Department;
import com.lti.springboot.tutorial.repository.DepartmentRepository;

import error.DepartmentNotFoundException;


//Service Components are the class file which contains @Service annotation. 
//These class files are used to write business logic in a different layer, separated from @RestController class file
//The class that implements the Interface with @Service annotation

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = 
				departmentRepository.findById(departmentId);
	 
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		return department.get();
	
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department depDB = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName())&&
		!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode())&&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
					depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress())&&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
					depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(depDB);
		
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}