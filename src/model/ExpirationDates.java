package model;

public class ExpirationDates {
	
	private int entryID;
	private int productID;
	private String manufactureDate;
	private String expirationDate;
	
	public ExpirationDates(int entryID, int productID, String mDate, String eDate) {
		this.entryID = entryID;
		this.productID = productID;
		this.manufactureDate = mDate;
		this.expirationDate = eDate;
	}

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
