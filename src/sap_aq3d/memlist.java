/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap_aq3d;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Max
 */
public class memlist extends javax.swing.JFrame {

    /**
     * Creates new form memlist
     */
    DefaultTableModel tablemem;
    Object[] list_char = new Object[10];
    int x=0;
    DBConnection dbc = new DBConnection();
    Connection c = dbc.getConnection();
    public memlist() throws SQLException {
        initComponents();
        memList.setVisible(false);
        tablemem =new DefaultTableModel();
        memTable.setModel(tablemem);
        tablemem.addColumn("No");
        tablemem.addColumn("Username");
        tablemem.addColumn("IGN");
        tablemem.addColumn("Level");
        tableShow();
    }
    public ArrayList[] getMemList() throws SQLException{
        String queryCount = "SELECT COUNT(*) as c FROM `member`";
        Statement st;
        ResultSet rsCount, rs;       
        st = c.createStatement();
        rsCount = st.executeQuery(queryCount);
        int sizeTable=0;

        while(rsCount.next()){
            sizeTable = rsCount.getInt("c");
        }
        ArrayList[] memL = new ArrayList[sizeTable];       
        
        String query = "SELECT * FROM `member` JOIN `karakter` ON `member`.`id_mem`=`karakter`.`id_mem`";
        
        rs = st.executeQuery(query);
        
        int x=0;
        
        while(rs.next()){
            memL[x] = new ArrayList<>();
            memL[x].add(rs.getString("uname"));
            memL[x].add(rs.getString("name"));
            memL[x].add(rs.getInt("level"));
            x++;
        }
        return memL;
    }
    public void tableShow() throws SQLException{
        ArrayList[] list = getMemList();
        DefaultTableModel model = (DefaultTableModel)memTable.getModel();
       
        Object[] row = new Object[4];
        for(int i = 0; i<list.length; i++){
            row[0] = i+1;
            row[1] = list[i].get(0); 
            row[2] = list[i].get(1);
            row[3] = list[i].get(2);

            model.addRow(row);
        }       
    }
    public void selectRow(){
        memTable.getSelectedRow();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        memTable = new javax.swing.JTable();
        home = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        memList = new javax.swing.JMenuItem();
        charList = new javax.swing.JMenuItem();
        regChar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Member List");

        memTable.setForeground(new java.awt.Color(204, 0, 204));
        memTable.setModel(new javax.swing.table.DefaultTableModel(
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
        memTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memTable);

        home.setBackground(new java.awt.Color(153, 0, 153));
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        cetak.setBackground(new java.awt.Color(153, 0, 153));
        cetak.setForeground(new java.awt.Color(255, 255, 255));
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        cetak.setText("Print");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        menu.setText("Menu");

        memList.setText("Member List");
        memList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memListActionPerformed(evt);
            }
        });
        menu.add(memList);

        charList.setText("Character List");
        charList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charListActionPerformed(evt);
            }
        });
        menu.add(charList);

        regChar.setText("Register Character");
        regChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regCharActionPerformed(evt);
            }
        });
        menu.add(regChar);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(cetak)
                        .addGap(18, 18, 18)
                        .addComponent(home))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home)
                    .addComponent(cetak))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void memListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memListActionPerformed
       
    }//GEN-LAST:event_memListActionPerformed

    private void charListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_charListActionPerformed
        try {
            new charlist().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(memlist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_charListActionPerformed

    private void regCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regCharActionPerformed
        new regchar().setVisible(true);
        dispose();
    }//GEN-LAST:event_regCharActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        new fhome().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void memTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memTableMouseClicked
        selectRow();
    }//GEN-LAST:event_memTableMouseClicked

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        MessageFormat header = new MessageFormat("Member Data");
        //add import MessageFormat
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        try{
            memTable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s", e.getMessage());
        }
    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(memlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new memlist().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(memlist.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JMenuItem charList;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem memList;
    private javax.swing.JTable memTable;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem regChar;
    // End of variables declaration//GEN-END:variables
}
