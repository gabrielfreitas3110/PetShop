package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class MySqlAccess {
    private static final String URL = "jdbc:mysql://localhost:3306/dbpetshop";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER,PASS);
        } catch (SQLException ex) {
            throw new RuntimeException(" Driver Manager error: ",ex);
        }
    }
    
    public static void disconnect(Connection con) {
        try {
            if(con != null)
                con.close();
        }catch (SQLException ex) {
            Logger.getLogger(MySqlAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void disconnect(Connection con, PreparedStatement stm) {
        disconnect(con);
        try {
            if(stm != null)
                stm.close();
        }catch (SQLException ex) {
            Logger.getLogger(MySqlAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void disconnect(Connection con, PreparedStatement stm, ResultSet rs) {
        disconnect(con, stm);
        try {
            if(rs != null) 
                rs.close();
        }catch (SQLException ex) {
            Logger.getLogger(MySqlAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}