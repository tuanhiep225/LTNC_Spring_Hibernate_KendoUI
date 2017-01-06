package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import mta.th12a.tuanhiep.dao.IProductImagesDao;
import mta.th12a.tuanhiep.model.ProductImages;
import mta.th12a.tuanhiep.service.IProductImagesService;
@Service
public class ProductImagesServiceImpl implements IProductImagesService {
	@Autowired
	private IProductImagesDao productImageDao;
	@Transactional
	@Override
	public void add(ProductImages entity) {
		productImageDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		productImageDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<ProductImages> getAll() {
		return productImageDao.getAll();
	}
	@Transactional
	@Override
	public ProductImages getByID(int id) {
		
		return productImageDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(ProductImages entity) {
		productImageDao.update(entity);
		
	}
}
