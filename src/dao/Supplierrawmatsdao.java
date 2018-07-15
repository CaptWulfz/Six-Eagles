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
import model.*;

/**
 *
 * @author Roano
 */
public class Supplierrawmatsdao {
    
    public static boolean addsupplierlist(supplierlists ing){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO SUPPLIERLISTS(SUPPLIERID,RAWMATERIALCODE)VALUES (?,?);";
        try{

            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1,ing.getSupplierID());
           // p.setInt(2,ing.getRawmatscode());

            int confirmed = p.executeUpdate();
            
           if(confirmed!=0){
               x=true;
           }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return x;
        
    }
    
    
    public static ArrayList<supplierlists> viewrawmatssupplier(int code)throws SQLException
        {
            ArrayList<supplierlists>supplierlists=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT suppliers.SupplierName,rawmaterials.IngredientBrand, rawmaterials.RawMaterialCode FROM eagle.supplierlists join eagle.suppliers on supplierlists.SupplierID=suppliers.SupplierID join eagle.rawmaterials on supplierlists.RawMaterialCode=rawmaterials.RawMaterialCode WHERE SUPPLIERLISTS.SUPPLIERID=?;";
            
            try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            pStmt.setInt(1,code);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                // supplierlists.add(new supplierlists(rs.getString(1),rs.getString(2),rs.getInt(3)));
                 
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
        
            
            
            
            return supplierlists;
    
        }
    
    
}
