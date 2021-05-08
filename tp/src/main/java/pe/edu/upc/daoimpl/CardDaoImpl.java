package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICardDao;
import pe.edu.upc.entity.Card;

public class CardDaoImpl implements ICardDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert (Card card) { 
		try {
			em.persist(card);
		}	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Card> list() {
		List<Card> list =  new ArrayList<Card>();
		Query q= em.createQuery("from Card card");
		list = (List<Card>)q.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Card> findByNameCard(Card card) {
		List<Card> list = new ArrayList<Card>();
		Query q = em.createQuery("from Card card where numCard  like  ?1");
		q.setParameter(1,'%' + card.getNumCard() + '%');
		list= (List<Card>)q.getResultList();
		return list;
	}
	
	//eliminar
	
	@Transactional
	@Override
	public void delete(int id) {
		Card a = new Card();
		try {
			a =em.getReference(Card.class, a);
			em.remove(a);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}