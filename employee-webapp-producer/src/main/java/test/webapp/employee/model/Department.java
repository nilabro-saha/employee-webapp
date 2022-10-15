package test.webapp.employee.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Department extends ModelEntity {
	
	@Positive(message="Department ID must be positive")
	private int id;
	
	@NotBlank(message="Department name cannot be blank")
	private String name;
	
	@Positive(message="Manager ID must be positive")
	@NotNull
	private int managerId;
	
	@Positive(message="Location ID must be positive")
	@NotNull
	private int locationId;
	
	public Department() {
		
	}
	
	public Department(int id, String name, int managerId, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", managerId=" + managerId + ", locationId=" + locationId
				+ "]";
	}
	
}
