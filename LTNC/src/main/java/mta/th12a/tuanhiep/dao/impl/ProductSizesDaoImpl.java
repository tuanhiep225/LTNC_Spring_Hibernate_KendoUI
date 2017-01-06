package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dao.IProductSizesDao;
import mta.th12a.tuanhiep.model.ProductColors;
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.model.Products;
@Repository
public class ProductSizesDaoImpl implements IProductSizesDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(ProductSizes entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}@Override
	public void delete(int id) {
		ProductSizes entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<ProductSizes> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from ProductSizes where IsActive=1").list();
	}@Override
	public ProductSizes getByID(int id) {
		
		return (ProductSizes)sessionFactory.getCurrentSession().get(ProductSizes.class, id);
	}@Override
	public void update(ProductSizes entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
	public List<ProductSizes> getByIdProduct(int id)
	{
		String sql="select DISTINCT a.* from PRODUCT_SIZES as a "
				+ "join PRODUCT_STORES as b "
				+ "on a.Product_Size_ID =b.Product_Size_ID and b.Product_ID=:id "
				+ "where a.IsActive=1 and b.IsActive=1";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(ProductSizes.class);
		query.setParameter("id", id);
		List<ProductSizes> list=query.list();
		return list;
	}
}
