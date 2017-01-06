package mta.th12a.tuanhiep.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.model.ProductStoresObjec;

@Entity
public class ProductStoreDTO extends ProductStoresObjec{
	private String productName;
    private String productColorName;
    private String productSizeName;
    private String productImage;
    public ProductStoreDTO() {
		super();
	}
	public ProductStoreDTO(String productName, String productColorName, String productSizeName, String productImage) {
		super();
		this.productName = productName;
		this.productColorName = productColorName;
		this.productSizeName = productSizeName;
		this.productImage = productImage;
	}



	@Column(name="Product_Name",length=200)
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name="Product_Color_Name",length=200)
	public String getProductColorName() {
		return productColorName;
	}


	public void setProductColorName(String productColorName) {
		this.productColorName = productColorName;
	}

	@Column(name="Product_Size_Name",length=200)
	public String getProductSizeName() {
		return productSizeName;
	}


	public void setProductSizeName(String productSizeName) {
		this.productSizeName = productSizeName;
	}
	@Column(name="Product_Image",length=200)
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
}
