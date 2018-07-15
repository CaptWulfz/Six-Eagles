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

public class Addrawmatsdao {
    
    
    public static boolean addingrawmats(rawmaterials ing){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO RAWMATERIALS(INGREDIENTCODE,INGREDIENTBRAND,PACKAGINGAMOUNT,PACKAGING,AMOUNT,UNITOFMEASUREMENT)VALUES (?,?,?,?,?,?)";
        try{

            PreparedStatement p = connect.prepareCall(query);
            
            
            p.setInt(1,ing.getIngredientCode());
            p.setString(2,ing.getIngredientBrand());
            p.setDouble(3,ing.getPackagingAmount());
            p.setString(4,ing.getPackaging());
            p.setDouble(5,ing.getAmount());
            p.setString(6,ing.getUnitOfMeasurement());
            
           
            
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
