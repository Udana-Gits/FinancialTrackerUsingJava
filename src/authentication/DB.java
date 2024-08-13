
package authentication;

import java.sql.*;
import java.util.logging.*;
import static javax.swing.DropMode.INSERT;

public class DB {
    
    private String url = "jdbc:mysql://localhost:3306/log?zeroDateTimeBehavior=convertToNull";
    private String un = "root";
    private String pw = "";
    private Connection con;
    
    public DB() {
        con = getCon();
    }
    
    public Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, un, pw);
            System.out.println("successful");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return con;
    }
    
    public boolean execute (String query){
        
        boolean status =false;

        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(query);
            status =true;

            } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }

            return status;

    }
    
    
}
