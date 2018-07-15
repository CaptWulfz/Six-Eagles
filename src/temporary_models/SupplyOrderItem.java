package temporary_models;

import model.rawmaterials;
import model.supplyorders;

public class SupplyOrderItem {
	private rawmaterials rawMaterials;
	private supplyorders supplyOrder;
	private int quantity;
	
	public SupplyOrderItem() {
		
	}
	
	public rawmaterials getRawMaterials() {
		return this.rawMaterials;
	}
	
	public void setRawMaterials(rawmaterials r) {
		this.rawMaterials = r;
	}
	
	public supplyorders getSupplyOrders() {
		return this.supplyOrder;
	}
	
	public void setSupplyOrders(supplyorders supplyOrder) {
		this.supplyOrder = supplyOrder;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
