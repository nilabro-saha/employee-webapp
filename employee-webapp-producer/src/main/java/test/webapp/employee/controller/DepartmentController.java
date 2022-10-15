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
import test.webapp.employee.model.Department;
import test.webapp.employee.resources.Path;
import test.webapp.employee.services.DepartmentProducerService;

@RestController
public class DepartmentController {

	private DepartmentProducerService departmentProducerService;

	@Autowired
	public DepartmentController(
			@Qualifier(Path.DEPARTMENT_SERVICE) DepartmentProducerService DepartmentProducerService) {
		this.departmentProducerService = DepartmentProducerService;
	}

	@GetMapping(value=Path.DEPARTMENT_URL, 
			consumes={"application/json"}, produces = {"application/json"})
	public void getDepartments() {
		departmentProducerService.readAll();
	}

	@GetMapping(value=Path.DEPARTMENT_URL + Path.DEPARTMENT_PATH_VARIABLE, 
			consumes={"application/json"}, produces = {"application/json"})
	// @PathVariable necessary for wiring
	public void getDepartmentById(@PathVariable int departmentId) {
		departmentProducerService.readOne(departmentId);
	}

	@PostMapping(value=Path.DEPARTMENT_URL, 
			consumes={"application/json"}, produces = {"application/json"})
	// @RequestBody necessary for wiring
	// consumes json
	public void addDepartment(@RequestBody @Valid Department department) {
		departmentProducerService.create(department);
	}

	@PutMapping(value=Path.DEPARTMENT_URL, 
			consumes={"application/json"}, produces = {"application/json"})
	// consumes json
	public void updateDepartment(@RequestBody @Valid Department department) {
		departmentProducerService.update(department);
	}

	@DeleteMapping(value=Path.DEPARTMENT_URL + Path.DEPARTMENT_PATH_VARIABLE, 
			consumes={"application/json"}, produces = {"application/json"})
	public void deleteDepartmentById(@PathVariable int departmentId) {
		departmentProducerService.delete(departmentId);
	}
}
