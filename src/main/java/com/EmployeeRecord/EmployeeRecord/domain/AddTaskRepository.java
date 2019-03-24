package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddTaskRepository extends CrudRepository<AddTask, Long>{
	List<AddTask> findBytaskName(String taskName);
}
