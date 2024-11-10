/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;

public class TheDocGia {
    private String soThe;
    private int maDocGia;
    private Date ngayCap;
    private Date ngayHetHan;
    private int gioiHanMuon;
   
   
    // Constructors
    public TheDocGia() {}

    public TheDocGia(String soThe, int maDocGia, Date ngayCap, Date ngayHetHan, int gioiHanMuon) {
        this.soThe = soThe;
        this.maDocGia = maDocGia;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.gioiHanMuon = gioiHanMuon;
    }

   

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getGioiHanMuon() {
        return gioiHanMuon;
    }

    public void setGioiHanMuon(int gioiHanMuon) {
        this.gioiHanMuon = gioiHanMuon;
    }
}
