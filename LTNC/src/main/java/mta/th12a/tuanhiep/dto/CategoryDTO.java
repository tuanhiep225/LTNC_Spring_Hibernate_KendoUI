package mta.th12a.tuanhiep.dto;

import java.util.List;

import mta.th12a.tuanhiep.model.Categories;

public class CategoryDTO {
	private Categories parentCategory;
	private List<Categories> childCategory;
	public CategoryDTO() {
	}
	public CategoryDTO(Categories parentCategory, List<Categories> childCategory) {
		this.parentCategory = parentCategory;
		this.childCategory = childCategory;
	}
	public Categories getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Categories parentCategory) {
		this.parentCategory = parentCategory;
	}
	public List<Categories> getChildCategory() {
		return childCategory;
	}
	public void setChildCategory(List<Categories> childCategory) {
		this.childCategory = childCategory;
	}
}
