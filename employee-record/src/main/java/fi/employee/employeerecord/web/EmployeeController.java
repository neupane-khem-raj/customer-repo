package fi.employee.employeerecord.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.employee.employeerecord.domain.DepartmentRepository;
import fi.employee.employeerecord.domain.Employee;
import fi.employee.employeerecord.domain.EmployeeRepository;


@Controller
public class EmployeeController {

@Autowired
private EmployeeRepository employeerepository;
@Autowired
private DepartmentRepository departmentrepository;

//Show all books
@RequestMapping(value="/login")
public String login() {	
    return "login";
}

// Add new book
//@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/add")
public String addEmployee(Model model){
	model.addAttribute("employee", new Employee());
	model.addAttribute("department", departmentrepository.findAll());
    return "addemployee";
}
  

@RequestMapping(value ="/employeelist")
	public String employeeStore(Model model) {
	model.addAttribute("employees", employeerepository.findAll());
		return "employeelist";
	}
//For Restful Api creation:
@RequestMapping(value="/employees", method = RequestMethod.GET)
public @ResponseBody List<Employee> employeeListRest(){
	return (List<Employee>) employeerepository.findAll();
}
//For Restful Api creation to get books by ids
@RequestMapping(value="/employee/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Employee> findEmployeeRest(@PathVariable("id") Long employeeId){
	return employeerepository.findById(employeeId);
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Employee employee){
	employeerepository.save(employee);
    return "redirect:/employeelist";
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteEmployee(@PathVariable("id") Long bookId, Model model) {
	employeerepository.deleteById(bookId);
    return "redirect:../booklist";
}
// updating books

@RequestMapping(value = "/edit/{id}")
public String updateEmployee(@PathVariable("id") Long employeeId, Model model){
model.addAttribute("employee", employeerepository.findById(employeeId));
model.addAttribute("department", departmentrepository.findAll());

return "editemployee";
}

}