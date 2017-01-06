package mta.th12a.tuanhiep.service;

import java.util.List;

import mta.th12a.tuanhiep.model.ProductColors;

public interface IProductCorlorsService {
	public void add(ProductColors entity);
	public void update (ProductColors entity);
	public void delete (int id);
	public ProductColors getByID(int id);
	public List<ProductColors> getAll();
	public List<ProductColors> getByIdProduct(int id);
}
