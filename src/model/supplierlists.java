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
public class supplierlists {
    private int IngedientCode;
    private int SupplierID;
    public supplierlists(int IngredientCode, int SupplierID){
        this.IngedientCode=IngredientCode;
        this.SupplierID=SupplierID;
        
    }

    /**
     * @return the IngedientCode
     */
    public int getIngedientCode() {
        return IngedientCode;
    }

    /**
     * @param IngedientCode the IngedientCode to set
     */
    public void setIngedientCode(int IngedientCode) {
        this.IngedientCode = IngedientCode;
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


  
    
}
