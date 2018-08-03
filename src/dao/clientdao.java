/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Droilan Alvarez
 */

import java.sql.*;
import java.util.ArrayList;
import model.Client;


public class clientdao {
	
	public static Client getClientByID(int id) throws SQLException {
		Client cl = null;
		Connection c = dbconnect.getDBConnection();
        String sql="SELECT * FROM eagle.client WHERE ClientID = ?;";
        
        try {
        	PreparedStatement p = c.prepareStatement(sql);
        	p.setInt(1, id);
        	ResultSet rs = p.executeQuery();
        	while (rs.next()) {
        		cl = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	try {
        		c.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        
        return cl;
	}
	
    public static ArrayList<Client> viewClientactive()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT * FROM eagle.client WHERE status = 'active'";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
        
            
            
            
            return Client;
    
        }
    
    public static ArrayList<Client> viewClientdeactive()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT * FROM eagle.client WHERE status = 'deactive'";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
        
            
            
            
            return Client;
    
        }
    
    public static ArrayList<Client> getClientName()throws SQLException
        {
            ArrayList<Client>Clients=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT CientName FROM eagle.client";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Clients.add(new Client(rs.getString(1)));
                 
             }
             
            
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
        
            
            
            
            return Clients ;
    
        }
    
    public static boolean deactivateclient(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.client SET Status='deactive' WHERE ClientID=?;";
        try{

            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1, code);
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
    
        }    
    
    public static boolean reactivateclient(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.client SET Status='active' WHERE ClientID=?;";
        try{

            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1, code);
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
    
        }    
    
    public static ArrayList<Client> viewDescClient()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="Select ClientName,Address,City FROM eagle.client WHERE status = 'active' ORDER BY ClientName DESC;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getString(1),rs.getString(2),rs.getString(3)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
            
            
            
            return Client;
    
        }
    public static ArrayList<Client> viewAscClient()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="Select ClientName,Address,City FROM eagle.client WHERE status = 'active' ORDER BY ClientName ASC;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getString(1),rs.getString(2),rs.getString(3)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
            
            
            
            return Client;
    
        }

public static ArrayList<Client> viewDescCity()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT ClientName,Address,City FROM eagle.client WHERE status = 'active' ORDER BY City DESC;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getString(1),rs.getString(2),rs.getString(3)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
            
            
            
            return Client;
    
        }
public static ArrayList<Client> viewAscCity()throws SQLException
        {
            ArrayList<Client>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT ClientName,Address,City FROM eagle.client WHERE status = 'active' ORDER BY City ASC;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Client.add(new Client(rs.getString(1),rs.getString(2),rs.getString(3)));
                 
             }
             
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
        //return Client;
            
            
            
            return Client;
    
        }
        public static int getValue(int x){
            return x;
        }
    
}
