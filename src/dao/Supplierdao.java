/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Roano
 */

import java.sql.*;
import java.util.ArrayList;
import model.suppliers;

public class Supplierdao {
    
    public static ArrayList<suppliers> viewSupplier()throws SQLException
        {
            ArrayList<suppliers>Supplier=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT * FROM eagle.suppliers";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                    Supplier.add(new suppliers(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));  
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
 
           return Supplier;
    
        }
    
    public static boolean addingSupplier(suppliers ing){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO SUPPLIERS(SUPPLIERID,SUPPLIERNAME,ADDRESS,CITY,CONTACT)VALUES(?,?,?,?,?)";
        try{
            
            
            
            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1,ing.getSupplierID());
            p.setString(2,ing.getSupplierName());
            p.setString(3,ing.getAddress());
            p.setString(4,ing.getCity());
            p.setString(5,ing.getContact());
            
            
            int confirmed = p.executeUpdate();
            
            if(confirmed!=0){
                x=true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return x;
        
    }
    
    public static String getSupplierNameFromId(int id) {
    	String supplierName = "";
    	Connection c = dbconnect.getDBConnection();
    	String sql = "Select SupplierName FROM eagle.suppliers WHERE SupplierID = ?";
    	try {
    		PreparedStatement ps = c.prepareCall(sql);
    		ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		while (rs.next())
    			supplierName = rs.getString(1);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return supplierName;
    }

    
}
