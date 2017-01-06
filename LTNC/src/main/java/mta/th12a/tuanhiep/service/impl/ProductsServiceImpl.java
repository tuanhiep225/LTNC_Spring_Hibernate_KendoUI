package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.IProductsDao;
import mta.th12a.tuanhiep.dto.ProductDTO;
import mta.th12a.tuanhiep.model.Products;
import mta.th12a.tuanhiep.service.IProductsService;
@Service
public class ProductsServiceImpl implements IProductsService{
	@Autowired
	private IProductsDao productDao;
	@Transactional
	@Override
	public void add(Products entity) {
		productDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		productDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<Products> getAll() {
		return productDao.getAll();
	}
	@Transactional
	@Override
	public Products getByID(int id) {
		
		return productDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(Products entity) {
		productDao.update(entity);
		
	}
	@Transactional
	@Override
	public List<ProductDTO> getListByCategoryID(int ID) {
		return productDao.getListByCategoryID(ID);
	}
	@Transactional
	@Override
	public List<ProductDTO> getListNew() {
		// TODO Auto-generated method stub
		return productDao.getListNew();
	}
}
