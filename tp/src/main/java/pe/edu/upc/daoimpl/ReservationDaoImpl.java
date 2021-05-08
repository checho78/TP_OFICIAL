package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IReservationDao;
import pe.edu.upc.entity.Reservation;

public class ReservationDaoImpl implements IReservationDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Reservation r) {
		try {
			em.persist(r);
		}	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reservation> list() {
		List<Reservation> list =  new ArrayList<Reservation>();
		Query q= em.createQuery("from Reservation r");
		list = (List<Reservation>)q.getResultList();
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findByDescriptionReservation(Reservation r) {
		List<Reservation> list = new ArrayList<Reservation>();
		Query q = em.createQuery("from Reservation where r.description  like  ?1");
		q.setParameter(1,'%' + r.getDescription() + '%');
		list= (List<Reservation>)q.getResultList();
		return list;
	}

}