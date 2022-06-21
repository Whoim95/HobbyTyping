package com.hobbytyping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hobbytypingdb_2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "171717";

    private Connection connection;

    public Connection createConnection() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            //System.out.println("The connection is opened.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public void closeConnection() {

        try {
            connection.close();
            //System.out.println("The connection is closed.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
