package test.webapp.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import test.webapp.employee.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
}
