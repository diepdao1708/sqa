package view.home;

import controller.BillDAO;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import controller.CustomerDAO;
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

public class HomeFrm extends javax.swing.JFrame {

    private User user;

    CustomerDAO customerDAO = new CustomerDAO();
    MeterDAO meterDAO = new MeterDAO();
    ReadingDAO readingDAO = new ReadingDAO();
    RateDAO rateDAO = new RateDAO();
    BillDAO billDAO = new BillDAO();

    public HomeFrm(User user) {
        this.user = user;
        initComponents();
        
        System.out.println(user.getName());

        setTitle("Trang Chủ");
        setSize(830, 450);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
    }

    public HomeFrm() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Trang Chủ");

        jButton1.setText("Hóa đơn nước");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addContainerGap(274, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Lấy tháng - năm hiện tại
        Date date = new Date(System.currentTimeMillis());
        String date_format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        int month = Integer.parseInt(date_format.split("-")[1]);
        int year = Integer.parseInt(date_format.split("-")[0]);

        // Lấy thông tin 
        Customer customer = customerDAO.customerInfo(1);
        Meter meter = meterDAO.meterInfo(customer.getCustomer_id());
        Reading reading = readingDAO.readingInfo(meter.getMeter_id(), month, year);
        Rate rate = rateDAO.rateInfo(customer.getRate_id());
        Bill bill = billDAO.billInfo(1, month, year);

        //Lưu hóa đơn nếu cần
        if (reading != null && bill == null) {
            Reading previous_reading = null;
            if (month != 1) {
                previous_reading = readingDAO.readingInfo(meter.getMeter_id(), month - 1, year);
            } else {
                previous_reading = readingDAO.readingInfo(meter.getMeter_id(), month - 1, year - 1);
            }
            billDAO.saveBill(1, month, year, reading.getReading(), previous_reading.getReading(), customer.getType(), rate);
        }

        //
        BillFrm ttf = new BillFrm(customer.getCustomer_id());
        ttf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
