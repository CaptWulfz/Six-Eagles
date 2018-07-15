/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.*;
import java.util.ArrayList;
import model.product;
import model.rawmaterials;
/**
 *
 * @author Roano
 */
public class productdao {
    public static boolean addNewProduct(product ing){
        boolean b=false;
        Connection connect = dbconnect.getDBConnection();
        String query ="INSERT INTO PRODUCTS(PRODUCTNAME, PRODUCTPRICE, AVAILABLESTOCK, THRESHOLD, CEILING)VALUES(?,?,?,?,?)";
        try{
            PreparedStatement p = connect.prepareCall(query);
            //p.setInt(1,ing.getProductcode());
            p.setString(1,ing.getProductname());
            p.setDouble(2,ing.getProductprice());
            p.setInt(3,ing.getStock());
            p.setInt(4,ing.getThreshold());
            p.setInt(5,ing.getCeiling());
            
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
    
    public static ArrayList<product> viewproductactive()throws SQLException
        {
            ArrayList<product>product=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT ProductCode, ProductName, ProductPrice, AvailableStock, Threshold, Ceiling FROM eagle.products WHERE status ='active';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 product.add(new product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
                 
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
        
            
            
            
            return product;
    
        }
    
    public static ArrayList<product> viewproductdeactive()throws SQLException
        {
            ArrayList<product>product=new ArrayList();
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT ProductCode, ProductName, ProductPrice, AvailableStock, Threshold, Ceiling FROM eagle.products WHERE status ='deactive';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 product.add(new product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
                 
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
        
            
            
            
            return product;
    
        }
    
    public static boolean deactivateproduct(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.products SET Status='deactive' WHERE ProductCode=?;";
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
    
    
    public static boolean reactivateproduct(int code)throws SQLException
        {
            boolean x = false;
        
        Connection connect = dbconnect.getDBConnection();
        String query ="UPDATE eagle.products SET Status='active' WHERE ProductCode=?;";
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
    
    public static int viewproduct()throws SQLException
        {
            int code=0;
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT MAX(PRODUCTCODE) FROM eagle.products WHERE status ='active';";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                code=rs.getInt(1);
                 
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
        
            
            
            
            return code;
    
        }
    
    public static String viewproductname()throws SQLException
        {
            String name="";
            Connection c=dbconnect.getDBConnection();
            String sql="SELECT PRODUCTNAME FROM eagle.products WHERE status ='active' ORDER BY productcode DESC LIMIT 1;";
            
             try
            {
            
            PreparedStatement pStmt=c.prepareCall(sql);
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
        //return ingredients;
        
            
            
            
            return name;
    
        }
    
    public static product getProduct(int ProductCode)throws SQLException{
         
            Connection c=dbconnect.getDBConnection();
            product product= null;
            String sql="SELECT ProductCode, ProductName, ProductPrice, AvailableStock, Threshold, Ceiling FROM eagle.products where ProductCode=?;";
            
          try
            {
            
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1,ProductCode);
            ResultSet rs=p.executeQuery();
             if (rs.next()){
                 product=new product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
                 
             }
             
             //System.out.println("good1");
            }catch(SQLException e){
            
                e.addSuppressed(e);
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(SQLException e){}
                }
            }
        //return ingredients;
        
            
            
            
            return product;
    
}
    
    public static boolean makeProduct(int Pcode, int qty)throws SQLException
    {
         System.out.println("E");
        Connection connect = dbconnect.getDBConnection();
        boolean x=false;
       
        
        String query ="Select * From Products where ProductCode=?";
        try{
            
            System.out.println("B");
        PreparedStatement p = connect.prepareCall(query);
        p.setInt(1,Pcode);
         ResultSet rs = p.executeQuery();
        
            
            if(rs.next()){
                System.out.println("A");
                String query2="SELECT Amount,Stock  FROM eagle.ingredientlists join ingredients on ingredients.IngredientCode= ingredientlists.IngredientCode where ProductCode=?";
                 PreparedStatement p2 = connect.prepareCall(query2);
                 p2.setInt(1,Pcode);
                 ResultSet rs2 = p2.executeQuery();
                 while (rs2.next())
                 {
                     System.out.println("C");
                     if((rs2.getDouble(1)*qty)>rs2.getDouble(2))
                     {
                         System.out.println("EABIII");
                        return false;
                     }
                        
                   
                 }
                
                 String query3="SELECT  ingredients.IngredientCode,Amount,Stock  FROM eagle.ingredientlists join ingredients on ingredients.IngredientCode= ingredientlists.IngredientCode where ProductCode=?";
                 PreparedStatement p3 = connect.prepareCall(query3);
                  p3.setInt(1,Pcode);
                 ResultSet rs3 = p3.executeQuery();
                 while (rs3.next()){
                     String updatequery="Update ingredients set Stock = ? - (?*?) where IngredientCode=?"; 
                      int Icode=rs3.getInt(1);
                      double listamount=rs3.getDouble(2);
                      PreparedStatement p4 = connect.prepareCall(updatequery);
                      p4.setDouble(1,rs3.getDouble(3));
                      p4.setDouble(2,listamount);
                      p4.setInt(3,qty);
                      p4.setInt(4,Icode);
                      p4.executeUpdate();
                      subtractrawmats(Icode,listamount );
                 }
                   String query4="Update Products set Products.AvailableStock = Products.AvailableStock + ? where ProductCode=?";
                   PreparedStatement p5 = connect.prepareCall(query4);
                   p5.setInt(1,qty);
                   p5.setInt(2,Pcode);
                   p5.executeUpdate();
                   x=true;
                   
                 
            }
            else{
                 x=false;
            }
        }
        catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(connect!=null)
                { 
                    try
                    {
                        connect.close();
                    }catch(Exception e){}
                }
            }
    
 return x;       
}

    
 
    public static void subtractrawmats(int ingCode,double amount)throws SQLException{
        Connection connect=dbconnect.getDBConnection();
        //ArrayList <rawmaterials> raws= new ArrayList();
        String query2="Select RawMaterialCode, PackagingAmount, Amount, UnitOfMeasurement from eagle.rawmaterials where Ingredientcode=?";
        try {
            PreparedStatement p2 = connect.prepareCall(query2);
                 p2.setInt(1,ingCode);
                 ResultSet rs2 = p2.executeQuery();
                 while (rs2.next()&& amount !=0){
                    // raws.add(new rawmaterials(rs2.getInt(1),rs2.getDouble(2),rs2.getDouble(3),rs2.getString(4)));
                    double Pmount=rs2.getDouble(2);
                    double Trouble=Pmount*rs2.getDouble(3);
                    if (amount<=Trouble){
                        
                        String Query3= "Update eagle.rawmaterials set Amount = ?   where RawMaterialCode=?"; 
                        double setmount=Trouble/Pmount;     
                          PreparedStatement p3 = connect.prepareCall(Query3);
                          p3.setDouble(1,setmount);
                          p3.setInt(2,rs2.getInt(1));
                            p3.executeUpdate();
                          
                    }
                    else{
                         String Query3= "Update eagle.rawmaterials set Amount = 0   where RawMaterialCode=?";
                         PreparedStatement p3 = connect.prepareCall(Query3);
                          p3.setInt(2,rs2.getInt(1));
                        amount= amount-Trouble;
                    }
                 }
        } catch (Exception e) {
        }
        
      
        
    }
    
}
