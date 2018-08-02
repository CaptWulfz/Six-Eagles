/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Desmond
 */

public class rawmaterials implements Serializable {
    
    private int RawMaterialCode;
    private int IngredientCode;
    private String IngredientBrand;
    private double PackagingAmount;
    private String Packaging ;
    private double Amount;
    private String UnitOfMeasurement;
    
    public rawmaterials(int rawmCode, int ingrCode, String brand, double packagingAmount, String packaging, double amount, String uom) {
    	this.RawMaterialCode = rawmCode;
    	this.IngredientCode = ingrCode;
    	this.IngredientBrand = brand;
    	this.PackagingAmount = packagingAmount;
    	this.Packaging = packaging;
    	this.Amount = amount;
    	this.UnitOfMeasurement = uom;
    }
    
    public rawmaterials(String IngredientBrand, double PackagingAmount, String Packaging, double Amount,String Uom){

        this.IngredientBrand=IngredientBrand;
        this.PackagingAmount=PackagingAmount;
        this.Packaging=Packaging;
        this.Amount=Amount;
        this.UnitOfMeasurement=Uom;
    }
    public rawmaterials(int RG,String IngredientBrand, double PackagingAmount, String Packaging, double Amount,String Uom){
        this.RawMaterialCode=RG;
        this.IngredientBrand=IngredientBrand;
        this.PackagingAmount=PackagingAmount;
        this.Packaging=Packaging;
        this.Amount=Amount;
        this.UnitOfMeasurement=Uom;
    }
    
    public rawmaterials(int RG,String IngredientBrand, double Amount,String Uom){
        this.RawMaterialCode=RG;
        this.IngredientBrand=IngredientBrand;
        this.Amount=Amount;
        this.UnitOfMeasurement=Uom;
    }
    
    public rawmaterials(int RG,  double PackagingAmount,  double Amount,String Uom){
        this.RawMaterialCode=RG;
  
        this.PackagingAmount=PackagingAmount;
        
        this.Amount=Amount;
        this.UnitOfMeasurement=Uom;
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
     * @return the RawMaterialCode
     */
    public int getRawMaterialCode() {
        return RawMaterialCode;
    }

    /**
     * @param RawMaterialCode the RawMaterialCode to set
     */
    public void setRawMaterialCode(int RawMaterialCode) {
        this.RawMaterialCode = RawMaterialCode;
    }
    


    public String getIngredientBrand() {
        return IngredientBrand;
    }

    /**
     * @param IngrediaentBrand the IngrediaentBrand to set
     */
    public void setIngredientBrand(String IngrediaentBrand) {
        this.IngredientBrand = IngrediaentBrand;
    }

    /**
     * @return the PackagingAmount
     */
    public double getPackagingAmount() {
        return PackagingAmount;
    }

    /**
     * @param PackagingAmount the PackagingAmount to set
     */
    public void setPackagingAmount(double PackagingAmount) {
        this.PackagingAmount = PackagingAmount;
    }

    /**
     * @return the Packaging
     */
    public String getPackaging() {
        return Packaging;
    }

    /**
     * @param Packaging the Packaging to set
     */
    public void setPackaging(String Packaging) {
        this.Packaging = Packaging;
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
               
}
