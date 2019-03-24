package fi.employee.employeerecord.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.employee.employeerecord.domain.AddTaskRepository;
import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository emprepository;
	@Autowired
	private DepartmentRepository drepository; 
	@Autowired
	private AddTaskRepository addtaskrepository; 

	   @RequestMapping(value="/employeeList")
	    public String employeeListForm(Model model) {
	        model.addAttribute("employeelists", emprepository.findAll());
	        return "employeeList";
	    }
	    @RequestMapping(value = "/addEmployee")
	    public String addStudent(Model model){
	    	model.addAttribute("employee", new Employee());
	    	model.addAttribute("departments", drepository.findAll());
	    	model.addAttribute("addtasks", addtaskrepository.findAll());
	        return "addEmployee";
	    }
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Employee employee){
	    	emprepository.save(employee);
	        return "redirect:employeeList";
	    }

	  /*  @RequestMapping(value="/employeeList", method=RequestMethod.POST)
	    public String replyReceived(@ModelAttribute Employee emp, Model model) {
	        model.addAttribute("employeeList", emp);
	        return "employeeList";
	    }*/

}
