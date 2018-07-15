/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Desmond
 */
import java.sql.*;
import java.util.ArrayList;
import model.Products;
public class Productsdao {
    public static ArrayList<Products> viewProd()throws SQLException
        {
            ArrayList<Products>prods=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT * FROM eagle.Products;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 prods.add(new Products(rs.getString(1),rs.getDouble(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
                 
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
        
            
            
            
            return prods;
        }
        
}
