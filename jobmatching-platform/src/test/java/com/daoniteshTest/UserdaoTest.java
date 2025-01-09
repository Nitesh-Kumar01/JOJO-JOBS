package com.daoniteshTest;

import daonitesh.UserDAO;
import model.User;
import org.junit.jupiter.api.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private Connection connection;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() throws Exception {
        // Setup an in-memory H2 database connection
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        userDAO = new UserDAO(connection);

        // Create the Users table in the in-memory database
        String createTableQuery = "CREATE TABLE Users (" +
                                  "id INT AUTO_INCREMENT, " +
                                  "name VARCHAR(255), " +
                                  "email VARCHAR(255), " +
                                  "password VARCHAR(255), " +
                                  "role VARCHAR(255), " +
                                  "PRIMARY KEY (id))";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableQuery);
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        // Drop the Users table after each test to clean up
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS Users");
        }
    }

    @Test
    void testAddUser() {
        User user = new User(1, "John Doe", "john@example.com", "password123", "admin");
        boolean result = userDAO.addUser(user);
        assertTrue(result, "User should be added successfully.");
    }

    @Test
    void testGetUserByEmail() {
        User user = new User(2, "Jane Doe", "jane@example.com", "password123", "user");
        userDAO.addUser(user);

        User retrievedUser = userDAO.getUserByEmail("jane@example.com");
        assertNotNull(retrievedUser, "User should be found.");
        assertEquals("jane@example.com", retrievedUser.getEmail(), "The email should match.");
    }

    @Test
    void testGetUserByEmailNotFound() {
        User retrievedUser = userDAO.getUserByEmail("nonexistent@example.com");
        assertNull(retrievedUser, "No user should be found with this email.");
    }

    @Test
    void testAddUserWithNullConnection() {
        assertThrows(IllegalArgumentException.class, () -> {
            UserDAO nullConnectionUserDAO = new UserDAO(null);
            User user = new User(3, "Alice", "alice@example.com", "password123", "admin");
            nullConnectionUserDAO.addUser(user);
        });
    }

    @Test
    void testAddUserWithInvalidData() {
        User user = new User(5, "", "invalid@example.com", "", "");  // Empty name and password
        boolean result = userDAO.addUser(user);
        assertFalse(result, "User should not be added with invalid data.");
    }

    @Test
    void testAddAndGetUserByEmail() {
        User user = new User(4, "Tom Jones", "tom@example.com", "password456", "user");
        userDAO.addUser(user);

        User retrievedUser = userDAO.getUserByEmail("tom@example.com");
        assertNotNull(retrievedUser, "User should be found.");
        assertEquals("Tom Jones", retrievedUser.getName(), "The name should match.");
        assertEquals("tom@example.com", retrievedUser.getEmail(), "The email should match.");
        assertEquals("password456", retrievedUser.getPassword(), "The password should match.");
        assertEquals("user", retrievedUser.getRole(), "The role should match.");
    }
}
