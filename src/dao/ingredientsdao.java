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
import model.ingredients;

public class ingredientsdao {
    
     public static boolean addNewIngredients(ingredients ing){
        boolean b=false;
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO INGREDIENTS(INGREDIENTNAME,STOCK,THRESHOLD,CEILING,UNITOFMEASUREMENT)VALUES(?,?,?,?,?)";
        try{
            /*
            System.out.println(name);
            System.out.println(availablestock);
            System.out.println(threshold);
            System.out.println(ceiling);
            System.out.println(unitofmeasurement);
            */
            PreparedStatement p = connect.prepareCall(query);
            p.setString(1,ing.getIngredientName());
            p.setDouble(2,ing.getStock());
            p.setInt(3,ing.getThreshold());
            p.setInt(4,ing.getCeiling());
            p.setString(5,ing.getUnitOfMeasurement());
            
            int confirmed = p.executeUpdate();
            System.out.print(confirmed);
            
            
            
            if(confirmed!=0){
                b=true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
        return b;
    }
    
     public static boolean addingredient(String name, double availablestock, int threshold, int ceiling, String unitofmeasurement){
        
        boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO INGREDIENTS(INGREDIENTNAME,AVAILABLESTOCK,THRESHOLD,CEILING,UNITOFMEASUREMENT)VALUES(?,?,?,?,?)";
        try{
            
            System.out.println(name);
            System.out.println(availablestock);
            System.out.println(threshold);
            System.out.println(ceiling);
            System.out.println(unitofmeasurement);
            
            PreparedStatement p = connect.prepareCall(query);
            p.setString(1,name);
            p.setDouble(2,availablestock);
            p.setInt(3,threshold);
            p.setInt(4,ceiling);
            p.setString(5,unitofmeasurement);
            
            int confirmed = p.executeUpdate();
            
            if(confirmed!=0){
                x=true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return x;
        
    }
    
    public static ingredients getIngredientByName(String key) throws SQLException {
    	ingredients ingr = null;
		Connection c = dbconnect.getDBConnection();
		String sql="SELECT IngredientCode, IngredientName, Stock, Threshold, Ceiling, UnitOfMeasurement FROM eagle.ingredients WHERE status = 'active' AND IngredientName = '" + key + "';";

		 try {
			 PreparedStatement pStmt=c.prepareCall(sql);
			 ResultSet rs=pStmt.executeQuery();
			 while (rs.next())
				 ingr = new ingredients(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 if (c != null) {
				 try
                 {
                     c.close();
                 }catch(Exception e){}
			 }
		 }
		 
    	return ingr;
    }
   
    public static ArrayList<ingredients> viewIngredientactive()throws SQLException
        {
            ArrayList<ingredients>ingredients=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT IngredientCode, IngredientName, Stock, Threshold, Ceiling, UnitOfMeasurement FROM eagle.ingredients WHERE status = 'active';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 ingredients.add(new ingredients(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
                 
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
        //return ingredients;
            return ingredients;
    
        }
    
    public static ArrayList<ingredients> viewIngredientdeactive()throws SQLException
        {
            ArrayList<ingredients>ingredients=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT IngredientCode, IngredientName, Stock, Threshold, Ceiling, UnitOfMeasurement FROM eagle.ingredients WHERE status = 'deactive';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 ingredients.add(new ingredients(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
                 
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
        
            
            
            
            return ingredients;
    
        }
    
    public static boolean deactivateingredient(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.ingredients SET Status='deactive' WHERE IngredientCode=?;";
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
    
    public static boolean reactivateingredient(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.ingredients SET Status='active' WHERE IngredientCode=?;";
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
    
}
