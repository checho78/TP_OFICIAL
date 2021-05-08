package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;

public class ProductDaoImpl implements IProductDao, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Product p) {
		try {
			em.persist(p);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> list() {
		List<Product> list = new ArrayList<Product>();
		Query q = em.createQuery(" from Product p");
		list = (List<Product>)q.getResultList();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByNameProduct(Product p) {
		List<Product> list = new ArrayList<Product>();
		Query q = em.createQuery("from Product p where p.name like ?1");
		q.setParameter(1, '%' + p.getName() + '%');
		list= (List<Product>)q.getResultList(); 
	
		return list;
	}
	
	@Transactional
	@Override
	public void eliminar(int idproduct) {
		Product p = new Product();
		try {
			p = em.getReference(Product.class,idproduct);
			em.remove(p);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	
}