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

public class supplyorderdetailsdao {
    public static ArrayList<supplyorderdetails> viewsupplyorderdetails(int code)throws SQLException
        {
            ArrayList<supplyorderdetails>supplyorderdetails=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT SUPPLYORDERNUM,RAWMATERIALCODE,QUANTITYORDERED,UNITOFMEASUREMENT FROM eagle.supplyorderdetails WHERE supplyordernum = ?";
            
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
    
    public static void AddSupplyOrderDetails(supplyorders sb) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "INSERT INTO eagle.supplyorderdetails (";
    }
}
