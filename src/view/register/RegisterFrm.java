package view.register;

import controller.Const;
import controller.RegisterDAO;
import controller.RegisterData;
import java.awt.Color;
import javax.swing.JOptionPane;
import view.login.LoginFrm;

public class RegisterFrm extends javax.swing.JFrame {

    public RegisterFrm() {
        initComponents();

        setTitle("Đăng Ký");
        setSize(830, 450);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cccdEditText = new javax.swing.JTextField();
        passwordEditText = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        note = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        accountCodeEditText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordEditText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(828, 440));

        registerButton.setText("Đăng ký");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Đăng Ký");

        jLabel2.setText("Mã Khách Hàng:");

        jLabel3.setText("Mật Khẩu:");

        jLabel4.setText("CCCD:");

        note.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        note.setText("Ít nhất 8 ký tự bao gồm chữ hoa, chữ thường và số");

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Xác nhận mật khẩu:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(note, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cccdEditText)
                                            .addComponent(passwordEditText)
                                            .addComponent(accountCodeEditText)
                                            .addComponent(confirmPasswordEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(accountCodeEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(note)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(confirmPasswordEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cccdEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addComponent(registerButton)
                .addGap(0, 79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterDAO registerDAO = new RegisterDAO();
        String accountCode = accountCodeEditText.getText();
        String password = new String(passwordEditText.getPassword());
        String confirmPassword = new String(confirmPasswordEditText.getPassword());
        String cccd = cccdEditText.getText();

        RegisterData registerData = registerDAO.register(accountCode, cccd, password, confirmPassword);

        if (registerData.getStatus() == 200) {
            (new LoginFrm()).setVisible(true);
            this.dispose();
        } else {
            if (registerData.getMessage().equals(Const.account_code_empty)
                    || registerData.getMessage().equals(Const.exist_account)
                    || registerData.getMessage().equals(Const.register_failure)
                    || registerData.getMessage().equals(Const.not_exist_customer_code)) {
                accountCodeEditText.requestFocus();
            }
            if (registerData.getMessage().equals(Const.password_empty)
                    || registerData.getMessage().equals(Const.password_not_matching)) {
                passwordEditText.requestFocus();
            }
            if (registerData.getMessage().equals(Const.confirm_password_empty)) {
                confirmPasswordEditText.requestFocus();
            }
            if (registerData.getMessage().equals(Const.cccd_empty)) {
                cccdEditText.requestFocus();
            }
            note.setForeground(registerData.getMessage().equals(Const.format_password) ? Color.red : Color.black);

            JOptionPane.showMessageDialog(this, registerData.getMessage());
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        (new LoginFrm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountCodeEditText;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField cccdEditText;
    private javax.swing.JPasswordField confirmPasswordEditText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel note;
    private javax.swing.JPasswordField passwordEditText;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
