

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 
 */ 
import java.sql.*;

import java.util.ArrayList;
public class dbconnect {
    
    private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/eagle";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="";
    
    public static Connection getDBConnection(){
        Connection connect=null;
        try{
            Class.forName(DRIVER_NAME);
            connect=DriverManager.getConnection(JDBC_URL,DB_USER, DB_PASSWORD);
            return connect;
        
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    return connect;
        
    }
}