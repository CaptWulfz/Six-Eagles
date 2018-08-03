/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wacke
 */
public class supplyorderdetails {
    
    private int SupplyOrderNum;
    private int IngredientCode;
    private double Quantity;
    private String Unit;
    
    public supplyorderdetails(int SON,int iCode, double Q, String U){
        this.SupplyOrderNum=SON;
        this.IngredientCode=iCode;
        this.Quantity=Q;
        this.Unit=U;
    }

    /**
     * @return the SupplyOrderNum
     */
    public int getSupplyOrderNum() {
        return SupplyOrderNum;
    }

    /**
     * @param SupplyOrderNum the SupplyOrderNum to set
     */
    public void setSupplyOrderNum(int SupplyOrderNum) {
        this.SupplyOrderNum = SupplyOrderNum;
    }

    /**
     * @return the RawMaterialCode
     */
    public int getIngredientCode() {
        return this.IngredientCode;
    }

    /**
     * @param RawMaterialCode the RawMaterialCode to set
     */
    public void setRawMaterialCode(int code) {
        this.IngredientCode = code;
    }

    /**
     * @return the Quantity
     */
    public double getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
    
    
}
