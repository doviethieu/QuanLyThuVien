/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.time.Instant;

/**
 * Lớp này cung cấp phương pháp tạo khóa duy nhất
 * @author admin
 */
public class CreateKey {
    /**
     * Tạo một khóa duy nhất bằng cách thêm tiền tố vào dựa trên thời gian hiện tại.
     *
     * @param tiento tiền tố sẽ được thêm vào khóa
     * @return một khóa duy nhất theo định dạng "tiento_7chuso"
     */
    public static String create(String tiento) {
        String key = tiento;
        long unixTimestamp = Instant.now().toEpochMilli();
        long sevenDigits = unixTimestamp % 10000000; // Lấy 7 số cuối cùng
        key += "_" + sevenDigits;
        return key;
    }
}
