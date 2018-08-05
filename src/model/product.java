/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Roano
 */
public class product {
    private int productcode;
    private String productname;
    private double productprice;
    private int stock;
    private int threshold;
    private int ceiling;
    private String status;
    

    /**
     * @return the productcode
     */
    
    public product(int productcode, String productname, double productprice, int stock, int threshold, int ceiling, String status){
        this.productcode = productcode;
    	this.productname = productname;
        this.productprice = productprice;
        this.stock = stock;
        this.threshold = threshold;
        this.ceiling = ceiling;
        this.status = status;
    }
    
    public product(String productname, double productprice, int stock, int threshold, int ceiling){
        this.productname = productname;
        this.productprice = productprice;
        this.stock = stock;
        this.threshold = threshold;
        this.ceiling = ceiling;
    }
    public product(int PC,String productname, double productprice, int stock, int threshold, int ceiling){
        this.productcode=PC;
        this.productname = productname;
        this.productprice = productprice;
        this.stock = stock;
        this.threshold = threshold;
        this.ceiling = ceiling;
    }
    
    public int getProductcode() {
        return productcode;
    }

    /**
     * @param productcode the productcode to set
     */
    public void setProductcode(int productcode) {
        this.productcode = productcode;
    }

    /**
     * @return the productname
     */
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname the productname to set
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * @return the productprice
     */
    public double getProductprice() {
        return productprice;
    }

    /**
     * @param productprice the productprice to set
     */
    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the threshold
     */
    public int getThreshold() {
        return threshold;
    }

    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    /**
     * @return the ceiling
     */
    public int getCeiling() {
        return ceiling;
    }

    /**
     * @param ceiling the ceiling to set
     */
    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
