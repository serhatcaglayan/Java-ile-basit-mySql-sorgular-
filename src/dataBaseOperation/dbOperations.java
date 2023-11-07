/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Serhat
 */
public class dbOperations {
   
    
        
    
    public static void selectOperation() throws SQLException{
        Connection connection = null;
        dbHelper helper  = new dbHelper();
        Statement statment;
        ResultSet resultSet;
       
        try{
           connection = helper.getConnection();
            System.out.println("Detabese Connected for Select Operation \n");
            statment = connection.createStatement();
            String sql = "SELECT * FROM java_veritabanı.person";
            resultSet = statment.executeQuery(sql);
              ArrayList<Person> person = new ArrayList<>();
           
            
            
            while (resultSet.next()) {
                person.add(new Person(
                        resultSet.getString("idPerson"),
                        resultSet.getString("namePerson"),
                        resultSet.getString("numberPerson"),
                        resultSet.getString("agePerson")));
                                
            }
                       System.out.printf("%-12s %-8s %-12s %-4s%n", "NAME", "AGE", "NUMBER", "ID");
          for (Person person1 : person) {
                       System.out.printf("%-12s %-8s %-12s %-4s%n", 
                      person1.getNamePerson(), person1.getAgePerson(),
                      person1.getNumberPerson(), person1.getIdPerson());
}
            
       }catch(SQLException e){
           helper.showErrorMessage(e);
           
       }finally{
            connection.close();
        }
        
    }
    
    
    public static void insertOperation() throws SQLException{
        
        Connection connection = null;
        dbHelper dbhelper = new dbHelper();
        PreparedStatement preparedstatement = null;
        ResultSet resultset;
        Scanner scan  = new Scanner(System.in);
        
        
        try{
            connection = dbhelper.getConnection();
            System.out.println("Connected Database for Insert Operation ");
            System.out.print("Enter name : ");
          String  name = scan.next();
            System.out.print("Enter number : ");
          String  number = scan.next();
            System.out.print("Enter age : ");
          String  age = scan.next();
            
            String sql = " insert into java_veritabanı.person (namePerson,numberPerson,agePerson) values(?,?,?)  ";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,name );
            preparedstatement.setString(2, number);
            preparedstatement.setString(3, age);
            System.out.println("Insert Operation is Succesfuly ,  Effected rows : " +preparedstatement.executeUpdate() ); 
            
            
            
        }catch(SQLException e){
        dbhelper.showErrorMessage(e);
    }finally{
            preparedstatement.close();
            connection.close();
        }
        
        
    }
    
    public static void updateOperationn ()throws SQLException {
        
        Connection connection = null;
        dbHelper dbhelper =  new dbHelper();
        PreparedStatement preparedstatement = null;
        ResultSet resultset;
        Scanner scan = new Scanner(System.in);
        
        try{
            connection = dbhelper.getConnection();
            System.out.println("Connected for Update Operation");
            System.out.println("Enter the ID , You Want to Change the Information");
            int id =scan.nextInt();
            System.out.println("Enter Operation Code"
                    + "\nChange Name    1001"
                    + "\nChange Age     1002"
                    + "\nChange Number  1003");
            int code = scan.nextInt();
            if ( (code == 1001 || code == 1002 || code == 1003) ) {
                System.out.println("Enter New Information");
            String newInfo = scan.next();
            String operation = code == 1001 ? "namePerson" : code == 1002 ? "agePerson" :"numberPerson";
            String sql = "update java_veritabanı.person set "+operation + "="+"'"+newInfo+"'"+" where idPerson = " + id ;
           preparedstatement = connection.prepareStatement(sql);
            System.out.println("Update Operation is Succesfuly ,  Effected rows : " +preparedstatement.executeUpdate() );
             
                
            }else{
                System.out.println("Operation code invalid , Returning maın menu");
            }
         
            
        }catch(SQLException e){
            dbhelper.showErrorMessage(e);
           
        }
            
        }
        
        
    
    
    public static void deleteOperation() throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset ;
        dbHelper dbhelper = new dbHelper();
        Scanner scan = new Scanner(System.in);
        
        try{
            
            connection = dbhelper.getConnection();
            System.out.println("Connected Database for Delete Operation \n");
            System.out.println("Please Enter the ID You Want to Delete the Information");
            int id = scan.nextInt();
            
            String sql = "   delete from java_veritabanı.person where idPerson = ? ";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, id);
            System.out.println("Delete Operation is Succesfuly ,  Effected rows : " +preparedstatement.executeUpdate() ); 
            
            
        }catch(SQLException e){
            dbhelper.showErrorMessage(e);
            
        }finally{
            connection.close();
            preparedstatement.close();
        }
        
        
        
    }
           
    
}
