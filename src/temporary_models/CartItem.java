package temporary_models;

public class CartItem {
	
	private int productCode;
	private String name;
	private int quantity;
	private double pricePerPiece;
	private double totalPrice;
	
	public CartItem(int productCode, String name, int quantity, double pricePerPiece, double totalPrice) {
		this.productCode = productCode;
		this.name = name;
		this.quantity = quantity;
		this.pricePerPiece = pricePerPiece;
		this.totalPrice = totalPrice;
	}
	
	public int getProductCode() {
		return this.productCode;
	}
	
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPricePerPiece() {
		return pricePerPiece;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
