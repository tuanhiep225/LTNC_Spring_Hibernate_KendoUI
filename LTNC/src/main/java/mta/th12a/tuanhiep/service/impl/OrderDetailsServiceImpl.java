package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mta.th12a.tuanhiep.dao.IOrderDetailsDao;
import mta.th12a.tuanhiep.model.OrderDetails;
import mta.th12a.tuanhiep.service.IOrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService{
	@Autowired
	private IOrderDetailsDao orderDetailDao;
	@Transactional
	@Override
	public void add(OrderDetails entity) {
		orderDetailDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		orderDetailDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<OrderDetails> getAll() {
		return orderDetailDao.getAll();
	}
	@Transactional
	@Override
	public OrderDetails getByID(int id) {
		
		return orderDetailDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(OrderDetails entity) {
		orderDetailDao.update(entity);
		
	}
}
