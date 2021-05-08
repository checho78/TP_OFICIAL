package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Card;

public interface ICardService {
	public void insert(Card  card);
	public List<Card> list();
	public List<Card> findByNameCard(Card card);
	public void delete(int id);
	


}
