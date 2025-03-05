package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;

    // Private constructor to prevent instantiation
    private SingletonConnection() {}

    // Lazy initialization of the connection
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (SingletonConnection.class) {
                if (connection == null) {
                    try {
                        // Load the MySQL JDBC driver
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        System.out.println("Driver loaded successfully");

                        // Create the database connection with additional parameters
                        connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/db_smartphone?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                                "root",
                                "");
                        System.out.println("Connected to database successfully");

                    } catch (ClassNotFoundException e) {
                        System.err.println("MySQL JDBC Driver not found!");
                        e.printStackTrace();
                        throw new IllegalStateException("MySQL JDBC Driver not found", e);
                    } catch (SQLException e) {
                        System.err.println("Database connection error: " + e.getMessage());
                        e.printStackTrace();
                        throw new IllegalStateException("Failed to connect to database", e);
                    }
                }
            }
        }
        return connection;
    }
}