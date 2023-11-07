
package dataBaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Serhat
 */
public class dbHelper {
    
    private String userName = "root";
    private String password = "Serhat.321";
    private String dbUrl = "jdbc:mysql://localhost:3306/java_veritabanı";
    
    public Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(dbUrl,userName,password);
   }
    
     public void showErrorMessage(SQLException e){
        
        System.out.println("Error : " + e.getMessage() + "\n Error Code : " + e.getErrorCode());
        
        
    }
    
}
