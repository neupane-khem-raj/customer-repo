package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long>{
	List<Employee> findByfirstName(String firstName);

}
