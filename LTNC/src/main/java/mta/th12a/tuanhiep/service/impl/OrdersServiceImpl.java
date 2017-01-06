package mta.th12a.tuanhiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mta.th12a.tuanhiep.dao.IOrdersDao;
import mta.th12a.tuanhiep.dto.Cart;
import mta.th12a.tuanhiep.model.Orders;
import mta.th12a.tuanhiep.service.IOrdersService;

@Service
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private IOrdersDao orderDao;
	@Transactional
	@Override
	public void add(Orders entity) {
		orderDao.add(entity);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		orderDao.delete(id);
		
	}
	@Transactional
	@Override
	public List<Orders> getAll() {
		return orderDao.getAll();
	}
	@Transactional
	@Override
	public Orders getByID(int id) {
		
		return orderDao.getByID(id);
	}
	@Transactional
	@Override
	public void update(Orders entity) {
		orderDao.update(entity);
		
	}
	@Transactional
	@Override
	public void insertOrder(String customerId, String name, String email, String sdt, String diaChi, Cart cart) {
		orderDao.insertOrder(customerId, name, email, sdt, diaChi, cart);
		
	}
}
