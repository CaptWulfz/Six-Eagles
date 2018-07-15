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
public class Products {
    private int ProductCode;
    private String ProductName;
    private double ProductPrice;
    private int AvailableStock;
    private int Threshold;
    private int tillTreshold;
    private int Ceiling;
    private int tillCeiling;
    private String Status;
   
    public Products( String PN,double PP, int AS, int TH, int CL, String Status){
      
        this.ProductName=PN;
        this.ProductPrice=PP;
        this.AvailableStock=AS;
        this.Threshold=TH;
        this.Ceiling=CL;
        this.Status=Status;
    }
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
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @return the ProductPrice
     */
    public double getProductPrice() {
        return ProductPrice;
    }

    /**
     * @param ProductPrice the ProductPrice to set
     */
    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    /**
     * @return the AvailableStock
     */
    public int getAvailableStock() {
        return AvailableStock;
    }

    /**
     * @param AvailableStock the AvailableStock to set
     */
    public void setAvailableStock(int AvailableStock) {
        this.AvailableStock = AvailableStock;
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
     * @return the tillTreshold
     */
    public int getTillTreshold() {
        return tillTreshold;
    }

    /**
     * @param tillTreshold the tillTreshold to set
     */
    public void setTillTreshold(int tillTreshold) {
        this.tillTreshold = tillTreshold;
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
     * @return the tillCeiling
     */
    public int getTillCeiling() {
        return tillCeiling;
    }

    /**
     * @param tillCeiling the tillCeiling to set
     */
    public void setTillCeiling(int tillCeiling) {
        this.tillCeiling = tillCeiling;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
