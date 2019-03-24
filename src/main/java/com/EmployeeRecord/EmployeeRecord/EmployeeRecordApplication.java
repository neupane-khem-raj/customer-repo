package com.EmployeeRecord.EmployeeRecord;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.EmployeeRecord.EmployeeRecord.domain.AddTask;
import com.EmployeeRecord.EmployeeRecord.domain.AddTaskRepository;
import com.EmployeeRecord.EmployeeRecord.domain.Department;
import com.EmployeeRecord.EmployeeRecord.domain.DepartmentRepository;
import com.EmployeeRecord.EmployeeRecord.domain.Employee;
import com.EmployeeRecord.EmployeeRecord.domain.EmployeeRepository;
import com.EmployeeRecord.EmployeeRecord.domain.StartJob;
import com.EmployeeRecord.EmployeeRecord.domain.StartJobRepository;

@SpringBootApplication
public class EmployeeRecordApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRecordApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner employeerepo(EmployeeRepository empr) {
		//, DepartmentRepository dptr,  AddTaskRepository atr, StartJobRepository sjr
		return (args) -> {
			//log.info("saving hard-coded book objects");
			
			empr.save(new Employee("Khem","Neupane",
					"sekharneupane@jpt.com", "444444", new Department("IT"), 
					new StartJob("Programming", "part-time","03-03-2019","no-end-date", 2300),
					new AddTask("Implement Backend", "07-07-2019", 2000)));
		
			
			
			for (Employee employee : empr.findAll()) {
				log.info(employee.toString());
			}

		};
	}
	

}
