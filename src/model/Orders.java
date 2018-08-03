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
public class Orders {
    private int PurchaseOrderNum;
    private int ClientID;
    private int UserID;
    private int deliveryrecieptNum;
    private String orderdate;
    private String Deliverydate;
    private int Status;
    private String StatusDetails;
    private String  Comments;
    
    //initial orders without comments
    public Orders(int PurchaseOrderNum,int ClientID,int UserID,String orderdate,String Deliverydate){
        this.PurchaseOrderNum=PurchaseOrderNum;
        this.ClientID=ClientID;
        this.UserID=UserID;
        this.orderdate=orderdate;
        this.Deliverydate=Deliverydate;
        this.Status=2;
        this.StatusDetails="Processing";
        
    }
    //for initial orders with coments
    //public Orders(int ClientID,int StaffID,String orderdate,String Deliverydate,String Comments){
        //this.ClientID=ClientID;
        //this.StaffID=StaffID;
        //this.orderdate=orderdate;
        //this.Deliverydate=Deliverydate;
        //this.Status=1;
        //this.StatusDetails="Processing";
        //this.Comments=Comments;
        
    //}
    
    public Orders(int PurchaseOrderNum, int clientID, int Deliveryreceiptnum,String orderdate,String Deliverydate,String StatusDetails){
        this.PurchaseOrderNum=PurchaseOrderNum;
        this.ClientID = clientID;
        this.deliveryrecieptNum=Deliveryreceiptnum;
        this.orderdate=orderdate;
        this.Deliverydate=Deliverydate;
        this.StatusDetails=StatusDetails;
    }
    
    public Orders(int PurchaseOrderNum,String StatusDetails){
        this.PurchaseOrderNum=PurchaseOrderNum;
        this.StatusDetails=StatusDetails;
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
     * @return the ClientID
     */
    public int getClientID() {
        return ClientID;
    }

    /**
     * @param ClientID the ClientID to set
     */
    public void setClientID(int ClientID) {
        this.ClientID = ClientID;
    }

    /**
     * @return the StaffID
     */
    public int getUserID() {
        return this.UserID;
    }

    /**
     * @param StaffID the StaffID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the deliveryrecieptNum
     */
    public int getDeliveryrecieptNum() {
        return deliveryrecieptNum;
    }

    /**
     * @param deliveryrecieptNum the deliveryrecieptNum to set
     */
    public void setDeliveryrecieptNum(int deliveryrecieptNum) {
        this.deliveryrecieptNum = deliveryrecieptNum;
    }

    /**
     * @return the orderdate
     */
    public String getOrderdate() {
        return orderdate;
    }

    /**
     * @param orderdate the orderdate to set
     */
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * @return the Deliverydate
     */
    public String getDeliverydate() {
        return Deliverydate;
    }

    /**
     * @param Deliverydate the Deliverydate to set
     */
    public void setDeliverydate(String Deliverydate) {
        this.Deliverydate = Deliverydate;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
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
    
     
    
}
