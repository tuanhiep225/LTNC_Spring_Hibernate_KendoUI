package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mta.th12a.tuanhiep.dao.IProductCorlorsDao;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.service.IProductCorlorsService;

@Service
public class ProductCorlorsServiceImpl implements IProductCorlorsService {
	@Autowired
	private IProductCorlorsDao productColorDao;
	@Transactional
	@Override
	public void add(ProductColors entity) {
		productColorDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		productColorDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<ProductColors> getAll() {
		return productColorDao.getAll();
	}
	@Transactional
	@Override
	public ProductColors getByID(int id) {
		
		return productColorDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(ProductColors entity) {
		productColorDao.update(entity);
		
	}
	@Transactional
	@Override
	public List<ProductColors> getByIdProduct(int id)
	{
		return productColorDao.getByIdProduct(id);
		
	}
}
