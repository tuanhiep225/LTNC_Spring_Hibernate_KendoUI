package mta.th12a.tuanhiep.model;
// Generated Oct 10, 2016 7:18:39 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductColors generated by hbm2java
 */
@Entity
@Table(name="PRODUCT_COLORS"
    ,schema="dbo"
    ,catalog="LTNC_THOITRANG"
)
public class ProductColors  implements java.io.Serializable {


     private int productColorId;
     private String productColorName;
     private String productColorCss;
     private Boolean isActive;

    public ProductColors() {
    }

	
    public ProductColors(int productColorId) {
        this.productColorId = productColorId;
    }
    public ProductColors(int productColorId, String productColorName,String productColorCss, Boolean isActive) {
       this.productColorId = productColorId;
       this.productColorName = productColorName;
       this.productColorCss=productColorCss;
       this.isActive = isActive;
    }
   
     @Id 

     @GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
    @Column(name="Product_Color_ID", unique=true, nullable=false)
    public int getProductColorId() {
        return this.productColorId;
    }
    
    public void setProductColorId(int productColorId) {
        this.productColorId = productColorId;
    }

    
    @Column(name="Product_Color_Name", length=200)
    public String getProductColorName() {
        return this.productColorName;
    }
    
    public void setProductColorName(String productColorName) {
        this.productColorName = productColorName;
    }

    
    @Column(name="IsActive")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Column(name="Product_Color_Css", length=50)
	public String getProductColorCss() {
		return productColorCss;
	}


	public void setProductColorCss(String productColorCss) {
		this.productColorCss = productColorCss;
	}




}

