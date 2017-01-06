package mta.th12a.tuanhiep.dao.impl;

import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dto.*;
import mta.th12a.tuanhiep.dao.IOrdersDao;
import mta.th12a.tuanhiep.model.Customers;
import mta.th12a.tuanhiep.model.OrderDetails;
import mta.th12a.tuanhiep.model.Orders;
@Repository
public class OrdersDaoImpl implements IOrdersDao {
	@Autowired
	SessionFactory sessionFactory;
	public void add(Orders entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}@Override
	public void delete(int id) {
		Orders entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getAll() {		
		return sessionFactory.getCurrentSession().createQuery("from Orders where IsActive=1").list();
	}@Override
	public Orders getByID(int id) {
		
		return (Orders)sessionFactory.getCurrentSession().get(Orders.class, id);
	}@Override
	public void update(Orders entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}
	@Override
	public void insertOrder(String customerId, String name, String email, String sdt, String diaChi, Cart cart) {
		if(customerId=="")
		{
			Customers newCustomer=new Customers();
			newCustomer.setName(name);
			newCustomer.setAddress(diaChi);
			newCustomer.setEmail(email);
			newCustomer.setPhone(sdt);
			int idCtm=(int) sessionFactory.getCurrentSession().save(newCustomer);
			
			Orders newOrder=new Orders(0,idCtm,name,diaChi,sdt,email,0,true);
			int orderId=(int) sessionFactory.getCurrentSession().save(newOrder);
			for(Entry<Integer, ItemDTO>entry:cart.getCartItem().entrySet())
			{
				int soLuong=entry.getValue().getQuantity();
				int productStoreId=entry.getValue().getProduct().getProductStoreId();
				OrderDetails orderDetail=new OrderDetails(0,productStoreId,orderId,soLuong,null,true);
				sessionFactory.getCurrentSession().save(orderDetail);
			}
		}
		
		else{
			int id=Integer.parseInt(customerId);
			int idCtm=((Customers)sessionFactory.getCurrentSession().get(Customers.class, id)).getCustomerId();
			Orders newOrder=new Orders(0,idCtm,name,diaChi,sdt,email,0,true);
			int orderId=(int) sessionFactory.getCurrentSession().save(newOrder);
			for(Entry<Integer, ItemDTO>entry:cart.getCartItem().entrySet())
			{
				int soLuong=entry.getValue().getQuantity();
				int productStoreId=entry.getValue().getProduct().getProductStoreId();
				OrderDetails orderDetail=new OrderDetails(0,productStoreId,orderId,soLuong,null,true);
				sessionFactory.getCurrentSession().save(orderDetail);
			}
		}
	}
}
