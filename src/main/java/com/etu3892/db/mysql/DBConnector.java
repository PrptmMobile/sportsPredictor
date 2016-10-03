package com.etu3892.db.mysql;

import org.apache.log4j.Logger;

import java.sql.*;

public class DBConnector {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "amngr51";
    private static Connection connection;
    private static boolean started;

    public static void execute(String sql) throws SQLException {
        if (!started) start();
        connection.createStatement().executeUpdate(sql);
    }

    public static void executeTime(String sql,Timestamp timestamp) throws SQLException {
        if (!started) start();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, timestamp);
        preparedStatement.executeUpdate();
    }

    public static ResultSet getSet(String sql) throws SQLException {
        if (!started) start();
        return connection.createStatement().executeQuery(sql);
    }

    private static void start(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            started = true;
        } catch (Exception exc) {
            //Logger.getLogger(exc.getMessage());
        }
    }
}
