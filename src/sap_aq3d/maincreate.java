/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap_aq3d;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class maincreate extends javax.swing.JFrame {

    /**
     * Creates new form maincreate
     */
    public maincreate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        create = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        setMinimumSize(new java.awt.Dimension(400, 350));
        setPreferredSize(new java.awt.Dimension(400, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 0, 204));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 139, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 139, -1));

        create.setBackground(new java.awt.Color(153, 0, 153));
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tick.png"))); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        getContentPane().add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 204));
        jLabel3.setText("Create Account");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("(6-12 characters)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setText("(6-12 characters)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        back.setBackground(new java.awt.Color(153, 0, 153));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new fmain().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        String uname=username.getText();
        String pass=String.valueOf(password.getPassword());
        if(uname.equals("")){
            JOptionPane.showMessageDialog(null, "Add a username!");
        }else if(pass.equals("")){
            JOptionPane.showMessageDialog(null, "Add a password!");
        }else if(checkUsername(uname)){
            JOptionPane.showMessageDialog(null, "Username already exist!");
        }else if(uname.length()>12){
            JOptionPane.showMessageDialog(null, "Username too long!");
        }else if(uname.length()<6){
            JOptionPane.showMessageDialog(null, "Username too short!");
        }else if(pass.length()<6){
            JOptionPane.showMessageDialog(null, "Username too short!");
        }else if(pass.length()>12){
            JOptionPane.showMessageDialog(null, "Username too long!");
        }else{
        PreparedStatement ps;
        String query="INSERT INTO `member`(`uname`,`password`) VALUES(?,?)";
        try{
            ps=(PreparedStatement) DBConnection.getConnection().prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "New user added!");
                new fmain().setVisible(true);
                this.dispose();
            }
        }catch(SQLException e){
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
        }
        }
    }//GEN-LAST:event_createActionPerformed

    /**
     * @param args the command line arguments
     */
    public boolean checkUsername(String username){
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser=false;
        String query="SELECT * FROM `member` WHERE `uname`=?";
        try{
            ps=(PreparedStatement) DBConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            rs=ps.executeQuery();
            if(rs.next()){
                checkUser=true;
            }
        }catch(SQLException e){
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE,null,e);
        }
        return checkUser;
    }
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
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maincreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maincreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
