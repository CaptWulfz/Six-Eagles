/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.OrderDetails;

/**
 *
 * @author Desmond
 */
public class orderdetailsdao {
    public static ArrayList<OrderDetails> vieworderdetails(int code)throws SQLException
        {
            ArrayList<OrderDetails>OrderDetails=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT PRODUCTCODE, UNITPRICE, QUANTITYORDERED FROM eagle.orderdetails WHERE PurchaseOrderNo = ?";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,code);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 OrderDetails.add(new OrderDetails(rs.getInt(1),rs.getDouble(2),rs.getInt(3)));
                 
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
        //return ingredients;
        
            
            
            
            return OrderDetails;
    
        }
    
}
