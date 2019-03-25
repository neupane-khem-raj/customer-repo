package fi.employee.employeerecord.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddTask {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long addtaskid;
	private String taskName;
	private String date;
	private int budget;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addtask")
	private List<Employee>employee;
	
	public AddTask() {}
	

	public AddTask(String taskName, String date, int budget) {
		super();
		this.taskName = taskName;
		this.date = date;
		this.budget = budget;
	}


	public Long getAddtaskid() {
		return addtaskid;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getDate() {
		return date;
	}

	public int getBudget() {
		return budget;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setAddtaskid(Long addtaskid) {
		this.addtaskid = addtaskid;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AddTask [addtaskid=" + addtaskid + ", taskName=" + taskName + ", date=" + date + ", budget=" + budget
				+ "]";
	}


}