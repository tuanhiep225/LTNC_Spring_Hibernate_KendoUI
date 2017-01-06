package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.ICategoriesDao;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.service.ICategoriesService;

@Service
public class CategoriesServiceImpl implements ICategoriesService{
	@Autowired
	private ICategoriesDao categoriesDao;
	@Transactional
	@Override
	public void add(Categories entity) {
		categoriesDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int Brand_ID) {
		categoriesDao.delete(Brand_ID);
		
	}
	@Transactional
	@Override
	public List<Categories> getAll() {
		return categoriesDao.getAll();
	}
	@Transactional
	@Override
	public Categories getByID(int Brand_ID) {
		
		return categoriesDao.getByID(Brand_ID);
	}
	@Transactional
	@Override
	public void update(Categories brand) {
		categoriesDao.update(brand);
		
	}
	@Transactional
	@Override
	public List<Categories> getListChild() {
		return categoriesDao.getListChild();
	}
	@Transactional
	@Override
	public List<Categories> getListParent() {
		return categoriesDao.getListParent();
	}
	@Transactional
	@Override
	public List<Categories> getByIDParent(int ID) {
			// TODO Auto-generated method stub
			return categoriesDao.getByIDParent(ID);
	}
}
