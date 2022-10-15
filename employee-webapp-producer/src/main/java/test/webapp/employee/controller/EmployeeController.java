package test.webapp.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import test.webapp.employee.model.Employee;
import test.webapp.employee.resources.Path;
import test.webapp.employee.services.EmployeeProducerService;

@RestController
public class EmployeeController {

	private EmployeeProducerService employeeService;

	@Autowired // constructor autowiring
	public EmployeeController(@Qualifier(Path.EMPLOYEE_SERVICE) EmployeeProducerService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value=Path.EMPLOYEE_URL,
			consumes={"application/json"}, produces = {"application/json"})
	public void getEmployees() {
		employeeService.readAll();
	}

	@GetMapping(value=Path.EMPLOYEE_URL + Path.EMPLOYEE_PATH_VARIABLE,
			consumes={"application/json"}, produces = {"application/json"})
	// @PathVariable necessary for wiring
	public void getEmployeeById(@PathVariable int employeeId) {
		employeeService.readOne(employeeId);
	}

	@PostMapping(value=Path.EMPLOYEE_URL,
			consumes={"application/json"}, produces = {"application/json"})
	// @RequestBody necessary for wiring
	// consumes json
	public void addEmployee(@RequestBody @Valid Employee employee) {
		employeeService.create(employee);
	}

	@PutMapping(value=Path.EMPLOYEE_URL,
			consumes={"application/json"}, produces = {"application/json"})
	// consumes json
	public void updateEmployee(@RequestBody @Valid Employee employee) {
		employeeService.update(employee);
	}

	@DeleteMapping(value=Path.EMPLOYEE_URL + Path.EMPLOYEE_PATH_VARIABLE,
			consumes={"application/json"}, produces = {"application/json"})
	public void deleteEmployeeById(@PathVariable int employeeId) {
		employeeService.delete(employeeId);
	}
}
