package test.webapp.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import test.webapp.employee.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
