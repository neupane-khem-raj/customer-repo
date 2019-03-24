package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "departmentid")
	private Department department;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "startjobid")
	private StartJob startjob;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "addtaskid")
	private AddTask addtask;
	
	public Employee() {
		super();
	}
	

	public Employee(String firstName, String lastName, String email, String phone, Department department,
			StartJob startjob, AddTask addtask) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.startjob = startjob;
		this.addtask = addtask;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public StartJob getStartjob() {
		return startjob;
	}

	public void setStartjob(StartJob startjob) {
		this.startjob = startjob;
	}

	public AddTask getAddtask() {
		return addtask;
	}

	public void setAddtask(AddTask addtask) {
		this.addtask = addtask;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", department=" + department + ", startjob=" + startjob + ", addtask=" + addtask
				+ "]";
	}
	

}
