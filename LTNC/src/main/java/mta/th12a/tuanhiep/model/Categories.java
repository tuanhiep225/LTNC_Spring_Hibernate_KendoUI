package mta.th12a.tuanhiep.model;
// Generated Oct 10, 2016 7:18:39 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name="CATEGORIES"
    ,schema="dbo"
    ,catalog="LTNC_THOITRANG"
)
public class Categories  implements java.io.Serializable {


     private int categoryId;
     private String categoryName;
     private Integer categoryParent;

	private Boolean isActive;

    public Categories() {
    }

	
    public Categories(int categoryId) {
        this.categoryId = categoryId;
    }
    public Categories(int categoryId, String categoryName, Boolean isActive, Integer categoryParent) {
       this.categoryId = categoryId;
       this.categoryName = categoryName;
       this.categoryParent=categoryParent;
       this.isActive = isActive;
    }
   
     @Id 
     @GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
    @Column(name="Category_ID", unique=true, nullable=false)
    public int getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    
    @Column(name="Category_Name", length=200)
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @Column(name="Category_Parent")
    public Integer getCategoryParent() {
		return categoryParent;
	}


	public void setCategoryParent(Integer categoryParent) {
		this.categoryParent = categoryParent;
	}
    
    @Column(name="IsActive")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }




}


