package employee_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employee_management.model.Employee;


public class EmployeeDAO 
{
	private String jdbcURL = "jdbc:mysql://localhost:3306/company?characterEncoding=utf8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "null";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO employee" + "  (name, email, phone, department) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_USERS_BY_ID = "SELECT id, name, email, phone, department FROM employee WHERE id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM employee;";
	private static final String DELETE_USERS_SQL = "DELETE FROM employee WHERE id = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE employee SET name = ?, email = ?, phone = ?, department = ? WHERE id = ?;";
	
	protected Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Connection connect = null;
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		return connect;
	}
	
	// Create or insert users
	public void insertUser(Employee user) throws SQLException
	{
		try (Connection connect = getConnection();
				PreparedStatement predstate = connect.prepareStatement(INSERT_USERS_SQL);)
		{
			predstate.setString(1, user.getName());
			predstate.setString(2, user.getEmail());
			predstate.setString(3, user.getPhone());
			predstate.setString(4, user.getDepartment());
			predstate.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Update users
	public boolean updateUser(Employee user) throws SQLException, ClassNotFoundException
	{
		boolean rowUpdated;
		try (Connection connect = getConnection();
				PreparedStatement predstate = connect.prepareStatement(UPDATE_USERS_SQL);)
		{
			predstate.setString(1, user.getName());
			predstate.setString(2, user.getEmail());
			predstate.setString(3, user.getPhone());
			predstate.setString(4, user.getDepartment());
			predstate.setInt(5, user.getId());
			
			rowUpdated = predstate.execute(); 
		} 
		return rowUpdated;
	}
	
	// Select users by id 
	public Employee selectUser(int id) throws ClassNotFoundException
	{
		Employee user = null;
		// Setp 1: Establising a Connection
		try (Connection connect = getConnection();
				// Step 2: Create a statement using connection object
				PreparedStatement predstate = connect.prepareStatement(SELECT_USERS_BY_ID);)
		{
			predstate.setInt(1, id);
			System.out.println(predstate);
			// Step 3: Execute the query or update query
			ResultSet rs = predstate.executeQuery();
			
			// Step 4: Process the ResultSet object
			while (rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String department = rs.getString("department");
				user = new Employee(id, name, email, phone, department);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	// Select users
	public List<Employee> selectAllUser() throws ClassNotFoundException
	{
		List<Employee> users = new ArrayList<>();
		// Setp 1: Establising a Connection
		try (Connection connect = getConnection();
				// Step 2: Create a statement using connection object
				PreparedStatement predstate = connect.prepareStatement(SELECT_ALL_USERS);)
		{
			System.out.println(predstate);
			// Step 3: Execute the query or update query
			ResultSet rs = predstate.executeQuery();
			
			// Step 4: Process the ResultSet object
			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String department = rs.getString("department");
				users.add(new Employee(id, name, email, phone, department));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	// Delete users
	public boolean deleteUser(int id) throws SQLException, ClassNotFoundException
	{
		boolean rowDeleted;
		try (Connection connect = getConnection();
				PreparedStatement predstate = connect.prepareStatement(DELETE_USERS_SQL);)
		{
			predstate.setInt(1, id);
			rowDeleted = predstate.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
