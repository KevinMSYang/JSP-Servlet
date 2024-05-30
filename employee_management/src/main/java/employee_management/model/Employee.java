package employee_management.model;

public class Employee 
{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String department;
	
	public Employee(int id, String name, String email, String phone, String department) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}
	
	public Employee(String name, String email, String phone, String department) 
	{
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
