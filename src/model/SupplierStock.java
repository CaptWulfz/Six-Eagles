package model;

public class SupplierStock {
	
	private int supplierStockID;
	private int supplierID;
	private int ingredientID;
	
	public SupplierStock(int id, int sID, int iID) {
		this.supplierStockID = id;
		this.supplierID = sID;
		this.ingredientID = iID;
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
