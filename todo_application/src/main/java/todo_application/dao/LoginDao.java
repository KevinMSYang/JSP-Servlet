package todo_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todo_application.model.LoginBean;
import todo_application.utils.JDBCUtils;

public class LoginDao {
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException, SQLException {
		boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?")) {
			
			preparedStatement.setString(1, loginBean.getUsername());	
			preparedStatement.setString(2, loginBean.getPassword());
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
