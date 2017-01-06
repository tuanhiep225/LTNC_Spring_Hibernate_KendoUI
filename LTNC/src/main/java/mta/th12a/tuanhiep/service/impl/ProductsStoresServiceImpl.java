package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.IProductsStoresDao;
import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.model.ProductStoresObjec;
import mta.th12a.tuanhiep.service.IProductsStoresService;
@Service
public class ProductsStoresServiceImpl implements IProductsStoresService {
	@Autowired
	private IProductsStoresDao productStoreDao;
	@Transactional
	@Override
	public void add(ProductStores entity) {
		productStoreDao.add(entity);		
	}
	@Transactional
	@Override
	public void delete(int id) {
		productStoreDao.delete(id);		
	}
	@Transactional
	@Override
	public List<ProductStores> getAll() {
		return productStoreDao.getAll();
	}
	@Transactional
	@Override
	public ProductStores getByID(int id) {
		
		return productStoreDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(ProductStores entity) {
		productStoreDao.update(entity);		
	}
	@Transactional
	@Override
	public ProductStoresObjec FindByColorAndSize(int productId, int colorId, int sizeId) {
		// TODO Auto-generated method stub
		return productStoreDao.FindByColorAndSize(productId, colorId, sizeId);
	}
}
