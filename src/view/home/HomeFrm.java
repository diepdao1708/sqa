package view.home;

import controller.BillDAO;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import controller.CustomerDAO;
import controller.DAO;
import controller.MeterDAO;
import controller.RateDAO;
import controller.ReadingDAO;
import model.Bill;
import model.Customer;
import model.Meter;
import model.Rate;
import model.Reading;
import model.User;
import view.bill.BillFrm;
import view.login.LoginFrm;
import view.payment.PaymentFrm;
import view.updatewatch.UpdateMain;

public class HomeFrm extends javax.swing.JFrame {
    
    private User user;
    
    CustomerDAO customerDAO = new CustomerDAO();
    MeterDAO meterDAO = new MeterDAO(DAO.con);
    ReadingDAO readingDAO = new ReadingDAO(DAO.con);
    RateDAO rateDAO = new RateDAO();
    BillDAO billDAO = new BillDAO();
    
    public HomeFrm(User user) {
        this.user = user;
        initComponents();
        
        setTitle("Trang Chủ");
        setResizable(false);
        setSize(850, 550);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        
        jLabel2.setText("Xin chào, " + user.getName() + "!");
        jLabel4.setText("Địa chỉ: " + user.getAddress());
        jLabel5.setText("Số điện thoại: " + user.getPhone_number());
        if (user.getRole().equals("kh")) {
            jLabel3.setText("Mã khách hàng: " + user.getAccount_code());
            jButton1.setVisible(true);
            jButton2.setVisible(true);
            jButton3.setVisible(false);
        } else {
            jLabel3.setText("Mã nhân viên: " + user.getAccount_code());
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jButton3.setVisible(true);
        }
    }
    
    public HomeFrm() {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Trang Chủ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setText("Tính tiền nước");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setText("Thanh toán tiền nước");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setText("Cập nhật số nước ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setText(" Đăng xuất");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Xin chào, Đào Bích Diệp!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mã khách hàng: KH01");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Địa chỉ: ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Số điện thoại: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addGap(0, 353, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(168, 168, 168))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Lấy tháng - năm hiện tại
        Date date = new Date(System.currentTimeMillis());
        String date_format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        int month = Integer.parseInt(date_format.split("-")[1]);
        int year = Integer.parseInt(date_format.split("-")[0]);

        // Lấy thông tin 
        Customer customer = customerDAO.customerInfo(user.getUser_id());
        Meter meter = meterDAO.meterInfo(customer.getCustomer_id());
        Reading reading = readingDAO.readingInfo(meter.getMeter_id(), month, year);
        Rate rate = rateDAO.rateInfo(customer.getRate_id());
        Bill bill = billDAO.billInfo(user.getUser_id(), month, year);

        //Lưu hóa đơn nếu cần
        if (reading != null && bill == null) {
            Reading previous_reading = null;
            if (month != 1) {
                previous_reading = readingDAO.readingInfo(meter.getMeter_id(), month - 1, year);
            } else {
                previous_reading = readingDAO.readingInfo(meter.getMeter_id(), month - 1, year - 1);
            }
            billDAO.saveBill(user.getUser_id(), month, year, reading.getReading(), previous_reading.getReading(), customer.getType(), rate);
        }

        //
        BillFrm ttf = new BillFrm(user);
        ttf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        (new PaymentFrm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        (new UpdateMain(user)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        (new LoginFrm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
