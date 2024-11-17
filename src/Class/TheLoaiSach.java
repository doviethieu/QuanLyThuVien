/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author admin
 */
public class TheLoaiSach {
    private int maTheLoai;
    private String tenTheLoai;

    // Constructors
    public TheLoaiSach() {}

    public TheLoaiSach(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoaiSach(int maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    
    // Getters and Setters
    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return tenTheLoai;
    }
    
}
