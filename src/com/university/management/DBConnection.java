package com.university.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection connect;
    String url = "jdbc:mysql://localhost:3306/University";
    String user = ""; // Enter Your Database Username.
    String password = ""; // Enter Your Database Password.

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver Not Loaded Successfully Due to the reason: " + cnfe);
        }
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connected With the Database.");
        } catch (SQLException sqle) {
            System.out.println("Not Connected with the Database due to the reason: " + sqle);
        }
    }
}
