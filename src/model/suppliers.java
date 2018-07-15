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
public class suppliers {
    private int SupplierID;
    private String SupplierName;
    private String Address;
    private String City;
    private String Contact;
    
    public suppliers(int SupplierID,String SupplierName, String Address, String City, String Contact  ){
        this.SupplierID=SupplierID;
        this.SupplierName=SupplierName;
        this.Address=Address;
        this.City=City;
        this.Contact=Contact;
    }
    public suppliers(String SupplierName, String Address, String City, String Contact  ){
        this.SupplierName=SupplierName;
        this.Address=Address;
        this.City=City;
        this.Contact=Contact;
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

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void newSupplier()//calls query object to put into database
    {
        
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    
}
