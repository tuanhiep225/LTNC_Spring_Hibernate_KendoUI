package mta.th12a.tuanhiep.service;

import java.util.List;

import mta.th12a.tuanhiep.model.OrderDetails;

public interface IOrderDetailsService {
	public void add(OrderDetails entity);
	public void update (OrderDetails entity);
	public void delete (int id);
	public OrderDetails getByID(int id);
	public List<OrderDetails> getAll();
}
