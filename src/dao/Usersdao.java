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
               
                US.setUserId(rs.getInt(1));
                US.setUserhash(rs.getString(8));
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
    	    	//u = new Users(rs.getInt(2), rs.getString(3), rs.getString(4));
    	    	u = new Users(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
    	    	u.setUserId(rs.getInt(1));
    	    	u.setUserhash(rs.getString(8));
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
    
    public static Users getUserByUsername(String username) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "SELECT * FROM eagle.users WHERE Username = ?;";
    	
    	Users u = null;
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    		p.setString(1, username);
    		ResultSet rs = p.executeQuery();
    		if (rs != null) {
	    		while (rs.next()) {
	    			u = new Users(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		    		u.setUserId(rs.getInt(1));
		    		u.setUserhash(rs.getString(8));
	    		}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			c.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return u;
    }
    
    public static void updateUserHash(Users u) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "UPDATE eagle.users SET Userhash = ? WHERE UserID = ?";
    	
    	System.out.println(sql);
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    		p.setString(1, u.getUserhash());
    		p.setInt(2, u.getUserId());
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
    
    public static void addUser(Users u) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "INSERT INTO eagle.users (Firstname, Lastname, Username, Password, Position, Address) VALUES (?, ?, ?, ?, ?, ?);";
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    		p.setString(1, u.getFirstname());
    		p.setString(2, u.getLastname());
    		p.setString(3,  u.getUsername());
    		p.setString(4, u.getPassword());
    		p.setString(5, u.getPosition());
    		p.setString(6, u.getAddress());
    		
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
