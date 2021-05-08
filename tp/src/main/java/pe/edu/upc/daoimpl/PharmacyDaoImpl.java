package pe.edu.upc.daoimpl;

import java.io.Serializable;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPharmacyDao;
import pe.edu.upc.entity.Pharmacy;

public class PharmacyDaoImpl implements IPharmacyDao, Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert (Pharmacy p) { 
		try {
			em.persist(p);
		}	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pharmacy> list() {
		List<Pharmacy> list =  new ArrayList<Pharmacy>();
		Query q= em.createQuery("from Pharmacy p");
		list = (List<Pharmacy>)q.getResultList();
		return list;
	}
	
	public void delete (int idPharmacy) 
	{
		Pharmacy p = new Pharmacy();
		try {
			p=em.getReference(Pharmacy.class, idPharmacy); 
			em.remove(p);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pharmacy> findByNamePharmacy(Pharmacy p) {
		List<Pharmacy> list = new ArrayList<Pharmacy>();
		
		Query q = em.createQuery("from Pharmacy p where p.name  like  ?1");
		q.setParameter(1,'%' + p.getName() + '%');
		list= (List<Pharmacy>)q.getResultList();
		return list;
	}

}