package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import mta.th12a.tuanhiep.dao.IBrandsDao;
import mta.th12a.tuanhiep.model.Brands;
import mta.th12a.tuanhiep.service.IBrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BrandsServiceImpl implements IBrandsService {
	@Autowired
	private IBrandsDao brandDao;
	@Transactional
	@Override
	public void add(Brands brand) {
		brandDao.add(brand);
		
	}
	@Transactional
	@Override
	public void delete(int Brand_ID) {
		brandDao.delete(Brand_ID);
		
	}
	@Transactional
	@Override
	public List<Brands> getAll() {
		return brandDao.getAll();
	}
	@Transactional
	@Override
	public Brands getByID(int Brand_ID) {
		
		return brandDao.getByID(Brand_ID);
	}
	@Transactional
	@Override
	public void update(Brands brand) {
		brandDao.update(brand);
		
	}
}
