package view.updatewatch;

import controller.DAO;
import controller.MeterDAO;
import controller.UserDAO;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Meter;
import model.User;
import view.home.HomeFrm;

public class UpdateMain extends javax.swing.JFrame {

    private DefaultTableModel model;
    private User user;
    
    public UpdateMain(User user) {
        this.user = user;
        initComponents();
        setTitle("Cập nhật số nước");
        setResizable(false);
        setSize(850, 550);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        meterTable.setBackground(Color.white);
        
        fillTable();
    }

    private void fillTable() {
        model = (DefaultTableModel) meterTable.getModel();
        model.setRowCount(0);
        MeterDAO meterDAO = new MeterDAO(DAO.con);
        List<Meter> list = meterDAO.getAllMeter();
        UserDAO userDAO = new UserDAO(DAO.con);
        for (Meter meter : list) {
            User user = userDAO.getUserById(meter.getCustomer_id());
            model.addRow(new Object[]{user.getAccount_code(), user.getName(), user.getAddress(),
            meter.getSerial_number(), meter.getMeter_id(), user.getUser_id()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameKH = new javax.swing.JTextField();
        findCustomerBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        meterTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Cập nhật số nước");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Họ tên khách hàng:");

        nameKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        findCustomerBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        findCustomerBTN.setText("Tìm kiếm");
        findCustomerBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findCustomerBTNMouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        meterTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        meterTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        meterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Địa chỉ", "Mã công tơ", "id", "customer_id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        meterTable.setRowHeight(30);
        meterTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                meterTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        meterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(meterTable);
        if (meterTable.getColumnModel().getColumnCount() > 0) {
            meterTable.getColumnModel().getColumn(4).setMinWidth(0);
            meterTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            meterTable.getColumnModel().getColumn(4).setMaxWidth(0);
            meterTable.getColumnModel().getColumn(5).setMinWidth(0);
            meterTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            meterTable.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nameKH, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(findCustomerBTN))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backButton)))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(findCustomerBTN)
                    .addComponent(nameKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // tìm kiếm khách hàng
    private void findCustomerBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findCustomerBTNMouseClicked
        String text = nameKH.getText();
        if (text.isEmpty()) {
            fillTable();
        } else {
            model = (DefaultTableModel) meterTable.getModel();
            model.setRowCount(0);
            MeterDAO meterDAO = new MeterDAO(DAO.con);
            List<Meter> list = meterDAO.getAllMeter();
            UserDAO udao = new UserDAO(DAO.con);
            for (Meter meter : list) {
                User user = udao.getUserById(meter.getCustomer_id());
                if (user.getName().toLowerCase().trim().matches(".*" + text.toLowerCase() + ".*")) {
                    model.addRow(new Object[]{user.getAccount_code(), user.getName(),
                        user.getAddress(), meter.getSerial_number(), meter.getMeter_id(), user.getUser_id()});
                }
            }
        }
    }//GEN-LAST:event_findCustomerBTNMouseClicked

    private void meterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meterTableMouseClicked
        int row = meterTable.getSelectedRow();
        model = (DefaultTableModel) meterTable.getModel();
        int customer_id = (int) model.getValueAt(row, 5);
        int meter_id = (int) model.getValueAt(row, 4);
        new UpdateDetail(meter_id, customer_id, user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_meterTableMouseClicked

    private void meterTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_meterTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_meterTableAncestorAdded

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        (new HomeFrm(user)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton findCustomerBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable meterTable;
    private javax.swing.JTextField nameKH;
    // End of variables declaration//GEN-END:variables
}
