package mta.th12a.tuanhiep.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mta.th12a.tuanhiep.dao.ICustomersDao;
import mta.th12a.tuanhiep.model.Categories;
import mta.th12a.tuanhiep.model.Customers;
@Repository
public class CustomersDaoImpl implements ICustomersDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int add(Customers customer) {
		int id=(int) sessionFactory.getCurrentSession().save(customer);
		return id;
		
	}@Override
	public void delete(int id) {
		Customers entity=getByID(id);
		entity.setIsActive(false);
		update(entity);
		
	}@SuppressWarnings("unchecked")
	@Override
	public List<Customers> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Customers where IsActive=1").list();
	}@Override
	public Customers getByID(int id) {
		
		return (Customers)sessionFactory.getCurrentSession().get(Customers.class, id);
	}@Override
	public void update(Customers customer) {
		sessionFactory.getCurrentSession().update(customer);
		
	}
	@Override
	public Customers authen(String userName,String passWord) {
		String sql="from Customers where Account='"+userName+"' and Password='"+passWord+"'";
		/*String sql="select e from "+Customers.class.getName()+" e where e.Account=:userName";
		Query query=sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("userName",userName);
		List<Customers> listCustomer=query.list();*/
		List<Customers> listCustomer= sessionFactory.getCurrentSession().createQuery(sql).list();
		if(listCustomer.size()>0)
		return listCustomer.get(0);
		return null;
	}
}
