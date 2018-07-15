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
public class OrderDetails { 
    private int PurchaseOrderNum;
    private int ProductCode;
    private double unitprice;
    private int QtyOrdered;
    
    
   public OrderDetails( int PurchaseOrderNum, int ProductCode,double unitprice,int QtyOrdered){
       this.PurchaseOrderNum=PurchaseOrderNum;
       this.ProductCode=ProductCode;
       this.unitprice=unitprice;
       this.QtyOrdered=QtyOrdered;
       
   }
   public OrderDetails(int ProductCode,double unitprice,int QtyOrdered){
       this.ProductCode=ProductCode;
       this.unitprice=unitprice;
       this.QtyOrdered=QtyOrdered;
       
   }

    /**
     * @return the PurchaseOrderNum
     */
    public int getPurchaseOrderNum() {
        return PurchaseOrderNum;
    }

    /**
     * @param PurchaseOrderNum the PurchaseOrderNum to set
     */
    public void setPurchaseOrderNum(int PurchaseOrderNum) {
        this.PurchaseOrderNum = PurchaseOrderNum;
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
     * @return the unitprice
     */
    public double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * @return the QtyOrdered
     */
    public int getQtyOrdered() {
        return QtyOrdered;
    }

    /**
     * @param QtyOrdered the QtyOrdered to set
     */
    public void setQtyOrdered(int QtyOrdered) {
        this.QtyOrdered = QtyOrdered;
    }
   
    
    
}
