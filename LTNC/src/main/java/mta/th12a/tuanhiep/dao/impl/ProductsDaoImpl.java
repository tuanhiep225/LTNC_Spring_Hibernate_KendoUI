package mta.th12a.tuanhiep.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import mta.th12a.tuanhiep.dao.IProductsDao;
import mta.th12a.tuanhiep.dto.ProductDTO;
import mta.th12a.tuanhiep.model.ProductImages;
import mta.th12a.tuanhiep.model.Products;
@Repository
public class ProductsDaoImpl implements IProductsDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void add(Products entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}@Override
	public void delete(int id) {
		Products entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Products where IsActive=1").list();
	}@Override
	public Products getByID(int id) {
		
		return (Products)sessionFactory.getCurrentSession().get(Products.class, id);
	}@Override
	public void update(Products entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
	@Override
	public List<ProductDTO> getListByCategoryID(int ID) {
		ArrayList<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		String sql="select a.*,b.Brand_Name,c.Category_Name from PRODUCTS a,CATEGORIES c,BRANDS b "
				+ "where a.Brand_ID=b.Brand_ID and a.Category_ID=c.Category_ID and a.IsActive=1 and "
				+ "b.IsActive=1 and c.IsActive=1 and a.Category_ID=:id";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("id", ID);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List result=query.list();
		for(Object object:result)
		{
			ProductDTO dto=new ProductDTO();
			Map row = (Map)object;
			dto.setBrandId((Integer)row.get("Product_ID"));
			dto.setBrandName((String)row.get("Brand_Name"));
			dto.setCategoryId((Integer) row.get("Category_ID"));
			dto.setCategoryName((String) row.get("Category_Name"));
			dto.setProductId((Integer)row.get("Product_ID"));
			dto.setProductImage((String) row.get("Product_Image"));
			dto.setProductName((String) row.get("Product_Name"));
			listProductDTO.add(dto);
			
		}
		return listProductDTO;
	}
	@Override
	public List<ProductDTO> getListNew()
	{
		ArrayList<ProductDTO> listProductDTO=new ArrayList<ProductDTO>();
		String sql="select top 4 a.*,b.Brand_Name,c.Category_Name from PRODUCTS a,CATEGORIES c,BRANDS b "
				+ "where a.Brand_ID=b.Brand_ID and a.Category_ID=c.Category_ID and a.IsActive=1 and "
				+ "b.IsActive=1 and c.IsActive=1 order by a.Product_ID desc";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List result=query.list();
		for(Object object:result)
		{
			ProductDTO dto=new ProductDTO();
			Map row = (Map)object;
			dto.setBrandId((Integer)row.get("Product_ID"));
			dto.setBrandName((String)row.get("Brand_Name"));
			dto.setCategoryId((Integer) row.get("Category_ID"));
			dto.setCategoryName((String) row.get("Category_Name"));
			dto.setProductId((Integer)row.get("Product_ID"));
			dto.setProductImage((String) row.get("Product_Image"));
			dto.setProductName((String) row.get("Product_Name"));
			listProductDTO.add(dto);
		}
		return listProductDTO;
	}
}
