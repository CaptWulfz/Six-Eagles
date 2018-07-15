/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.ArrayList;

import model.Users;



/**
 *
 * @author Desmond
 */
public class Usersdao {
    
    
    public static Users Checklogin(Users US){
        
        Users b=null;
        Connection c=dbconnect.getDBConnection();
        String sql="SELECT * FROM eagle.users Where Username=? and Password=?";
        try{
        PreparedStatement p = c.prepareStatement(sql);
       
        p.setString(1,US.getUsername());
        p.setString(2,US.getPassword());
         ResultSet rs = p.executeQuery();
            if(rs.next()){
               
                US.setStaffId(rs.getInt(2));
                US.setUserhash(rs.getString(5));
                b=US;
            }
            
        }   
        catch(Exception ex){
            ex.printStackTrace();
        }
        return b;
    }
    
    public static ArrayList<Users> getAllUsers() {
    	ArrayList<Users> usersList = new ArrayList<Users>();
    	Users u;
    	Connection c = dbconnect.getDBConnection();
    	String sql = "SELECT * FROM eagle.users;";
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    	    ResultSet rs = p.executeQuery();
    	    while (rs.next()) {
    	    	u = new Users(rs.getInt(2), rs.getString(3), rs.getString(4));
    	    	u.setUserhash(rs.getString(5));
    	    	usersList.add(u);
    	    }
    	} catch(Exception ex){
                ex.printStackTrace();
    	} finally {
    		try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
        return usersList;
    }
    
    public static void updateUserHash(Users u) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "UPDATE eagle.users SET Userhash = ? WHERE StaffID = ?";
    	
    	System.out.println(sql);
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    		p.setString(1, u.getUserhash());
    		p.setInt(2, u.getStaffId());
    		p.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			c.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    
}
