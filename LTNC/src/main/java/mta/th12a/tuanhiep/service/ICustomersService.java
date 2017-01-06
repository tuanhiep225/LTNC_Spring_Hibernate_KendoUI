package mta.th12a.tuanhiep.service;

import java.util.List;

import mta.th12a.tuanhiep.model.Customers;

public interface ICustomersService {
	public int add(Customers customer);
	public void update (Customers customer);
	public void delete (int id);
	public Customers getByID(int id);
	public Customers authen(String userName,String passWord);
	public List<Customers> getAll();
}
