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
public class ingredients {
    private int IngredientCode;
    private String IngredientName;
    private double Stock;
    private int Threshold;
    private int Ceiling;
    private String UnitOfMeasurement;
    
    public ingredients(int IC,String IN, double Stock, int Threshold, int Ceiling, String UnitOfMeasurement){
        
        this.IngredientCode=IC;
        this.IngredientName=IN;
        this.Stock=Stock;
        this.Threshold=Threshold;
        this.Ceiling=Ceiling;
        this.UnitOfMeasurement=UnitOfMeasurement;
        
    }

    
    public ingredients(String IN, double Stock, int Threshold, int Ceiling, String UnitOfMeasurement){
        
        //this.IngredientCode=IC;
        this.IngredientName=IN;
        this.Stock=Stock;
        this.Threshold=Threshold;
        this.Ceiling=Ceiling;
        this.UnitOfMeasurement=UnitOfMeasurement;
        
    }
    /**
     * @return the IngredientCode
     */
  //  public int getIngredientCode() {
    //    return IngredientCode;
    //}
//
    /**
     * @param IngredientCode the IngredientCode to set
     */
   // public void setIngredientCode(int IngredientCode) {
     //   this.IngredientCode = IngredientCode;
   // }

    /**
     * @return the IngredientName
     */
    public String getIngredientName() {
        return IngredientName;
    }

    /**
     * @param IngredientName the IngredientName to set
     */
    public void setIngredientName(String IngredientName) {
        this.IngredientName = IngredientName;
    }

    /**
     * @return the Stock
     */
    public double getStock() {
        return Stock;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(double Stock) {
        this.Stock = Stock;
    }

    /**
     * @return the Threshold
     */
    public int getThreshold() {
        return Threshold;
    }

    /**
     * @param Threshold the Threshold to set
     */
    public void setThreshold(int Threshold) {
        this.Threshold = Threshold;
    }

    /**
     * @return the Ceiling
     */
    public int getCeiling() {
        return Ceiling;
    }

    /**
     * @param Ceiling the Ceiling to set
     */
    public void setCeiling(int Ceiling) {
        this.Ceiling = Ceiling;
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
    
    
}
