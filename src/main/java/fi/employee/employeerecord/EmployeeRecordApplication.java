package fi.employee.employeerecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.employee.employeerecord.domain.AddTask;
import fi.employee.employeerecord.domain.AddTaskRepository;
import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;

@SpringBootApplication
public class EmployeeRecordApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRecordApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordApplication.class, args);
	}

	@Bean
	public CommandLineRunner EmployeeMockupData(EmployeeRepository empr, DepartmentRepository dptr, AddTaskRepository addr) {
		return (args) -> {
			log.info("save a couple of students");
			dptr.save(new Department("IT"));
			dptr.save(new Department("'Finance"));
			dptr.save(new Department("Marketing"));
			addr.save(new AddTask("Marketing","05-04-2019", 4000));
			addr.save(new AddTask("FinancialMeeting","05-08-2019", 5000));
			addr.save(new AddTask("Software Development","05-08-2019", 5000));
			empr.save(new Employee("John", "Johnson", "john@john.com", "99878",dptr.findByName("IT").get(0), addr.findByTaskName("Software Development").get(0)));
			empr.save(new Employee("Katy", "Kateson", "kate@kate.com", "87654",dptr.findByName("Finance").get(0),addr.findByTaskName("FinancialMeeting").get(0)));
			empr.save(new Employee("Katy", "Kateson", "kate@kate.com", "87654",dptr.findByName("Marketing").get(0),addr.findByTaskName("Marketing").get(0)));

			log.info("fetch all students");
			for (Employee employee : empr.findAll()) {
				log.info(employee.toString());
			}

		};
	}

}
