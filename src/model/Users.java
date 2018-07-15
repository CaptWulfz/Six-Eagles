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
public class Users implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int StaffId;
    private String Username;
    private String Password;
    private String Userhash;
    
    public Users(int ID,String Username, String Password)
    {
        this.Username=Username;
        this.Password=Password;
        this.StaffId=ID;
    }
    public Users(String Username, String Password)
    {
        this.Username=Username;
        this.Password=Password;
    
    }

    /**
     * @return the StaffId
     */
    public int getStaffId() {
        return StaffId;
    }

    /**
     * @param StaffId the StaffId to set
     */
    public void setStaffId(int StaffId) {
        this.StaffId = StaffId;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getUserhash() {
    	return this.Userhash;
    }
    
    public void setUserhash(String hash) {
    	this.Userhash = hash;
    }
    
    
}
