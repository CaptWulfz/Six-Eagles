/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joshua Sultan
 */
public class supplyorders {
    private String SupplierName;
    private int SupplyOrderNum;
    private int SupplierID;
    private int DeliveryReceiptNo;
    private String OrderDate;
    private String DeliveryDate;
    private int StatusID;
    private String StatusDetails;
    private String Comments;

            // ADD
    public supplyorders(int SID, int DDN ,String OD, String DD, int STID , String SD, String Co){
        this.SupplierID = SID;
        this.DeliveryReceiptNo = DDN;
        this.OrderDate = OD;
        this.DeliveryDate = DD;
        this.StatusID = STID;
        this.StatusDetails = SD;
        this.Comments = Co;
    }       
    
    //New
    public supplyorders(String name, int sOrderNum, int Id, int DDN, String OD,  String DD, int SId, String Co) {
    	this.SupplierName = name;
    	this.SupplyOrderNum = sOrderNum;
    	this.SupplierID = Id;
    	this.DeliveryReceiptNo = DDN;
    	this.OrderDate = OD;
    	this.DeliveryDate = DD;
    	this.StatusID = SId;
    	this.Comments = Co;
    }
            // VIEW
    public supplyorders(int SID, int DDN, String OD, String DD,String SD, String Co){ 
        
        this.SupplierID = SID;
        this.DeliveryReceiptNo = DDN;
        this.OrderDate = OD;
        this.DeliveryDate = DD;
        this.StatusDetails = SD;
        this.Comments = Co;
    }
            
           // VIEW w/ Supplier Name
     public supplyorders(String SN ,int SID, int DDN, String OD, String DD,String SD, String Co,int SON){ 
        this.SupplierName = SN;
        this.SupplierID = SID;
        this.DeliveryReceiptNo = DDN;
        this.OrderDate = OD;
        this.DeliveryDate = DD;
        this.StatusDetails = SD;
        this.Comments = Co;
        this.SupplyOrderNum=SON;
     }
     
     //public supplyorders(int SID, int DDN ,String OD, String DD, int STID , String SD, String Co,int SON){
       // this.SupplierID = SID;
        //this.DeliveryReceiptNo = DDN;
        //this.OrderDate = OD;
        //this.DeliveryDate = DD;
       // this.StatusID = STID;
       // this.StatusDetails = SD;
       // this.Comments = Co;
       // this.SupplyOrderNum=SON;
     //}

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
     * @return the SupplierID
     */
    public int getSupplierID() {
        return SupplierID;
    }

    /**
     * @param SupplierID the SupplierID to set
     */
    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    /**
     * @return the DeliveryReceiptNo
     */
    public int getDeliveryReceiptNo() {
        return DeliveryReceiptNo;
    }

    /**
     * @param DeliveryReceiptNo the DeliveryReceiptNo to set
     */
    public void setDeliveryReceiptNo(int DeliveryReceiptNo) {
        this.DeliveryReceiptNo = DeliveryReceiptNo;
    }

    /**
     * @return the OrderDate
     */
    public String getOrderDate() {
        return OrderDate;
    }

    /**
     * @param OrderDate the OrderDate to set
     */
    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    /**
     * @return the DeliveryDate
     */
    public String getDeliveryDate() {
        return DeliveryDate;
    }

    /**
     * @param DeliveryDate the DeliveryDate to set
     */
    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    /**
     * @return the StatusID
     */
    public int getStatusID() {
        return StatusID;
    }

    /**
     * @param StatusID the StatusID to set
     */
    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    /**
     * @return the StatusDetails
     */
    public String getStatusDetails() {
        return StatusDetails;
    }

    /**
     * @param StatusDetails the StatusDetails to set
     */
    public void setStatusDetails(String StatusDetails) {
        this.StatusDetails = StatusDetails;
    }

    /**
     * @return the Comments
     */
    public String getComments() {
        return Comments;
    }

    /**
     * @param Comments the Comments to set
     */
    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    /**
     * @return the SupplierName
     */
    public String getSupplierName() {
        return SupplierName;
    }

    /**
     * @param SupplierName the SupplierName to set
     */
    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }
}