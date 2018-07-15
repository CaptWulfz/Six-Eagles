/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AJ's Laptop
 */
public class InvenRepIng {

    /**
     * @return the audit_id
     */
    public int getAudit_id() {
        return audit_id;
    }

    /**
     * @param audit_id the audit_id to set
     */
    public void setAudit_id(int audit_id) {
        this.audit_id = audit_id;
    }

    /**
     * @return the prodCode
     */
    public int getProdCode() {
        return prodCode;
    }

    /**
     * @param prodCode the prodCode to set
     */
    public void setProdCode(int prodCode) {
        this.prodCode = prodCode;
    }

    /**
     * @return the auditNameIng
     */
    public String getAuditNameIng() {
        return auditNameIng;
    }

    /**
     * @param auditNameIng the auditNameIng to set
     */
    public void setAuditNameIng(String auditNameIng) {
        this.auditNameIng = auditNameIng;
    }

    /**
     * @return the RW_Quantity
     */
    public int getRW_Quantity() {
        return RW_Quantity;
    }

    /**
     * @param RW_Quantity the RW_Quantity to set
     */
    public void setRW_Quantity(int RW_Quantity) {
        this.RW_Quantity = RW_Quantity;
    }

    /**
     * @return the auditLog
     */
    public String getAuditLog() {
        return auditLog;
    }

    /**
     * @param auditLog the auditLog to set
     */
    public void setAuditLog(String auditLog) {
        this.auditLog = auditLog;
    }
    private int audit_id;
    private int prodCode;
    private String auditNameIng;
    private int RW_Quantity;
    private String auditLog;
    
   
    public InvenRepIng(int audit_id,int prodCode,String AuditNameIng,int RW_Quantity, String auditLog){
        this.audit_id=audit_id;
        this.prodCode=prodCode;
        this.auditNameIng=AuditNameIng;
        this.RW_Quantity=RW_Quantity;
        this.auditLog=auditLog;
    }
}
