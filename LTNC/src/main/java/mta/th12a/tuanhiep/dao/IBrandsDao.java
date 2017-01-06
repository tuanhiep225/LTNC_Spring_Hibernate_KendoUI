package mta.th12a.tuanhiep.dao;

import java.util.List;

import mta.th12a.tuanhiep.model.Brands;


public interface IBrandsDao {
	public void add(Brands entity);
	public void update (Brands entity);
	public void delete (int id);
	public Brands getByID(int id);
	public List<Brands> getAll();
}
