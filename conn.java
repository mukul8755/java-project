/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package new1;
import java.sql.*;
/**
 *
 * @author mukul
 */
public class conn {
    Connection c;
    Statement s;
    conn() {
        
        try {
           Class.forName("com.mysql.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql:///new","root","");
                s = c.createStatement();
                System.out.println("connected");
           

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
            new conn();
    }
}
