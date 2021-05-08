package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Card;
import pe.edu.upc.entity.Customer;
import pe.edu.upc.service.ICardService;
import pe.edu.upc.service.ICustomerService;

@Named
@RequestScoped
public class CardController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	 private ICardService cS;
	 
	@Inject
	 private ICustomerService cuS;
	
	 private Card card;
	 List<Card> listCards;
	 
	 private Customer customer;
	 List<Customer> listCustomers;
	 
	 @PostConstruct
	 public void init()
	 {
		 this.listCards =  new ArrayList<Card>();
		 this.card = new Card();
		 this.list();
		 
		 this.listCustomers =  new ArrayList<Customer>();
		 this.customer = new Customer();
		 this.listCustomer();
	 }
	 public String newCard() {
			this.setCard(new Card());
			return "card.xhtml";
	 }
	 public void insert() {
		 cS.insert(card);
			this.clean();
			this.list();
	 }
	 public void list() {
			listCards = cS.list();
			
		}
	 public void listCustomer() {
			listCustomers = cuS.list();
			
		}
		
		public void clean() {
			this.init();
		}
		public void findByName() {
			if (card.getNumCard().isEmpty())
				this.list();
			else
				listCards = this.cS.findByNameCard(this.getCard());
		}
//eliminar
		public void delete(Card card) 
	     {
	    	try {
	    		cS.delete(card.getIdCard());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	     }
//eliminar
		public Card getCard() {
			return card;
		}
		public void setCard(Card card) {
			this.card = card;
		}
		public List<Card> getListCards() {
			return listCards;
		}
		public void setListCards(List<Card> listCards) {
			this.listCards = listCards;
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