package test.webapp.employee.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Employee extends ModelEntity{
	
	@Positive(message="Employee ID must be positive")
	private int id;
	
	@NotBlank(message="First name cannot be blank")
	private String firstName;
	
	@NotBlank(message="Last name cannot be blank")
	private String lastName;
	
	@Email(message="Invalid email")
	private String email;
	
	@Min(value=5000, message="Salary must be greater than 5000")
	private double salary;
	
	//@ForeignKey
	@Positive(message="Department ID must be positive")
	@NotNull
	private int departmentId;
	
	@Positive(message="Manager ID must be positive")
	private int managerId;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, String email, double salary, int departmentId,
			int managerId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.departmentId = departmentId;
		this.managerId = managerId;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + ", departmentId=" + departmentId + ", managerId=" + managerId + "]";
	}
	
	
}
