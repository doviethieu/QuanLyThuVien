package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Class.*;
public class LoginDAO {
    /**
     * Kiểm tra thông tin đăng nhập của người dùng có chính xác không
     */
    public static boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM login WHERE username=? AND password=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
