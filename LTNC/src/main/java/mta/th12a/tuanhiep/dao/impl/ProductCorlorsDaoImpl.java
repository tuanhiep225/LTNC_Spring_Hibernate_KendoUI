package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dao.IProductCorlorsDao;
import mta.th12a.tuanhiep.model.ProductColors;
@Repository
public class ProductCorlorsDaoImpl implements IProductCorlorsDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(ProductColors entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}@Override
	public void delete(int id) {
		ProductColors entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<ProductColors> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from ProductColors where IsActive=1").list();
	}@Override
	public ProductColors getByID(int id) {
		
		return (ProductColors)sessionFactory.getCurrentSession().get(ProductColors.class, id);
	}@Override
	public void update(ProductColors entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
	@Override
	public List<ProductColors> getByIdProduct(int id)
	{
		String sql="select DISTINCT a.* from PRODUCT_COLORS as a "
				+ "join PRODUCT_STORES as b "
				+ "on a.Product_Color_ID =b.Product_Color_ID and b.Product_ID=:id "
				+ "where a.IsActive=1 and b.IsActive=1";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(ProductColors.class);
		query.setParameter("id", id);
		List<ProductColors> list=query.list();
		return list;		
	}
}
