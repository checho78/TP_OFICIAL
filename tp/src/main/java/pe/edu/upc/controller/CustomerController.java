package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.service.ICustomerService;

@Named
@RequestScoped
public class CustomerController implements Serializable {
	private static final long serialVersionUID = 1L;

	
	 @Inject
	 private ICustomerService cS;
	 
	 private Customer customer;
	 List<Customer> listCustomers;
	 
	 
	 @PostConstruct
	 public void init()
	 {
		 this.listCustomers =  new ArrayList<Customer>();
		 this.customer = new Customer();
		 this.list();
	 }
	 
	 public String newCustomer() {
			this.setCustomer(new Customer());
			return "customer.xhtml";
		}
	 public void insert() {
		 cS.insert(customer);
			this.clean();
			this.list();
		}
		
		public void list() {
			listCustomers = cS.list();
		}
		
		public void clean() {
			this.init();
		}
		public void findByName() {
			if (customer.getFirstName().isEmpty())
				this.list();
			else
				listCustomers = this.cS.findByNameCustomer(this.getCustomer());
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Customer> getListCustomers() {
			return listCustomers;
		}

		public void setListCustomers(List<Customer> listCustomers) {
			this.listCustomers = listCustomers;
		}

		
		
		



}