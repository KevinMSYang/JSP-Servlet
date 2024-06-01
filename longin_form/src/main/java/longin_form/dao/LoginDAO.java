package longin_form.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import login_form.model.Login;

public class LoginDAO 
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf8", "root", "null");
			 PreparedStatement predstate = connect.prepareStatement("SELECT * FROM login WHERE username = ? and password = ?"))
		{
			predstate.setString(1, login.getUsername());
			predstate.setString(2, login.getPassword());
			System.out.println(predstate);
			
			ResultSet rs = (ResultSet) predstate.executeQuery();
			status = rs.next();
		}
		return status;
	}
}
