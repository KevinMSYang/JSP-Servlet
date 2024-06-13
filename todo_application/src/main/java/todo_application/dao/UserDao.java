package todo_application.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import todo_application.model.User;

public class UserDao {
	public int registerEmployee(User employee) throws ClassNotFoundException, SQLException {
		String INSERT_USERS_SQL = "INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?);";
		
		int result = 0;
		try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?characterEncoding=utf8", "root", "null"); 
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		}
		return result;
	}
}
