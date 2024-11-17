/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.time.Instant;

/**
 *
 * @author admin
 */
public class CreateKey {
    public static String create(String tiento) {
        String key = tiento;
        long unixTimestamp = Instant.now().toEpochMilli();
        long sevenDigits = unixTimestamp % 10000000; // Lấy 7 số cuối cùng
        key += "_" + sevenDigits;
        return key;
    }
}
