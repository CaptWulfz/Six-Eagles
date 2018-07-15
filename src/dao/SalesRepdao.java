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
import model.salesRep;
import servlet.ReportsServ;

public class SalesRepdao {
    public static ArrayList<salesRep> viewSales(String Start, String End)throws SQLException
        {
            ArrayList<salesRep>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT  products.ProductCode, products.ProductName,SUM(orderdetails.QuantityOrdered) as Total "
                    + "FROM eagle.products Inner Join eagle.orderdetails "
                    + "Inner Join eagle.orders Where orderdetails.ProductCode=products.ProductCode "
                    + "and orderdetails.PurchaseOrderNo=orders.PurchaseOrderNo "
                    + "and orders.DeliveryDate between (?) and (?)"
                    + "Group By ProductCode;"; 
             try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1,Start);
            p.setString(2,End);
            
            ResultSet rs=p.executeQuery();
             while (rs.next()){
                    Client.add(new salesRep(rs.getString(1),rs.getString(2),rs.getInt(3)));
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

            return Client;
        }
public static ArrayList<salesRep> viewSales2(String Start, String End)throws SQLException
        {
            ArrayList<salesRep>Client2=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT  products.ProductCode,products.ProductName,DeliveryDate,orderdetails.QuantityOrdered "
                    + "FROM eagle.products "
                    + "Inner Join eagle.orderdetails "
                    + "Inner Join eagle.orders "
                    + "Where orderdetails.ProductCode=products.ProductCode "
                    + "and orderdetails.PurchaseOrderNo=orders.PurchaseOrderNo "
                    + "and orders.DeliveryDate between (?) and (?) "
                    + "Group By orders.PurchaseOrderNo "
                    + "Order By ProductCode;"; 
             try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1,Start);
            p.setString(2,End);
            ResultSet rs=p.executeQuery();
             while (rs.next()){
                    Client2.add(new salesRep(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
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

            return Client2;
    
        }
}    