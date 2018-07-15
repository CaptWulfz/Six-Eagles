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
    private int RawMaterialCode;
    private double Quantity;
    private String Unit;
    
    public supplyorderdetails(int SON,int RMC, double Q, String U){
        this.SupplyOrderNum=SON;
        this.RawMaterialCode=RMC;
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
    public int getRawMaterialCode() {
        return RawMaterialCode;
    }

    /**
     * @param RawMaterialCode the RawMaterialCode to set
     */
    public void setRawMaterialCode(int RawMaterialCode) {
        this.RawMaterialCode = RawMaterialCode;
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
