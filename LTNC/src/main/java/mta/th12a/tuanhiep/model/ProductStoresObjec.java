package mta.th12a.tuanhiep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
@Entity
public abstract class ProductStoresObjec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private int productStoreId;
     private Integer productId;
     private Integer productColorId;
     private Integer productSizeId;
     private Integer quantity;
     private Double purchasePrice;
     private Double price;
     private Double sale;
     private String dayTrading;
     private String note;
     private Boolean isActive;
	@Id 

     @GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
    @Column(name="Product_Store_ID", unique=true, nullable=false)
    public int getProductStoreId() {
        return this.productStoreId;
    }
    
    public void setProductStoreId(int productStoreId) {
        this.productStoreId = productStoreId;
    }

    
    @Column(name="Product_ID")
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    
    @Column(name="Product_Color_ID")
    public Integer getProductColorId() {
        return this.productColorId;
    }
    
    public void setProductColorId(Integer productColorId) {
        this.productColorId = productColorId;
    }

    
    @Column(name="Product_Size_ID")
    public Integer getProductSizeId() {
        return this.productSizeId;
    }
    
    public void setProductSizeId(Integer productSizeId) {
        this.productSizeId = productSizeId;
    }

    
    @Column(name="Quantity")
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="Purchase_Price", precision=53, scale=0)
    public Double getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    
    @Column(name="Price", precision=53, scale=0)
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    
    @Column(name="Sale", precision=53, scale=0)
    public Double getSale() {
        return this.sale;
    }
    
    public void setSale(Double sale) {
        this.sale = sale;
    }

    
    @Column(name="Day_Trading", length=10)
    public String getDayTrading() {
        return this.dayTrading;
    }
    
    public void setDayTrading(String dayTrading) {
        this.dayTrading = dayTrading;
    }

    
    @Column(name="Note", length=200)
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

    
    @Column(name="IsActive")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
