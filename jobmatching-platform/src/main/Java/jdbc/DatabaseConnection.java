package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/yourdb?serverTimezone=UTC"; // Add serverTimezone for MySQL 8
    private static final String USER = "root"; // Replace with your DB username
    private static final String PASSWORD = "niteshanalyst001@"; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        try {
            // Load JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection and return it
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle the case where the driver is not found
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            // Handle SQL errors
            e.printStackTrace();
            throw new SQLException("Database connection error: " + e.getMessage());
        }
    }
}
