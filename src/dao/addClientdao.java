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

public class addClientdao {
    
    
    public static boolean addingClient(Client ing){
          boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO CLIENT(CLIENTID,CLIENTNAME,ADDRESS,CITY)VALUES(?,?,?,?)";
        try{
            
            
            
            PreparedStatement p = connect.prepareCall(query);
            p.setInt(1,ing.getClientID());
            p.setString(2,ing.getClientName());
            p.setString(3,ing.getAddress());
            p.setString(4,ing.getCity());
            
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
