package mta.th12a.tuanhiep.model;
// Generated Oct 10, 2016 7:18:39 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductSizes generated by hbm2java
 */
@Entity
@Table(name="PRODUCT_SIZES"
    ,schema="dbo"
    ,catalog="LTNC_THOITRANG"
)
public class ProductSizes  implements java.io.Serializable {


     private int productSizeId;
     private String productSizeName;
     private Boolean isActive;

    public ProductSizes() {
    }

	
    public ProductSizes(int productSizeId) {
        this.productSizeId = productSizeId;
    }
    public ProductSizes(int productSizeId, String productSizeName, Boolean isActive) {
       this.productSizeId = productSizeId;
       this.productSizeName = productSizeName;
       this.isActive = isActive;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
    @Column(name="Product_Size_ID", unique=true, nullable=false)
    public int getProductSizeId() {
        return this.productSizeId;
    }
    
    public void setProductSizeId(int productSizeId) {
        this.productSizeId = productSizeId;
    }

    
    @Column(name="Product_Size_Name", length=200)
    public String getProductSizeName() {
        return this.productSizeName;
    }
    
    public void setProductSizeName(String productSizeName) {
        this.productSizeName = productSizeName;
    }

    
    @Column(name="IsActive")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }




}


