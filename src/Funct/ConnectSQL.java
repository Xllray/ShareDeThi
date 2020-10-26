package Funct;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {
    static Connection con=null;
    
    public Connection getConn() {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDETHI";
            String user="sa";
            String pass="haithangp2ba";
            Class.forName(driver); //load driver
            con = DriverManager.getConnection(url,user,pass);            
            System.out.println("Thành công");
        } catch (Exception e) {
            System.out.print("Error "+e.getMessage());
        }
        return con;
    }
    
    
    
}
