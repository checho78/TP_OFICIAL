package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ICustomerDao;
import pe.edu.upc.entity.Customer;
import pe.edu.upc.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	@Inject
	private ICustomerDao cD;

	@Override
	public void insert(Customer c) {
		cD.insert(c);  
	}

	@Override
	public List<Customer> list() {
		return cD.list();
	}

	@Override
	public List<Customer> findByNameCustomer(Customer c) {
		return cD.findByNameCustomer(c);
	}

}

