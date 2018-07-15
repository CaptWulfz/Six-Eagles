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
import model.InvenRepProd;
import model.InvenRepRaw;
import servlet.ReportsServ;



/**
 *
 * @author AJ's Laptop
 */
public class invenRepdao {
    
    
    public static ArrayList<InvenRepRaw> viewInvenRaw(String Start, String End)throws SQLException
        {
            ArrayList<InvenRepRaw>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT audit_id, ID, auditname, RW_Quantity, audit_timelog FROM eagle.rw_audit where audit_timelog BETWEEN (?) AND (?);"; 
            
            
             try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1,Start);
            p.setString(2,End);
            
            
            
            ResultSet rs=p.executeQuery();
            
          //  check = rs.next();
            
            
             while (rs.next()){
                    Client.add(new InvenRepRaw(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
                }
               
          //  if(check == true){
            //    Client.add(new invenRep(1, 101,"King",10,"Testing"));
           // }   
            
            
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
    public static ArrayList<InvenRepIng> viewInvenIng(String Start, String End)throws SQLException
        {
            ArrayList<InvenRepIng>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT audit_id, ID, auditNameIng, Quantity, audit_timelog FROM eagle.ing_audit where audit_timelog BETWEEN (?) AND (?);"; 
            
            
             try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1,Start);
            p.setString(2,End);
            
            
            
            ResultSet rs=p.executeQuery();
            
          //  check = rs.next();
            
            
             while (rs.next()){
                    Client.add(new InvenRepIng(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
                }
               
          //  if(check == true){
            //    Client.add(new invenRep(1, 101,"King",10,"Testing"));
           // }   
            
            
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
    public static ArrayList<InvenRepProd> viewInvenProd(String Start, String End)throws SQLException
        {
            ArrayList<InvenRepProd>Client=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT audit_id, ID, auditNameProd,Quantity, audit_timelog FROM eagle.prod_audit where audit_timelog BETWEEN (?) AND (?);"; 
            
            
             try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1,Start);
            p.setString(2,End);
            
            
            
            ResultSet rs=p.executeQuery();
            
          //  check = rs.next();
            
            
             while (rs.next()){
                    Client.add(new InvenRepProd(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
                }
               
          //  if(check == true){
            //    Client.add(new invenRep(1, 101,"King",10,"Testing"));
           // }   
            
            
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
    
    
   
    
}
