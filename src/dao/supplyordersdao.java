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
import model.supplyorders;
import model.suppliers;

/**
 * 
 * 
 * 
 * 
 * 
 *
 * @author Joshua Sultan
 */
public class supplyordersdao 
{
	
	public static ArrayList<supplyorders> viewSupplyOrdersByEndDate(String endDate)throws SQLException
    {
        ArrayList<supplyorders>supplyorders=new ArrayList();
        Connection c=dbconnect.getDBConnection();
        String sql="SELECT suppliers.suppliername,suppliers.supplierid, supplyorders.deliveryreceiptno,supplyorders.orderdate,supplyorders.deliverydate,supplyorders.statusdetails,supplyorders.comments, supplyorders.supplyordernum FROM eagle.supplyorders JOIN suppliers ON supplyorders.SupplierID=suppliers.SupplierID where statusdetails='Processing' AND DeliveryDate = ?;";
        
         try
        {
	        PreparedStatement pStmt=c.prepareCall(sql);
	        pStmt.setString(1, endDate);
	        ResultSet rs=pStmt.executeQuery();
         while (rs.next()){
             supplyorders.add(new supplyorders(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
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
         
        return supplyorders;

    }
	
	public static void checkForLateOrders(String dateToday) throws SQLException {
		Connection c = dbconnect.getDBConnection();
		String sql = "UPDATE eagle.supplyorders SET StatusDetails = 'Late' WHERE StatusDetails = 'Processing' AND DeliveryDate < ?;";
		
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, dateToday);
		p.executeUpdate();
		
		c.close();
	}
	
	public static ArrayList<supplyorders> viewSupplyOrdersByRange(String startDate, String endDate)throws SQLException {
        ArrayList<supplyorders>supplyorders=new ArrayList<supplyorders>();
        Connection c=dbconnect.getDBConnection();
        String sql="SELECT suppliers.suppliername,suppliers.supplierid, supplyorders.deliveryreceiptno,supplyorders.orderdate,supplyorders.deliverydate,supplyorders.statusdetails,supplyorders.comments, supplyorders.supplyordernum FROM eagle.supplyorders JOIN suppliers ON supplyorders.SupplierID=suppliers.SupplierID where statusdetails='processing' AND DeliveryDate >= ? AND DeliveryDate <= ?;";
        
         try {
	        PreparedStatement pStmt=c.prepareCall(sql);
	        pStmt.setString(1, startDate);
	        pStmt.setString(2, endDate);
	        ResultSet rs=pStmt.executeQuery();
	        while (rs.next())
	        	supplyorders.add(new supplyorders(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(c!=null) { 
            	try {
                    c.close();
                } catch(Exception e){
                	e.printStackTrace();
                }
            }
        }
         
        return supplyorders;

    }
	
    public static ArrayList<supplyorders> viewSupplyOrders()throws SQLException
        {
            ArrayList<supplyorders>supplyorders=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT suppliers.suppliername,suppliers.supplierid, supplyorders.deliveryreceiptno,supplyorders.orderdate,supplyorders.deliverydate,supplyorders.statusdetails,supplyorders.comments, supplyorders.supplyordernum FROM eagle.supplyorders JOIN suppliers ON supplyorders.SupplierID=suppliers.SupplierID where statusdetails='processing' or statusdetails='late';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 supplyorders.add(new supplyorders(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
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
             
            return supplyorders;
    
        }
    
    public static ArrayList<supplyorders> viewSupplyOrdersdelivered()throws SQLException
        {
            ArrayList<supplyorders>supplyorders=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT suppliers.suppliername,suppliers.supplierid, supplyorders.deliveryreceiptno,supplyorders.orderdate,supplyorders.deliverydate,supplyorders.statusdetails,supplyorders.comments, supplyorders.supplyordernum FROM eagle.supplyorders JOIN suppliers ON supplyorders.SupplierID=suppliers.SupplierID where statusdetails='delivered';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 supplyorders.add(new supplyorders(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
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
        
            
            
            
            return supplyorders;
    
        }
    	
    	public static supplyorders getSupplyOrderBySupplyOrderNum(int num) {
    		Connection c = dbconnect.getDBConnection();
    		String sql = "SELECT * FROM eagle.supplyorders WHERE SupplyOrderNum = ?;";
    		supplyorders sp = null;
    		
    		try {
    			PreparedStatement p = c.prepareStatement(sql);
    			p.setInt(1, num);
    			ResultSet rs = p.executeQuery();
    			while (rs.next()) {
    				sp = new supplyorders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(7));
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
    		
    		return sp;
    	}
    
        public static boolean addingSupplyOrder(supplyorders asp){
              boolean x = false;

            Connection connect = dbconnect.getDBConnection();
            String query ="INSERT INTO SUPPLYORDERS(SupplyOrderNum, SupplierID, OrderDate, DeliveryDate,StatusID,StatusDetails,Comments)VALUES(?, ?, ?, ?, ?, ?, ?)";
            try{

            	
                PreparedStatement p = connect.prepareCall(query);
                
                p.setInt(1,asp.getSupplyOrderNum());
                p.setInt(2, asp.getSupplierID());
                p.setString(3,asp.getOrderDate());
                p.setString(4,asp.getDeliveryDate());
                p.setInt(5,2);
                p.setString(6,"Processing");
                p.setString(7,asp.getComments());
                



                int confirmed = p.executeUpdate();

                if(confirmed!=0){
                    x=true;
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return x;

        }
        
        public static boolean changestatus(int code, String status)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.supplyorders SET StatusDetails=? WHERE SupplyOrderNum=?;";
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
        String query ="UPDATE eagle.supplyorders SET DeliveryReceiptNo=? WHERE supplyordernum=?;";
        //String query1="Select ProductCode,quantityordered from orderdetails where PurchaseOrderNo=?";
        try{
          
            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1, dcode);
            p.setInt(2, code);
             //PreparedStatement p2 = connect.prepareCall(query1);
             //p2.setInt(1,code);
             //ResultSet rs=p2.executeQuery();
             //while (rs.next()){
              //   System.out.println("des");
                // String query2="Update eagle.products set AvailableStock=(AvailableStock-?) where ProductCode=?";
               //  PreparedStatement p3 = connect.prepareCall(query2);
               //  p3.setInt(1,rs.getInt(2));
               //  p3.setInt(2,rs.getInt(1));
                // p3.executeUpdate();
             //}
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
