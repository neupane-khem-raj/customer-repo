package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StartJobRepository extends CrudRepository <StartJob, Long>{
	List<StartJob> findAll();

}
