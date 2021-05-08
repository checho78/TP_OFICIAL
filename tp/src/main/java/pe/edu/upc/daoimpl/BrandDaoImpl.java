package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IBrandDao;
import pe.edu.upc.entity.Brand;



public class BrandDaoImpl implements IBrandDao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert (Brand brand) { 
		try {
			em.persist(brand);
		}	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Brand> list() {
		List<Brand> list =  new ArrayList<Brand>();
		Query q= em.createQuery("from Brand brand");
		list = (List<Brand>)q.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> findByNameBrand(Brand brand) {
		List<Brand> list = new ArrayList<Brand>();
		Query q = em.createQuery("from Brand brand where brand.name  like  ?1");
		q.setParameter(1,'%' + brand.getName() + '%');
		list= (List<Brand>)q.getResultList();
		return list;
	}

	
	@Transactional
	@Override
	public void delete(int id) {
		Brand a = new Brand();
		try {
			a =em.getReference(Brand.class, a);
			em.remove(a);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}