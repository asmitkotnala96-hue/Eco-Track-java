package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnections {

    private static final String URL =
            "jdbc:mysql://localhost:3306/complaint_system";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println("Database Connected");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}