package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Customer;

public interface ICustomerDao {

	public void insert(Customer c);
	public List<Customer> list();
	public List<Customer> findByNameCustomer(Customer c);

}
