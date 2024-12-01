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

public class SachDAO {
    /**
     *  Lấy tất cả sách
     */
    public static List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<>();
        String query = "SELECT * FROM Sach join TheLoaiSach on Sach.MaTheLoai = TheLoaiSach.MaTheLoai";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMaSach(resultSet.getInt("MaSach"));
                sach.setTenSach(resultSet.getString("TenSach"));
                sach.setTacGia(resultSet.getString("TacGia"));
                sach.setNhaXuatBan(resultSet.getString("NhaXuatBan"));
                sach.setNamXuatBan(resultSet.getInt("NamXuatBan"));
                sach.setLanXuatBan(resultSet.getInt("LanXuatBan"));
                sach.setSoTrang(resultSet.getInt("SoTrang"));
                sach.setKichThuoc(resultSet.getString("KichThuoc"));
                sach.setTenTheLoai(resultSet.getString("TenTheLoai"));
                sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sachList;
    }

    /**
     * Thêm sách mới
     */
    public static boolean addSach(Sach sach) {
        String query = "INSERT INTO Sach (TenSach, TacGia, NhaXuatBan, NamXuatBan, LanXuatBan, SoTrang, KichThuoc, MaTheLoai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, sach.getTenSach());
            preparedStatement.setString(2, sach.getTacGia());
            preparedStatement.setString(3, sach.getNhaXuatBan());
            preparedStatement.setInt(4, sach.getNamXuatBan());
            preparedStatement.setInt(5, sach.getLanXuatBan());
            preparedStatement.setInt(6, sach.getSoTrang());
            preparedStatement.setString(7, sach.getKichThuoc());
            preparedStatement.setInt(8, sach.getMaTheLoai());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cập nhật thông tin sách
     */
    public static boolean updateSach(Sach sach) {
        String query = "UPDATE Sach SET TenSach = ?, TacGia = ?, NhaXuatBan = ?, NamXuatBan = ?, LanXuatBan = ?, SoTrang = ?, KichThuoc = ?, MaTheLoai = ? WHERE MaSach = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, sach.getTenSach());
            preparedStatement.setString(2, sach.getTacGia());
            preparedStatement.setString(3, sach.getNhaXuatBan());
            preparedStatement.setInt(4, sach.getNamXuatBan());
            preparedStatement.setInt(5, sach.getLanXuatBan());
            preparedStatement.setInt(6, sach.getSoTrang());
            preparedStatement.setString(7, sach.getKichThuoc());
            preparedStatement.setInt(8, sach.getMaTheLoai());
            preparedStatement.setInt(9, sach.getMaSach());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa sách theo mã sách
     */
    public static boolean deleteSach(int maSach) {
        String query = "DELETE FROM Sach WHERE MaSach = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, maSach);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
