package fi.employee.employeerecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.employee.employeerecord.domain.Department;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;
import fi.employee.employeerecord.domain.User;
import fi.employee.employeerecord.domain.UserRepository;

@SpringBootApplication
public class EmployeeRecordApplication {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRecordApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(EmployeeRepository emprepo, DepartmentRepository deprepo, UserRepository usr) {
		
		return (args) -> {
			//log.info("saving hard-coded book objects");
			
			deprepo.save(new Department("IT"));
			deprepo.save(new Department("Programming"));
			deprepo.save(new Department("Romance"));
			deprepo.save(new Department("Science"));
			emprepo.save(new Employee("Mybook","Myauthor","Mydate","MyISBN","MyPrice", deprepo.findByName("Science").get(0)));
			emprepo.save(new Employee("HisBook","HisAuthor","HisDate","HisISBN","HisPrice", deprepo.findByName("Programming").get(0)));
			emprepo.save(new Employee("Zbook","Zauthor","Zdate","zISBN","Zprice", deprepo.findByName("Romance").get(0)));
			emprepo.save(new Employee("Abook","Aauthor","Adate","aISBN","Aprice", deprepo.findByName("Science").get(0)));
			
			//Create users: admin/admin user/user
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
						usr.save(user1);
						usr.save(user2);
		
			
			log.info("getting all employees");
			for (Employee employee : emprepo.findAll()) {
				log.info(employee.toString());
			}

		};
	}

}
