
package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICustomerDao;
import pe.edu.upc.entity.Customer;
 
public class CustomerDaoImpl implements ICustomerDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert (Customer c) { 
		try {
			em.persist(c);
		}	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> list() {
		List<Customer> list =  new ArrayList<Customer>();
		Query q= em.createQuery("from Customer c");
		list = (List<Customer>)q.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByNameCustomer(Customer c) {
		List<Customer> list = new ArrayList<Customer>();
		Query q = em.createQuery("from Customer c where c.firstName  like  ?1");
		q.setParameter(1,'%' + c.getFirstName() + '%');
		list= (List<Customer>)q.getResultList();
		return list;
	}
}
