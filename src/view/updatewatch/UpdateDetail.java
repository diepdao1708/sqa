/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.updatewatch;

import controller.MeterDAO;
import controller.ReadingDAO;
import controller.UserDAO;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Meter;
import model.Reading;
import model.User;

/**
 *
 * @author HP
 */
public class UpdateDetail extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDetail
     */
    private DefaultTableModel model;

    public UpdateDetail(int meter_id, int customer_id) {
        initComponents();
        id.setVisible(false);
        setTitle("Cập nhật số nước");
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        fillInfo(meter_id, customer_id);
        fillTable(meter_id);
    }

    public UpdateDetail() {
        initComponents();

        setTitle("Cập nhật số nước");
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
    }

    private void fillInfo(int meter_id, int customer_id) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(customer_id);
        MeterDAO meterDAO = new MeterDAO();
        Meter meter = meterDAO.meterInfo(meter_id);
        customerName.setText(user.getName());
        meterId.setText(meter.getSerial_number());
        this.id.setText(meter_id + "");
    }

    private void fillTable(int meter_id) {
        ReadingDAO readingDAO = new ReadingDAO();
        List<Reading> list = readingDAO.getReadingByMeterId(meter_id);
        model = (DefaultTableModel) readingTable.getModel();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        model.setRowCount(0);
        for (Reading r : list) {
            model.addRow(new Object[]{formater.format(r.getCreated_date()), r.getReading()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        meterId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numReading = new javax.swing.JTextField();
        updateBTN = new javax.swing.JButton();
        dateUpdate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        readingTable = new javax.swing.JTable();
        backBTN = new javax.swing.JButton();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Cập nhật số nước");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Họ tên:");

        customerName.setEditable(false);
        customerName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mã công tơ:");

        meterId.setEditable(false);
        meterId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Ngày cập nhật:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Số nước:");

        numReading.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        updateBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBTN.setText("Cập nhật");
        updateBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBTNMouseClicked(evt);
            }
        });
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        dateUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        readingTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        readingTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        readingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày cập nhật", "Số nước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(readingTable);

        backBTN.setText("<");
        backBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBTNMouseClicked(evt);
            }
        });
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        id.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(backBTN)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(39, 39, 39)
                                    .addComponent(dateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(97, 97, 97)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(numReading, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(meterId, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(updateBTN))
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backBTN))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meterId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(dateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(numReading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(updateBTN)
                        .addGap(29, 29, 29))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBTNActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBTNActionPerformed

    private void backBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBTNMouseClicked
        new UpdateMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_backBTNMouseClicked

    private void updateBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBTNMouseClicked
        model = (DefaultTableModel) readingTable.getModel();
        Date dateUpdate = this.dateUpdate.getDate();
        int meter_id = Integer.parseInt(id.getText());
        ReadingDAO rdao = new ReadingDAO();
        Reading readingNearest = rdao.getNearestReading(meter_id);
        String readingUpdate_raw = numReading.getText();
        int readingUpdate;
        try {
            readingUpdate = Integer.parseInt(readingUpdate_raw);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateUpdate);
            int month = calendar.get(calendar.MONTH) + 1;
            int year = calendar.get(calendar.YEAR);
            Reading readUpdate = new Reading();
            readUpdate.setMonth(month); readUpdate.setYear(year); readUpdate.setCreated_date(dateUpdate);
            readUpdate.setReading(readingUpdate); readUpdate.setMeter_id(meter_id);
            switch (check(readingNearest, readUpdate)) {
                case 0:
                    int row = rdao.insertReading(readUpdate);
                    if(row == 1){
                        JOptionPane.showMessageDialog(this, "Cập nhật thanh công");
                        fillTable(meter_id);
                    }
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, "Ngày tháng cập nhật không hợp lệ");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "Số nước không hợp lệ");
                    numReading.requestFocus();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "Chưa đến thời hạn cập nhật");
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Chưa nhập hoặc nhập sai số nước");
            numReading.requestFocus();
        }
    }//GEN-LAST:event_updateBTNMouseClicked

    private int check(Reading nearestReading, Reading nowReading) {
        Long diff = nowReading.getCreated_date().getTime() - nearestReading.getCreated_date().getTime();
        int count = (int) (TimeUnit.MILLISECONDS.toDays(diff));
        if(nearestReading.getMonth() >= nowReading.getMonth() || 
                nearestReading.getYear() > nowReading.getYear()){
            return 1;
        }else if(nearestReading.getReading() >= nowReading.getReading()){
            return 2;
        }else if(count < 28){
            return 3;
        }else if(nearestReading.getReading_id()==0){
            return 0;
        }else{
            return 0;
        }
    }

//    private boolean check(Reading dform, Reading reading){
//        if(reading.getMeter_id() == 0){
//            return true;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            java.util.Date dateform = sdf.parse(dform.getCreated_date());
//            java.util.Date dateNearest = sdf.parse(reading.getCreated_date());
//            if(dateform.compareTo(dateNearest) <= 0){
//                return false;
//            }
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        if(dform.getReading()<= reading.getReading()) return false;
//        return true;
//    }  
//    
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
            java.util.logging.Logger.getLogger(UpdateDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBTN;
    private javax.swing.JTextField customerName;
    private com.toedter.calendar.JDateChooser dateUpdate;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField meterId;
    private javax.swing.JTextField numReading;
    private javax.swing.JTable readingTable;
    private javax.swing.JButton updateBTN;
    // End of variables declaration//GEN-END:variables
}
