package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long departmentid;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee>employee;

	public Department() {
		super();
	}
	

	public Department(String name) {
		super();
		this.name = name;
	}


	public Long getDepartmentid() {
		return departmentid;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	

}
