package test.webapp.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="EMPLOYEES")
public class Employee extends ModelEntity{
	
	@Id
	@Positive(message="Employee ID must be positive")
	@Column(name="EMPLOYEE_ID")
	private int id;
	
	@Column(name="FIRST_NAME")
	@NotBlank(message="First name cannot be blank")
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotBlank(message="Last name cannot be blank")
	private String lastName;
	
	@Column(name="EMAIL")
	@Email(message="Invalid email")
	private String email;
	
	@Column(name="SALARY")
	@Min(value=5000, message="Salary must be greater than 5000")
	private double salary;
	
//	@Column(name="DEPARTMENT_ID")
//	@Positive(message="Department ID must be positive")
//	@NotNull
//	private int departmentId;
	
	@Column(name="MANAGER_ID")
	@Positive(message="Manager ID must be positive")
	private int managerId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DEPARTMENT_ID", referencedColumnName="DEPARTMENT_ID")
	public Department department;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, String email, double salary, Department department,
			int managerId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.managerId = managerId;
	}
	
//	public int getDepartmentId() {
//		return departmentId;
//	}
//	public void setDepartmentId(int departmentId) {
//		this.departmentId = departmentId;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + ", departmentId=" + department + ", managerId=" + managerId + "]";
	}
	
}
