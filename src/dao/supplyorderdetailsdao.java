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

import java.util.ArrayList;
import java.sql.*;
import model.*;
import temporary_models.SupplyOrderItem;

public class supplyorderdetailsdao {
    public static ArrayList<supplyorderdetails> viewsupplyorderdetails(int code)throws SQLException
        {
            ArrayList<supplyorderdetails>supplyorderdetails=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT * FROM eagle.supplyorderdetails WHERE supplyordernum = ?";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,code);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 supplyorderdetails.add(new supplyorderdetails(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4)));
                 
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
            
            return supplyorderdetails;
    
        }
    
    public static void AddSupplyOrderDetails(SupplyOrderItem item) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "INSERT INTO eagle.supplyorderdetails (SupplyOrderNum, IngredientCode, QuantityOrdered, UnitOfMeasurement) VALUES(?, ?, ?, ?);";
    	
    	supplyorders sb = item.getSupplyOrders();
    	ingredients ingr = item.getIngredient();
    	
    	try {
    		PreparedStatement ps = c.prepareCall(sql);
    		ps.setInt(1, sb.getSupplyOrderNum());
    		ps.setInt(2, ingr.getIngredientCode());
    		ps.setInt(3, item.getQuantity());
    		ps.setString(4, ingr.getUnitOfMeasurement());
    		
    		ps.executeUpdate();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
