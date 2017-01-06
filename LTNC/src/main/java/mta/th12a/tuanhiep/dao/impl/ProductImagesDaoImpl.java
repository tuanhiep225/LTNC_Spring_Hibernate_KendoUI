package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dao.IProductImagesDao;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.model.ProductImages;
@Repository
public class ProductImagesDaoImpl implements IProductImagesDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(ProductImages entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}@Override
	public void delete(int id) {
		ProductImages entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<ProductImages> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from ProductImages where IsActive=1").list();
	}@Override
	public ProductImages getByID(int id) {
		
		return (ProductImages)sessionFactory.getCurrentSession().get(ProductImages.class, id);
	}@Override
	public void update(ProductImages entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
}
