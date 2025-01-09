package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        Connection connection = null; // Declare connection variable outside try block for later closing
        try {
            // Try establishing a database connection
            connection = DatabaseConnection.getConnection();
            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the connection in the finally block to ensure it is closed even in case of an error
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing the connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
