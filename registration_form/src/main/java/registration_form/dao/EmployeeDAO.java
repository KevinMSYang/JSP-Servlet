package registration_form.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import registration_form.model.Employee;

public class EmployeeDAO 
{
    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO account" +
            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf8", "root", "null");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, employee.getFirstname());
            preparedStatement.setString(3, employee.getFirstname());
            preparedStatement.setString(4, employee.getUsername());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getAddress());
            preparedStatement.setString(7, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
}
