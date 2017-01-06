package mta.th12a.tuanhiep.dto;
import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.model.ProductStoresObjec;
public class ItemDTO {
	private ProductStoresObjec product;
	private int quantity;
	public ItemDTO() {
	}
	public ItemDTO(ProductStores product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public ProductStoresObjec getProduct() {
		return product;
	}
	public void setProduct(ProductStores product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
