/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Class.*;
import DAO.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FormTraSach extends javax.swing.JFrame {

    /**
     * Creates new form FormTraSach
     */
     private void LoadData() {
    try {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã mượn");
        model.addColumn("Số thẻ");
        model.addColumn("Mã sách");
        model.addColumn("Ngày mượn");
        model.addColumn("Ngày trả dự kiến");
      
        model.addColumn("Tình trạng");
        List<MuonSach> muonSachs = MuonTraSachDAO.getAllTraSach();

        // Thêm dữ liệu từ danh sách Độc giả vào model
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (MuonSach muonSach : muonSachs) {
            Object[] row = {
                    muonSach.getMaMuon(),
                    muonSach.getSoThe(),
                    muonSach.getMaSach(),
                    dateFormat.format(muonSach.getNgayMuon()), // Định dạng lại ngày sinh
                    dateFormat.format(muonSach.getNgayTraDuKien()),
                    
                    muonSach.isTinhTrang() == true ? "Đã trả" : "Chưa trả"
            };
            model.addRow(row);
        }

        // Set model cho jTable1
        jTable1.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace();
        // Xử lý lỗi nếu cần
    }
    txt_maMuon.setText("");
    txt_maSach.setText("");
    txt_ngayTra.setText("");
    txt_soThe.setText("");  
    }
    public FormTraSach() {
        initComponents();
        LoadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_maMuon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_soThe = new javax.swing.JTextField();
        txt_ngayTra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_maSach = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Mã mượn");

        txt_maMuon.setEnabled(false);

        jLabel2.setText("Số thẻ");

        jLabel4.setText("Ngày trả");

        txt_soThe.setEnabled(false);

        jLabel3.setText("Mã sách");

        jButton1.setText("Trả sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_maSach.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_maMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_soThe, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ngayTra, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txt_maSach))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_maMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ngayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_soThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int calculateLateDays(String ngayTraDuKienStr, String ngayTraStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ngayTraDuKien = dateFormat.parse(ngayTraDuKienStr);
            Date ngayTra = dateFormat.parse(ngayTraStr);

            if (ngayTra.before(ngayTraDuKien)) {
                return 0; // Trả về 0 nếu ngày trả trước ngày trả dự kiến
            }

            long diffInMillies = Math.abs(ngayTra.getTime() - ngayTraDuKien.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return (int) diff;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Trả về -1 nếu có lỗi xảy ra khi chuyển đổi ngày
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    String ngayTraDuKien;
    String ngayMuon;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Integer maMuon = (Integer) jTable1.getValueAt(selectedRow, 0);
            String soThe = (String) jTable1.getValueAt(selectedRow, 1);
            Integer maSach = (Integer) jTable1.getValueAt(selectedRow, 2);
            ngayMuon = (String) jTable1.getValueAt(selectedRow, 3);
            ngayTraDuKien = (String) jTable1.getValueAt(selectedRow, 4);

            // Gán giá trị vào các ô text
            txt_maMuon.setText(maMuon.toString());
            txt_soThe.setText(soThe);
            txt_maSach.setText(maSach.toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked
 private Date stringToDate(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(TheDocGiaDAO.kiemTraThe(txt_soThe.getText())){
            // Chuyển đổi chuỗi ngày thành đối tượng Date trước khi gọi phương thức insertMuonSach
            Date ngayTra = stringToDate(txt_ngayTra.getText());
            int soNgayQuaHan =  calculateLateDays(ngayTraDuKien, txt_ngayTra.getText());
            System.out.println(soNgayQuaHan);
            if (ngayTra != null) {
                if(MuonTraSachDAO.traSach(Integer.parseInt(txt_maMuon.getText()), txt_soThe.getText(), Integer.parseInt(txt_maSach.getText()),
                        stringToDate(ngayMuon), stringToDate(ngayTraDuKien), ngayTra, soNgayQuaHan*5000, soNgayQuaHan, true)){
                     JOptionPane.showMessageDialog(rootPane, "Trả thành công. Trả muộn: " + soNgayQuaHan + "ngày. Số tiền phạt cần thanh toán: "+ soNgayQuaHan*5000 +"VND");
                     TheDocGiaDAO.tangGioiHanMuon(txt_soThe.getText());
                     LoadData();
                }else{
                     JOptionPane.showMessageDialog(rootPane, "Trả thất bại");
                }
               
            } else {
                JOptionPane.showMessageDialog(rootPane, "Định dạng ngày không hợp lệ");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thẻ không hợp lệ do không đúng hoặc quá hạn hoặc đã hết số lượng mượn tối đa");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTraSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTraSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_maMuon;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_ngayTra;
    private javax.swing.JTextField txt_soThe;
    // End of variables declaration//GEN-END:variables
}