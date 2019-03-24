package com.EmployeeRecord.EmployeeRecord.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StartJob {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long startjobid;
	private String jobTitle;
	private String employmentType;
	private String joinDate;
	private String endDate;
	private int initialSalary;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "startjob")
	private List<Employee>employee;
	
	public StartJob() {
		super();
	}
	

	public StartJob(String jobTitle, String employmentType, String joinDate, String endDate,
			int initialSalary) {
		super();
		
		this.jobTitle = jobTitle;
		this.employmentType = employmentType;
		this.joinDate = joinDate;
		this.endDate = endDate;
		this.initialSalary = initialSalary;
	}


	public Long getStartjobid() {
		return startjobid;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getInitialSalary() {
		return initialSalary;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setStartjobid(Long startjobid) {
		this.startjobid = startjobid;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setInitialSalary(int initialSalary) {
		this.initialSalary = initialSalary;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "StartJob [startjobid=" + startjobid + ", jobTitle=" + jobTitle + ", employmentType=" + employmentType
				+ ", joinDate=" + joinDate + ", endDate=" + endDate + ", initialSalary=" + initialSalary + ", employee="
				+ employee + "]";
	}
	
	

}
