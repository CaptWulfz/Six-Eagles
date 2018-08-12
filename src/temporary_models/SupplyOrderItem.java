package temporary_models;

import model.ingredients;
import model.supplyorders;
import model.SupplierStock;

public class SupplyOrderItem {
	private ingredients ingredient;
	private supplyorders supplyOrder;
	private SupplierStock stockItem;
	private int quantity;
	
	public SupplyOrderItem() {
		
	}
	
	public ingredients getIngredient() {
		return this.ingredient;
	}
	
	public void setIngredient(ingredients i) {
		this.ingredient = i;
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
	
	public SupplierStock getStockItem() {
		return this.stockItem;
	}
	
	public void setStockItem(SupplierStock stockItem) {
		this.stockItem = stockItem;
	}
	
}
