/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuastest;

/**
 *
 * @author Angga (Pandora)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class sync {
    Connection sync;
    
    public static Connection sync(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection sync = DriverManager.getConnection("jdbc:mysql://localhost:3306/sintak","root","");
        return sync;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
    }
}
