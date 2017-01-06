package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import mta.th12a.tuanhiep.dao.IBrandsDao;
import mta.th12a.tuanhiep.model.Brands;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandsDaoImpl implements IBrandsDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(Brands brand) {
		sessionFactory.getCurrentSession().save(brand);
		
	}@Override
	public void delete(int Brand_ID) {
		Brands entity=getByID(Brand_ID);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<Brands> getAll() {		
		return sessionFactory.getCurrentSession().createQuery("from Brands where IsActive=1").list();
	}@Override
	public Brands getByID(int Brand_ID) {
		
		return (Brands)sessionFactory.getCurrentSession().get(Brands.class, Brand_ID);
	}@Override
	public void update(Brands brand) {
		sessionFactory.getCurrentSession().update(brand);
		
	}
}
