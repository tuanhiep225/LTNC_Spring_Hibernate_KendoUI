package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dao.IProductsStoresDao;
import mta.th12a.tuanhiep.dto.ProductStoreDTO;
import mta.th12a.tuanhiep.model.ProductSizes;
import mta.th12a.tuanhiep.model.ProductStores;
import mta.th12a.tuanhiep.model.ProductStoresObjec;
@Repository
public class ProductsStoresDaoImpl implements IProductsStoresDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(ProductStores entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}@Override
	public void delete(int id) {
		ProductStores entity=getByID(id);
		entity.setIsActive(false);
		update(entity);	
	}@SuppressWarnings("unchecked")
	@Override
	public List<ProductStores> getAll() {	
		/*String sql="select * from Product_stores where IsActive=1";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(ProductStores.class);
		List<ProductStores> list=query.list();*/
		return sessionFactory.getCurrentSession().createQuery("from ProductStores where IsActive=1").list();
		//return sessionFactory.getCurrentSession().createQuery("from ProductStores where IsActive=1").list();
	}@Override
	public ProductStores getByID(int id) {
		
		return (ProductStores)sessionFactory.getCurrentSession().get(ProductStores.class, id);
	}@Override
	public void update(ProductStores entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
	@Override
	public ProductStoresObjec FindByColorAndSize(int productId, int colorId, int sizeId) {
		String sql="select a.*,b.Product_Color_Name,c.Product_Size_Name,d.Product_Name,d.Product_Image from Product_Stores as a "
				+ "join Product_Colors as b "
				+ "on a.Product_Color_ID=b.Product_Color_ID "
				+ "join Product_Sizes as c "
				+ "on a.Product_Size_ID=c.Product_Size_ID "
				+ "join Products as d "
				+ "on a.Product_ID=d.Product_ID "
				+ "where a.Product_Id=:productId "
				+ "and a.Product_Color_ID=:colorId and a.Product_Size_ID=:sizeId and "
				+ "a.IsActive=1";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(ProductStoreDTO.class);
		query.setParameter("productId", productId);
		query.setParameter("colorId", colorId);
		query.setParameter("sizeId", sizeId);
		List<ProductStoreDTO> list=query.list();
		if(list.size()>0)
		return list.get(0);
		return null;
	}
}
