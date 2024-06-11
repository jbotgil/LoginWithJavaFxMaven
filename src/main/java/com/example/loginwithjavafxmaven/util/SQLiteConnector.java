package com.example.loginwithjavafxmaven.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnector {

    private static SQLiteConnector instance;
    Connection conn = null;
    private SQLiteConnector(){
        connect();
    }
    public static SQLiteConnector getInstance(){
        if(instance == null)
            instance = new SQLiteConnector();
        return instance;
    }
    private void connect(){
        try {
            // db parameters
            String url = "jdbc:sqlite:src/main/resources/db/LoginWithJava.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection() {
        return conn;
    }
    public static void main(String[] args) {

        SQLiteConnector sqLiteConnector = SQLiteConnector.getInstance();

        sqLiteConnector.connect();
    }
}