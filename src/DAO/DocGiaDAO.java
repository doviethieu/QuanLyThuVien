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

public class DocGiaDAO {
    /**
     * Lấy danh sách tất cả độc giả
     */
    public static List<DocGia> getAllDocGia() {
        List<DocGia> docGiaList = new ArrayList<>();
        String query = "SELECT * FROM DocGia";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                DocGia docGia = new DocGia();
                docGia.setMaDocGia(resultSet.getInt("MaDocGia"));
                docGia.setHoTen(resultSet.getString("HoTen"));
                docGia.setNgaySinh(resultSet.getDate("NgaySinh"));
                docGia.setChucDanh(resultSet.getString("ChucDanh"));
                docGia.setDiaChi(resultSet.getString("DiaChi"));
                docGia.setSoCMND(resultSet.getString("SoCMND"));
                docGiaList.add(docGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docGiaList;
    }

    /**
     * thêm độc giả mới
     */
    public static boolean addDocGia(DocGia docGia) {
        String query = "INSERT INTO DocGia (HoTen, NgaySinh, ChucDanh, DiaChi, SoCMND) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, docGia.getHoTen());
            preparedStatement.setDate(2, new java.sql.Date(docGia.getNgaySinh().getTime()));
            preparedStatement.setString(3, docGia.getChucDanh());
            preparedStatement.setString(4, docGia.getDiaChi());
            preparedStatement.setString(5, docGia.getSoCMND());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cập nhật thông tin độc giả
     */
    public static boolean updateDocGia(DocGia docGia) {
        String query = "UPDATE DocGia SET HoTen = ?, NgaySinh = ?, ChucDanh = ?, DiaChi = ?, SoCMND = ? WHERE MaDocGia = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, docGia.getHoTen());
            preparedStatement.setDate(2, new java.sql.Date(docGia.getNgaySinh().getTime()));
            preparedStatement.setString(3, docGia.getChucDanh());
            preparedStatement.setString(4, docGia.getDiaChi());
            preparedStatement.setString(5, docGia.getSoCMND());
            preparedStatement.setInt(6, docGia.getMaDocGia());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa độc giả theo mã độc giả
     */
    public static boolean deleteDocGia(int maDocGia) {
        String query = "DELETE FROM DocGia WHERE MaDocGia = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, maDocGia);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
