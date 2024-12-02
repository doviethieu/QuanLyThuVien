/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * lớp kết nối cơ sở dữ liệu
 * @author admin
 */
public class DBConnect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quanlythuvien?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    /**
     * phương thức kết nối cơ sở dữ liệu
     * @return kết nối cơ sở dữ liệu
     */
    public static java.sql.Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }
}
