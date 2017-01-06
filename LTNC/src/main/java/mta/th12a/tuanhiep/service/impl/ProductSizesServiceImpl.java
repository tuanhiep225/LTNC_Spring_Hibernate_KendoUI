package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.IProductSizesDao;
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.service.IProductSizesService;
@Service
public class ProductSizesServiceImpl implements IProductSizesService{
	@Autowired
	private IProductSizesDao productSizeDao;
	@Transactional
	@Override
	public void add(ProductSizes entity) {
		productSizeDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		productSizeDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<ProductSizes> getAll() {
		return productSizeDao.getAll();
	}
	@Transactional
	@Override
	public ProductSizes getByID(int id) {
		
		return productSizeDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(ProductSizes entity) {
		productSizeDao.update(entity);
		
	}
	@Transactional
	@Override
	public List<ProductSizes> getByIdProduct(int id) {
		return productSizeDao.getByIdProduct(id);
	}
}
