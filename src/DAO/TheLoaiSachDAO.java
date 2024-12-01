/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Class.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiSachDAO {
    /**
     * Phương thức lấy danh sách tất cả thể loại sách
     */
    public static List<TheLoaiSach> getAllTheLoaiSach() {
        List<TheLoaiSach> theLoaiSachList = new ArrayList<>();
        String query = "SELECT * FROM TheLoaiSach";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                TheLoaiSach theLoaiSach = new TheLoaiSach();
                theLoaiSach.setMaTheLoai(resultSet.getInt("MaTheLoai"));
                theLoaiSach.setTenTheLoai(resultSet.getString("TenTheLoai"));
                theLoaiSachList.add(theLoaiSach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return theLoaiSachList;
    }

    /**
     * Thêm thể loại sách mới
     */
    public static boolean addTheLoaiSach(TheLoaiSach theLoaiSach) {
        String query = "INSERT INTO TheLoaiSach (TenTheLoai) VALUES (?)";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, theLoaiSach.getTenTheLoai());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cập nhật thể loại sách
     */
    public static boolean updateTheLoaiSach(TheLoaiSach theLoaiSach) {
        String query = "UPDATE TheLoaiSach SET TenTheLoai = ? WHERE MaTheLoai = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, theLoaiSach.getTenTheLoai());
            preparedStatement.setInt(2, theLoaiSach.getMaTheLoai());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa thể loại sách
     */
    public static boolean deleteTheLoaiSach(int maTheLoai) {
        String query = "DELETE FROM TheLoaiSach WHERE MaTheLoai = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, maTheLoai);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
