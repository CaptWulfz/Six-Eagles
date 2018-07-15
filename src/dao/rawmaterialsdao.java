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
import model.ingredients;
import model.rawmaterials;

/**
 *
 * @author Joshua Sultan
 */
public class rawmaterialsdao 
{
public static ArrayList<rawmaterials> viewRaw()throws SQLException
        {
            ArrayList<rawmaterials>rawmaterials=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT Ingredientbrand, PackagingAmount, Packaging, Amount, UnitOfMeasurement, Rawmaterialcode FROM eagle.rawmaterials WHERE status = 'active';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 rawmaterials.add(new rawmaterials(rs.getInt(6),rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
                 
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
        
            
            
            
            return rawmaterials;
    
        }  

public static rawmaterials getRawMaterialByName(String key) throws SQLException {
	rawmaterials rawm = null;
	Connection c = dbconnect.getDBConnection();
	String sql="SELECT Ingredientbrand, PackagingAmount, Packaging, Amount, UnitOfMeasurement, Rawmaterialcode FROM eagle.rawmaterials WHERE status = 'active' AND IngredientBrand = '" + key + "';";
	
	try {
		 PreparedStatement pStmt=c.prepareCall(sql);
		 ResultSet rs=pStmt.executeQuery();
		 while (rs.next())
			 rawm = new rawmaterials(rs.getInt(6),rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {}
		}
	}
	
	return rawm;
}

public static ArrayList<rawmaterials> viewRawDeactive()throws SQLException
        {
            ArrayList<rawmaterials>rawmaterials=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT Ingredientbrand, PackagingAmount, Packaging, Amount, UnitOfMeasurement, Rawmaterialcode FROM eagle.rawmaterials WHERE status = 'deactive';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 rawmaterials.add(new rawmaterials(rs.getInt(6),rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
                 
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
        
            
            
            
            return rawmaterials;
    
        }


public static boolean deactivaterawmats(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.rawmaterials SET Status='deactive' WHERE RawMaterialCode=?;";
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

public static boolean reactivaterawmats(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.rawmaterials SET Status='active' WHERE RawMaterialCode=?;";
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


