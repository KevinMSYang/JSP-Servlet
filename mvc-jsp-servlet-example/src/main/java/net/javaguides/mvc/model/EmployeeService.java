package net.javaguides.mvc.model;

import java.util.Arrays;
import java.util.List;

public class EmployeeService 
{
	public List<Employee> getEmployees()
	{
		return Arrays.asList(new Employee(100, "Kevin", "Yang"), 
							 new Employee(101, "Derek", "Yang"), 
							 new Employee(102, "Sherry", "Lian"));	
	}
}
