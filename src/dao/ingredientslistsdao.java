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

public class ingredientslistsdao {
    public static boolean addingingredientslist(ingredientslists ing){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO INGREDIENTLISTS(AMOUNT,UNITOFMEASUREMENT,PRODUCTCODE,INGREDIENTCODE,INGREDIENTNAME)VALUES (?,?,?,?,?)";
        try{

            PreparedStatement p = connect.prepareCall(query);
            
            
            
            p.setDouble(1,ing.getAmount());
            p.setString(2,ing.getUnitOfMeasurement());
            p.setInt(3,ing.getProductCode());
            p.setInt(4,ing.getIngredientCode());
            p.setString(5,ing.getName());
           
            
            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }
           
           
           
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
        
    }
    
    public static ArrayList<ingredientslists> viewproductingredient(int code)throws SQLException
        {
            ArrayList<ingredientslists>ingredientslists=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT IngredientCode, IngredientName, UnitOfMeasurement, Amount FROM eagle.ingredientlists WHERE Productcode = ?";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,code);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 ingredientslists.add(new ingredientslists(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
                 
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
        
            
            
            
            return ingredientslists;
    
        }
    
    public static String viewingredientname(int IGcode)throws SQLException
        {
            String name="";
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT max(ingredients.ingredientname) FROM eagle.ingredientlists inner join eagle.ingredients on ingredientlists.ingredientcode=ingredients.ingredientcode where ingredients.ingredientcode = ?;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,IGcode);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                name=rs.getString(1);
                 
             }
             //System.out.println("good1");
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
            
            return name;
    
        }
    
    public static String viewingredientnamemodal(int IGcode)throws SQLException
        {
            String name=null;
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT ingredients.ingredientname FROM eagle.ingredientlists inner join eagle.ingredients on ingredientlists.ingredientcode=ingredients.ingredientcode where ingredients.ingredientcode = ?;";
            
             
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,IGcode);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                name=rs.getString(1);
                 
             }
             
             //System.out.println("good1");
            
        //return ingredients;
        
            
            
            
            return name;
    
        }
        
    
}
