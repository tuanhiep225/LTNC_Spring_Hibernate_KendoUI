package mta.th12a.tuanhiep.dto;

import java.util.ArrayList;
import java.util.List;

import mta.th12a.tuanhiep.model.ProductStores;

public class ProductDTO {
	int productId;
	String productName;
	String brandName;
	Integer brandId;
	String productImage;
	Integer categoryId;
	String categoryName;
	List<ProductStores> listProductStores;
	public ProductDTO() {
		listProductStores=new ArrayList<>();
	}
	public ProductDTO(int productId, String productName, String brandName, Integer brandId, String productImage,
			Integer categoryId, String categoryName, List<ProductStores> listProductStores) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.brandId = brandId;
		this.productImage = productImage;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.listProductStores = listProductStores;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<ProductStores> getListProductStores() {
		return listProductStores;
	}
	public void setListProductStores(List<ProductStores> listProductStores) {
		this.listProductStores = listProductStores;
	}
}
