package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Card;

public interface ICardDao {
	
	public void insert(Card card);
	public List<Card> list();
	public List<Card> findByNameCard(Card card);
	public void delete(int idCard);
	


}