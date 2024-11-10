CREATE DATABASE IF NOT EXISTS quanlythuvien;
USE quanlythuvien;
create table login
(
	username nvarchar(255) primary key,
    password nvarchar(255) not null
);
-- Tạo bảng Thể loại sách
CREATE TABLE TheLoaiSach (
    MaTheLoai INT AUTO_INCREMENT PRIMARY KEY,
    TenTheLoai NVARCHAR(100)
);

-- Tạo bảng Sách
CREATE TABLE Sach (
    MaSach INT AUTO_INCREMENT PRIMARY KEY,
    TenSach NVARCHAR(200),
    TacGia NVARCHAR(100),
    NhaXuatBan NVARCHAR(100),
    NamXuatBan INT,
    LanXuatBan INT,
    SoTrang INT,
    KichThuoc NVARCHAR(50),
    MaTheLoai INT,
    FOREIGN KEY (MaTheLoai) REFERENCES TheLoaiSach(MaTheLoai)
);

-- Tạo bảng Độc giả
CREATE TABLE DocGia (
    MaDocGia INT AUTO_INCREMENT PRIMARY KEY,
    HoTen NVARCHAR(200),
    NgaySinh DATE,
    ChucDanh NVARCHAR(100),
    DiaChi NVARCHAR(500),
    SoCMND NVARCHAR(20)
);

-- Tạo bảng Thẻ độc giả
CREATE TABLE TheDocGia (
    SoThe NVARCHAR(255) PRIMARY KEY,
    MaDocGia INT,
    NgayCap DATE,
    NgayHetHan DATE,
    GioiHanMuon INT,
    FOREIGN KEY (MaDocGia) REFERENCES DocGia(MaDocGia)
);

-- Tạo bảng Mượn sách
CREATE TABLE MuonSach (
    MaMuon INT AUTO_INCREMENT PRIMARY KEY,
    SoThe NVARCHAR(255),
    MaSach INT,
    NgayMuon DATE,
    NgayTraDuKien DATE,
    NgayTra DATE,
    TienPhat float,
    SoNgayQuaHan int,
    TinhTrang bit,
    FOREIGN KEY (SoThe) REFERENCES TheDocGia(SoThe),
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)
);


INSERT INTO TheLoaiSach (TenTheLoai) VALUES
('Khoa học'),
('Văn học'),
('Lịch sử'),
('Tâm lý học'),
('Kinh tế');
INSERT INTO Sach (TenSach, TacGia, NhaXuatBan, NamXuatBan, LanXuatBan, SoTrang, KichThuoc, MaTheLoai) VALUES
('Thiên hạ đệ nhất kỳ thư', 'Nguyễn Thị Bích', 'NXB Trẻ', 2020, 1, 300, '14x21', 2),
('Nhà giả kim', 'Paulo Coelho', 'NXB Phụ Nữ', 1988, 5, 150, '12x18', 2),
('Lược sử thế giới', 'Nguyễn Khắc Chúc', 'NXB Văn hóa - Thông tin', 2005, 2, 500, '16x24', 3),
('Tâm lý học cơ bản', 'Sigmund Freud', 'NXB Trẻ', 2010, 3, 250, '15x23', 4),
('Chủ nghĩa tư bản', 'Karl Marx', 'NXB Chính trị Quốc gia', 1867, 1, 600, '18x26', 5);
INSERT INTO DocGia (HoTen, NgaySinh, ChucDanh, DiaChi, SoCMND) VALUES
('Nguyễn Văn A', '1990-05-15', 'Giáo viên', 'Hà Nội', '123456789'),
('Trần Thị B', '1985-08-20', 'Sinh viên', 'Hồ Chí Minh', '987654321'),
('Lê Minh C', '1978-03-10', 'Nhà nghiên cứu', 'Đà Nẵng', '456123789'),
('Phạm Văn D', '1995-11-25', 'Nhân viên văn phòng', 'Hải Phòng', '321654987'),
('Nguyễn Thị E', '2000-02-18', 'Học sinh', 'Quảng Ninh', '789321654');
INSERT INTO TheDocGia (SoThe, MaDocGia, NgayCap, NgayHetHan, GioiHanMuon, ThoiGianMuon, SoTienCoc) VALUES
('A123', 1, '2023-01-01', '2024-01-01', 5, '2023-01-01 08:00:00', 100000),
('B456', 2, '2023-02-01', '2024-02-01', 3, '2023-02-01 09:00:00', 50000),
('C789', 3, '2023-03-01', '2024-03-01', 7, '2023-03-01 10:00:00', 150000),
('D012', 4, '2023-04-01', '2024-04-01', 4, '2023-04-01 11:00:00', 75000),
('E345', 5, '2023-05-01', '2024-05-01', 6, '2023-05-01 12:00:00', 120000);

