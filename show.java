/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package new1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import new1.conn;
import new1.first;

public class show extends JFrame {
    String head[] = {"book_id", "book_name", "book_price", "book_author","book_status"};

    show() {
        setSize(1000, 550);
        new first().setVisible(true);
        setVisible(true);
        
        DefaultTableModel m1 = new DefaultTableModel(0, 5);
        m1.setColumnIdentifiers(head);
        JTable t1 = new JTable(m1);
        JScrollPane p1 = new JScrollPane(t1);
        add(p1);

        try {
            conn co = new conn();
            ResultSet rs = co.s.executeQuery("select * from book");
            while (rs.next()) {
                Object[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)};
                m1.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
    
    public static void main(String args[]) {
       new show();    
       } 
    
}
