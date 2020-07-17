/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sap_aq3d;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBConnection {
    public static Connection getConnection(){
        Connection con = null;
        try{
            con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/memdb", "root", "");
            //JOptionPane.showMessageDialog(null, "Koneksi Sukses");
            return con;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}