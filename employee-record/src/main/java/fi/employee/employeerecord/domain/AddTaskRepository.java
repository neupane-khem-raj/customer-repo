package fi.employee.employeerecord.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddTaskRepository  extends CrudRepository<AddTask, Long>{
	 List<AddTask> findByTaskname(String taskName);
}
