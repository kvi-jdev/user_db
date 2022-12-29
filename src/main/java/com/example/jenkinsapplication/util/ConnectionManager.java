package com.example.jenkinsapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    public static final String URL = "db.url";

    public static final String USERNAME = "db.username";

    public static final String PASSWORD = "db.password";

    private ConnectionManager() {

    }

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(PropertyUtil.getProperties(URL),
                    PropertyUtil.getProperties(USERNAME),
                    PropertyUtil.getProperties(PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


}
