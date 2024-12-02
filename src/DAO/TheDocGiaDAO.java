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
import java.util.*;

public class TheDocGiaDAO {
    /**
     *  lấy tất cả thẻ độc giả
     */
    public static List<TheDocGia> getAllTheDocGia() {
        List<TheDocGia> theDocGiaList = new ArrayList<>();
        String query = "SELECT * FROM TheDocGia";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                TheDocGia theDocGia = new TheDocGia();
                theDocGia.setSoThe(resultSet.getString("SoThe"));
                theDocGia.setMaDocGia(resultSet.getInt("MaDocGia"));
                theDocGia.setNgayCap(resultSet.getDate("NgayCap"));
                theDocGia.setNgayHetHan(resultSet.getDate("NgayHetHan"));
                theDocGia.setGioiHanMuon(resultSet.getInt("GioiHanMuon"));
                theDocGiaList.add(theDocGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return theDocGiaList;
    }

    /**
     * Thêm thẻ độc giả mới
     */
    public static boolean addTheDocGia(TheDocGia theDocGia) {
        String query = "INSERT INTO TheDocGia (SoThe, MaDocGia, NgayCap, NgayHetHan, GioiHanMuon) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, theDocGia.getSoThe());
            preparedStatement.setInt(2, theDocGia.getMaDocGia());
            preparedStatement.setDate(3, new java.sql.Date(theDocGia.getNgayCap().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(theDocGia.getNgayHetHan().getTime()));
            preparedStatement.setInt(5, theDocGia.getGioiHanMuon());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cập nhật thông tin thẻ độc giả
     */
    public static boolean updateTheDocGia(TheDocGia theDocGia) {
        String query = "UPDATE TheDocGia SET MaDocGia = ?, NgayCap = ?, NgayHetHan = ?, GioiHanMuon = ? WHERE SoThe = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, theDocGia.getMaDocGia());
            preparedStatement.setDate(2, new java.sql.Date(theDocGia.getNgayCap().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(theDocGia.getNgayHetHan().getTime()));
            preparedStatement.setInt(4, theDocGia.getGioiHanMuon());
            preparedStatement.setString(5, theDocGia.getSoThe());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa một thẻ độc giả theo số thẻ
     */
    public static boolean deleteTheDocGia(String soThe) {
        String query = "DELETE FROM TheDocGia WHERE SoThe = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, soThe);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Phương thức để kiểm tra số thẻ có tồn tại, còn hạn và giới hạn mượn lớn hơn 0 không
     */
    public static boolean kiemTraThe(String soThe) {
        boolean ketQua = false;
        Date ngayHienTai = new Date();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT COUNT(*) AS count FROM TheDocGia WHERE SoThe = ? AND NgayHetHan >= ? AND GioiHanMuon > 0";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, soThe);
                pstmt.setDate(2, new java.sql.Date(ngayHienTai.getTime()));

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        ketQua = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    /**
     * Phương thức để cộng thêm 1 vào GioiHanMuon của một thẻ độc giả
     */
    public static boolean tangGioiHanMuon(String soThe) {
        String query = "UPDATE TheDocGia SET GioiHanMuon = GioiHanMuon + 1 WHERE SoThe = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, soThe);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *Phương thức để giảm đi 1 từ GioiHanMuon của một thẻ độc giả
     */
    public static boolean giamGioiHanMuon(String soThe) {
        String query = "UPDATE TheDocGia SET GioiHanMuon = GioiHanMuon - 1 WHERE SoThe = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, soThe);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}


