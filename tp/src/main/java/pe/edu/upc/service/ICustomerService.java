package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Customer;


public interface ICustomerService {
	public void insert(Customer  c);
	public List<Customer> list();
	public List<Customer> findByNameCustomer(Customer c);
}
