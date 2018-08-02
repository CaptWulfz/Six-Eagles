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
/**
 * @author JAROD
 *
 */
public class Users implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int UserId;
	private String Firstname;
	private String Lastname;
    private String Username;
    private String Password;
    private String Position;
    private String Address;
    private String Userhash;
    
    public Users(int ID, String Username, String Password)
    {
        this.Username=Username;
        this.Password=Password;
        this.UserId=ID;
    }
    public Users(String Username, String Password)
    {
        this.Username=Username;
        this.Password=Password;
    
    }
    
    public Users(String firstName, String lastName, String userName, String password, String position, String address) {
    	this.Firstname = firstName;
    	this.Lastname = lastName;
    	this.Username = userName;
    	this.Password = password;
    	this.Position = position;
    	this.Address = address;
    }

    /**
     * @return the StaffId
     */
    public int getUserId() {
        return this.UserId;
    }

    /**
     * @param StaffId the StaffId to set
     */
    public void setUserId(int UserId) {
        this.UserId = UserId;
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
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
    
    
    
    
}
