package mta.th12a.tuanhiep.service;

import java.util.List;

import mta.th12a.tuanhiep.model.ProductImages;

public interface IProductImagesService {
	public void add(ProductImages entity);
	public void update (ProductImages entity);
	public void delete (int id);
	public ProductImages getByID(int id);
	public List<ProductImages> getAll();
}
