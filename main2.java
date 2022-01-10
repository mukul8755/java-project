/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package new1;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mukul sharma
 */
public class main2 {
    public static void main(String args[]) {
        conn c3 = new conn();
        String sql2 = "update book set status = ? where id = ? ";
        PreparedStatement p4;
        String idv = "b003";
        try {
            p4 = c3.c.prepareStatement(sql2);
            String m2 = ""+1; 
            p4.setString(1,m2);
            p4.setString(2, idv);
            p4.executeUpdate();
            JOptionPane.showMessageDialog(null,"book is returned..");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(main2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
