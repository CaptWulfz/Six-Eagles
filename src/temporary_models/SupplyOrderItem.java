package temporary_models;

import model.product;
import model.supplyorders;

public class SupplyOrderItem {
	private product product;
	private supplyorders supplyOrder;
	
	public SupplyOrderItem() {
		
	}
	
	public product getProduct() {
		return this.product;
	}
	
	public void setProduct(product p) {
		this.product = p;
	}
	
	public supplyorders getSupplyOrders() {
		return this.supplyOrder;
	}
	
	public void setSupplyOrders(supplyorders supplyOrder) {
		this.supplyOrder = supplyOrder;
	}
	
	
}
