
package java_ile_veritabanı_işlemleri_yapma;

import dataBaseOperation.dbOperations;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Serhat
 */
public class Java_İle_Veritabanı_İşlemleri_Yapma {

    
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("WELCOME TO DATABESE OPERATION ");
        
       
        
        System.out.println(""
                + "\n   Add Operation    Enter 1 "
                + "\n   Show  All Information Enter 2 "
                + "\n   Delete Operation Enter 3"
                + "\n   Update Operation Enter 4 "
                + "\n   To Log out  Enter 0 ");
        int operation1 = scan.nextInt();
        
        while (true){
            
            
               if (operation1 == 1) {
            
            dbOperations.insertOperation();
            
       }
        if (operation1 == 2) {
            
            dbOperations.selectOperation();
          
        }
        if (operation1 == 3) {
            dbOperations.deleteOperation();
            
        }
        if (operation1 == 4) {
            dbOperations.updateOperationn();
            
        }
            if (operation1 == 0) {
                
                break;
            }
            
            System.out.println(""
                + "\n   Add Operation    Enter 1 "
                + "\n   Show All Information Enter 2 "
                + "\n   Delete Operation Enter 3"
                + "\n   Update Operation Enter 4 "
                + "\n   To Log out  Enter 0 ");
        operation1 = scan.nextInt();
        
        }
        
     
        
        
      
        
    }
    
    
    
}
