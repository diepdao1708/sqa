package view.register;

import controller.Const;
import controller.RegisterDAO;
import controller.RegisterData;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.login.LoginFrm;

public class RegisterFrm extends javax.swing.JFrame {

    public Connection con;

    public RegisterFrm() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqa", "root", "password");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        setTitle("Đăng Ký");
        setResizable(false);
        setSize(850, 550);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        accountCodeEditText.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        registerButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        registerButton.setText("Đăng ký");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Đăng Ký");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Mật Khẩu:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("CCCD:");

        note.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        note.setText("Ít nhất 8 ký tự bao gồm chữ hoa, chữ thường và số");

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        accountCodeEditText.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        accountCodeEditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountCodeEditTextActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Xác nhận mật khẩu:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cccdEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountCodeEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmPasswordEditText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordEditText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(121, 229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(backButton)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountCodeEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(note)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(passwordEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cccdEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addComponent(registerButton)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountCodeEditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountCodeEditTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountCodeEditTextActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        (new LoginFrm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterDAO registerDAO = new RegisterDAO(con);
        String accountCode = accountCodeEditText.getText().trim();
        String password = new String(passwordEditText.getPassword());
        String confirmPassword = new String(confirmPasswordEditText.getPassword());
        String cccd = cccdEditText.getText().trim();

        RegisterData registerData = registerDAO.register(accountCode, cccd, password, confirmPassword);

        if (registerData.getStatus() == 200) {
            JOptionPane.showMessageDialog(this, registerData.getMessage());
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
    private javax.swing.JLabel note;
    private javax.swing.JPasswordField passwordEditText;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
