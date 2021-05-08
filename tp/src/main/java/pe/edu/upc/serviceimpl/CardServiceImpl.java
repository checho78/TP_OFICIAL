package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICardDao;
import pe.edu.upc.entity.Card;
import pe.edu.upc.service.ICardService;

@Named
@RequestScoped
public class CardServiceImpl implements ICardService{
	

	@Inject
	private ICardDao cdD;

	@Override
	public void insert(Card card) {
		cdD.insert(card);  	}

	@Override
	public List<Card> list() {
		return cdD.list();
	}

	@Override
	public List<Card> findByNameCard(Card card) {
		return cdD.findByNameCard(card);
	}
	@Override
	public void delete(int id) {
		cdD.delete(id);
	}

}