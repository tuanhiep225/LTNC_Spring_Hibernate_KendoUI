package mta.th12a.tuanhiep.dao;

import java.util.List;

import mta.th12a.tuanhiep.dto.ProductDTO;
import mta.th12a.tuanhiep.model.Products;

public interface IProductsDao {
	public void add(Products entity);
	public void update (Products entity);
	public void delete (int id);
	public Products getByID(int id);
	public List<Products> getAll();
	public List<ProductDTO> getListByCategoryID(int ID);
	public List<ProductDTO> getListNew();
}
