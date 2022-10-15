package test.webapp.employee.resources;

public interface Path {
	
	public static final String DEPARTMENT_URL = "/departments";
	public static final String DEPARTMENT_PATH_VARIABLE = "/{departmentId}";
	public static final String DEPARTMENT_SERVICE = "departmentService";
	
	public static final String EMPLOYEE_URL = "/employees";
	public static final String EMPLOYEE_PATH_VARIABLE = "/{employeeId}";
	public static final String EMPLOYEE_SERVICE = "employeeService";
	
}
