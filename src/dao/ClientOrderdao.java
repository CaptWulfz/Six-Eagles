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
import model.Orders;
import model.OrderDetails;
import model.ingredients;

/**
 *
 * @author Desmond
 */
public class ClientOrderdao {
    public static boolean addnewClientOrder(Orders order){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO orders(PURCHASEORDERNO,CLIENTID,USERID,ORDERDATE,DELIVERYDATE,STATUSID,STATUSDETAILS)VALUES (?,?,?,?,?,?,?)";
        try{

            PreparedStatement p = connect.prepareCall(query);
            
            p.setInt(1,order.getPurchaseOrderNum());
            p.setInt(2,order.getClientID());
            p.setInt(3,order.getUserID());
            p.setString(4,order.getOrderdate());
            p.setString(5,order.getDeliverydate());
            p.setInt(6,order.getStatus());
            p.setString(7,order.getStatusDetails());
       
            
           
            
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
        
    }
    
    public static Orders getClientOrderByPurchaseOrderNum(int num) {
    	Connection c = dbconnect.getDBConnection();
    	String sql = "SELECT * FROM eagle.orders WHERE PurchaseOrderNo = ?;";
    	Orders o = null;
    	
    	try {
    		PreparedStatement p = c.prepareStatement(sql);
    		p.setInt(1, num);
    		ResultSet rs = p.executeQuery();
    		while (rs.next()) {
    			o = new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(8));
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
    	
    	return o;
    }
    
    public static boolean addnewClientOrderDetails(OrderDetails orderdets){
        
        boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO orderdetails (PurchaseOrderno,ProductCode,UnitPrice,QuantityOrdered)VALUES (?,?,?,?)";
        try{

            PreparedStatement p = connect.prepareCall(query);
            
            p.setInt(1,orderdets.getPurchaseOrderNum());
            p.setInt(2,orderdets.getProductCode());
            p.setDouble(3,orderdets.getUnitprice());
            p.setInt(4,orderdets.getQtyOrdered());
           
            
           
            
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
        
    }
    
    public static ArrayList<Orders> viewClientOrder()throws SQLException
        {
            ArrayList<Orders>Orders=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT PURCHASEORDERNO, CLIENTID, DELIVERYRECEIPTNO, ORDERDATE, DELIVERYDATE, STATUSDETAILS FROM eagle.orders Where statusdetails='Processing' or statusdetails='Late';";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 Orders.add(new Orders(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5), rs.getString(6)));
                 
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
        //return ingredients;
        
            
            
            
            return Orders;
    
        }
    
    public static ArrayList<Orders> viewClientOrderdelivered()throws SQLException
        {
            ArrayList<Orders>Orders=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT PURCHASEORDERNO, CLIENTID, DELIVERYRECEIPTNO, ORDERDATE, DELIVERYDATE, STATUSDETAILS FROM eagle.orders Where statusdetails='delivered';";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 Orders.add(new Orders(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5), rs.getString(6)));
                 
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
        //return ingredients;
        
            
            
            
            return Orders;
    
        }
    
    
    public static boolean changestatus(int code, String status)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.orders SET StatusDetails=? WHERE PurchaseOrderNo=?;";
        try{

            PreparedStatement p = connect.prepareCall(query);
            p.setString(1, status);
            p.setInt(2, code);
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
    
        }    
    
    
    public static boolean changedeliveryreceipt(int code, int dcode)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.orders SET DeliveryReceiptNo=? WHERE PurchaseOrderNo=?;";
        String query1="Select ProductCode,quantityordered from orderdetails where PurchaseOrderNo=?";
        try{
          
            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1, dcode);
            p.setInt(2, code);
             PreparedStatement p2 = connect.prepareCall(query1);
             p2.setInt(1,code);
             ResultSet rs=p2.executeQuery();
             while (rs.next()){
                 System.out.println("des");
                 String query2="Update eagle.products set AvailableStock=(AvailableStock-?) where ProductCode=?";
                 PreparedStatement p3 = connect.prepareCall(query2);
                 p3.setInt(1,rs.getInt(2));
                 p3.setInt(2,rs.getInt(1));
                 p3.executeUpdate();
             }
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
    
        }    
    
}
