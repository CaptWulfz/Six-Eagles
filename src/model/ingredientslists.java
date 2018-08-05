/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Desmond
 */
public class ingredientslists {

    /**
     * @return the Name
     */
    
   private int ProductCode;
   private int IngredientCode;
   private double Amount;
   private String UnitOfMeasurement;
   private String Name;
   
   public ingredientslists(int ProductCode, int IngredientCode, double Amount, String Uom,String Name){
       this.ProductCode=ProductCode;
       this.IngredientCode=IngredientCode;
       this.Amount=Amount;
       this.UnitOfMeasurement=Uom;
       this.Name=Name;
       
   }
   
   public ingredientslists(int IngredientCode, String Name, String Uom, double Amount){
       this.Name=Name;
       this.IngredientCode=IngredientCode;
       this.Amount=Amount;
       this.UnitOfMeasurement=Uom;
   }
   
  // public ingredientslists(int )

    /**
     * @return the ProductCode
     */
    public int getProductCode() {
        return ProductCode;
    }

    /**
     * @param ProductCode the ProductCode to set
     */
    public void setProductCode(int ProductCode) {
        this.ProductCode = ProductCode;
    }

    /**
     * @return the IngredientCode
     */
    public int getIngredientCode() {
        return IngredientCode;
    }

    /**
     * @param IngredientCode the IngredientCode to set
     */
    public void setIngredientCode(int IngredientCode) {
        this.IngredientCode = IngredientCode;
    }

    /**
     * @return the Amount
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the UnitOfMeasurement
     */
    public String getUnitOfMeasurement() {
        return UnitOfMeasurement;
    }

    /**
     * @param UnitOfMeasurement the UnitOfMeasurement to set
     */
    public void setUnitOfMeasurement(String UnitOfMeasurement) {
        this.UnitOfMeasurement = UnitOfMeasurement;
    }
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
   
    
}
