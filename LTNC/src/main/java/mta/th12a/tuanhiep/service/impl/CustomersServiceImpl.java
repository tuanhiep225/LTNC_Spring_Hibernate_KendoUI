package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.ICustomersDao;
import mta.th12a.tuanhiep.model.Customers;
import mta.th12a.tuanhiep.service.ICustomersService;

@Service
public class CustomersServiceImpl implements ICustomersService{
	@Autowired
	private ICustomersDao customerDao;
	@Transactional
	@Override
	public int add(Customers entity) {
		return customerDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		customerDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<Customers> getAll() {
		return customerDao.getAll();
	}
	@Transactional
	@Override
	public Customers getByID(int id) {
		
		return customerDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(Customers entity) {
		customerDao.update(entity);
		
	}
	@Transactional
	@Override
	public Customers authen(String userName,String passWord) {
		// TODO Auto-generated method stub
		return customerDao.authen(userName, passWord);
	}
}
