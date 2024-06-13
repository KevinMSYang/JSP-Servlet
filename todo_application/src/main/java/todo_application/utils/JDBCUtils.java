package todo_application.utils;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

public class JDBCUtils {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/todolist";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "null";
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}
	
	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}
}
