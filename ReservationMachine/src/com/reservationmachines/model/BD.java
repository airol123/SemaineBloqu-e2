package com.reservationmachines.model;

import java.sql.*;

public class BD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/reservationmachine?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    static Connection con;
    //static Statement sql;   //pour SELECT
    static PreparedStatement sql;  //pour UPDATE
    static ResultSet res;

    public Connection getConnection(){
        try {
            // bd driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Succès driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("pb: Class.forName");
        }

        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Succès Connexion");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("pb:JDBC ");
        }
        return con;
    }

    public static void main(String[] args) {
        BD c= new BD();
        con = c.getConnection();        
    }
    }



