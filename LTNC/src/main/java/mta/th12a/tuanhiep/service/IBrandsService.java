package mta.th12a.tuanhiep.service;

import java.util.List;

import mta.th12a.tuanhiep.model.Brands;


public interface IBrandsService {
	public void add(Brands brand);
	public void update (Brands brand);
	public void delete (int Brand_ID);
	public Brands getByID(int Brand_ID);
	public List<Brands> getAll();
}
