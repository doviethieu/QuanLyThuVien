/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.ResultSet;
/**
 * lớp thực hiện các thao tác với bảng muon_sach trong cơ sở dữ liệu
 * @author admin
 */
public class MuonTraSachDAO {

    /**
     * Thêm một bản ghi vào bảng muon_sach
     */
    public static boolean insertMuonSach(String soThe, int maSach, Date ngayTraDuKien) {
        boolean success = false;
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "INSERT INTO MuonSach (SoThe, MaSach, NgayMuon, NgayTraDuKien, TinhTrang) VALUES (?, ?, CURDATE(), ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, soThe);
                pstmt.setInt(2, maSach);
                pstmt.setDate(3, new java.sql.Date(ngayTraDuKien.getTime()));
                pstmt.setBoolean(4, false);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    /**
     * Lấy danh sách tất cả các bản ghi trong bảng muon_sach
     */
    public static List<MuonSach> getAllMuonSach() {
        List<MuonSach> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM MuonSach where TinhTrang = 0";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        MuonSach muonSach = new MuonSach();
                        muonSach.setMaMuon(rs.getInt("MaMuon"));
                        muonSach.setSoThe(rs.getString("SoThe"));
                        muonSach.setMaSach(rs.getInt("MaSach"));
                        muonSach.setNgayMuon(rs.getDate("NgayMuon"));
                        muonSach.setNgayTraDuKien(rs.getDate("NgayTraDuKien"));
                        muonSach.setNgayTra(rs.getDate("NgayTra"));
                        muonSach.setTienPhat(rs.getFloat("TienPhat"));
                        muonSach.setSoNgayQuaHan(rs.getInt("SoNgayQuaHan"));
                        muonSach.setTinhTrang(rs.getBoolean("TinhTrang"));
                        list.add(muonSach);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * xóa một bản ghi trong bảng muon_sach theo mã mượn
     */
    public static boolean deleteMuonSach(int maMuon) {
        String query = "DELETE FROM MuonSach WHERE MaMuon = ? AND TinhTrang = false";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, maMuon);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * trả sách theo mã mượn và cập nhật thông tin trả sách
     */
    public static boolean traSach(int maMuon, String soThe, int maSach, Date ngayMuon, Date ngayTraDuKien, Date ngayTra, float tienPhat, int soNgayQuaHan, boolean tinhTrang) {
        String query = "UPDATE MuonSach SET SoThe = ?, MaSach = ?, NgayMuon = ?, NgayTraDuKien = ?, NgayTra = ?, TienPhat = ?, SoNgayQuaHan = ?, TinhTrang = ? WHERE MaMuon = ?";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, soThe);
            preparedStatement.setInt(2, maSach);
            preparedStatement.setDate(3, new java.sql.Date(ngayMuon.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(ngayTraDuKien.getTime()));
            preparedStatement.setDate(5, new java.sql.Date(ngayTra.getTime()));
            preparedStatement.setFloat(6, tienPhat);
            preparedStatement.setInt(7, soNgayQuaHan);
            preparedStatement.setBoolean(8, tinhTrang);
            preparedStatement.setInt(9, maMuon);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * lấy tất cả các bản ghi trong bảng muon_sach có tình trạng trả sách
     */
     public static List<MuonSach> getAllTraSach() {
        List<MuonSach> list = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM MuonSach where TinhTrang = 0";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        MuonSach muonSach = new MuonSach();
                        muonSach.setMaMuon(rs.getInt("MaMuon"));
                        muonSach.setSoThe(rs.getString("SoThe"));
                        muonSach.setMaSach(rs.getInt("MaSach"));
                        muonSach.setNgayMuon(rs.getDate("NgayMuon"));
                        muonSach.setNgayTraDuKien(rs.getDate("NgayTraDuKien"));
                       
                        muonSach.setTinhTrang(rs.getBoolean("TinhTrang"));
                        list.add(muonSach);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * lấy lịch sử mượn trả sách
     */
    public static List<MuonSach> lichSuMuonTra() {
        List<MuonSach> muonSachList = new ArrayList<>();
        String query = "SELECT * FROM MuonSach WHERE TinhTrang = 1";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MuonSach muonSach = new MuonSach();
                muonSach.setMaMuon(resultSet.getInt("MaMuon"));
                muonSach.setSoThe(resultSet.getString("SoThe"));
                muonSach.setMaSach(resultSet.getInt("MaSach"));
                muonSach.setNgayMuon(resultSet.getDate("NgayMuon"));
                muonSach.setNgayTraDuKien(resultSet.getDate("NgayTraDuKien"));
                muonSach.setNgayTra(resultSet.getDate("NgayTra"));
                muonSach.setTienPhat(resultSet.getFloat("TienPhat"));
                muonSach.setSoNgayQuaHan(resultSet.getInt("SoNgayQuaHan"));
                muonSach.setTinhTrang(resultSet.getBoolean("TinhTrang"));
                muonSachList.add(muonSach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muonSachList;
    }
}
