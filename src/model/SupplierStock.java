package model;

public class SupplierStock {
	
	private int supplierStockID;
	private int supplierID;
	private int ingredientID;
	private double ingredientPrice;
	
	public SupplierStock(int id, int sID, int iID, double price) {
		this.supplierStockID = id;
		this.supplierID = sID;
		this.ingredientID = iID;
		this.ingredientPrice = price;
	}

	public int getSupplierStockID() {
		return supplierStockID;
	}

	public void setSupplierStockID(int supplierStockID) {
		this.supplierStockID = supplierStockID;
	}

	public int getSupplierID() {
		return supplierID;
	}
	
	public double getIngredientPrice() {
		return this.ingredientPrice;
	}
	
	public void setIngredientPrice(double price) {
		this.ingredientPrice = price;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public int getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(int ingredientID) {
		this.ingredientID = ingredientID;
	}
	
	
	
}
