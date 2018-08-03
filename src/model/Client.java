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
public class Client  implements Serializable{
     private int ClientID;
    private String ClientName;
    private String Address;
    private String City;
    
    public Client(int ClientID,String ClientName, String Address, String City ){
        this.ClientID=ClientID;
        this.ClientName=ClientName;
        this.Address=Address;
        this.City=City;
        
    }
    
    public Client(String ClientName, String Address, String City ){
        this.ClientName=ClientName;
        this.Address=Address;
        this.City=City;
        
    }
    public Client (String CN){
        this.ClientName=CN;
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
     * @return the ClientName
     */
    public String getClientName() {
        return this.ClientName;
    }

    /**
     * @param ClientName the ClientName to set
     */
    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
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
   
}
