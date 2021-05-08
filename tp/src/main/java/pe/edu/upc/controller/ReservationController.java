package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Reservation;
import pe.edu.upc.service.IReservationService;

@Named
@RequestScoped
public class ReservationController implements Serializable {
	private static final long serialVersionUID = 1L;

	
	 @Inject
	 private IReservationService rS;
	 
	 private Reservation reservation;
	 List<Reservation> listReservations;
	 
	 
	 @PostConstruct
	 public void init()
	 {
		 this.listReservations =  new ArrayList<Reservation>();
		 this.reservation = new Reservation();
		 this.list();
	 }
	 
	 public String newReservation() {
			this.setReservation(new Reservation());
			return "reservation.xhtml";
		}
	 public void insert() {
		 rS.insert(reservation);
			this.clean();
			this.list();
		}
		
		public void list() {
			listReservations = rS.list();
		}
		
		public void clean() {
			this.init();
		}
		public void findByDescription() {
			if (reservation.getDescription().isEmpty())
				this.list();
			else
				listReservations = this.rS.findByDescriptionReservation(this.getReservation());
		}

		public Reservation getReservation() {
			return reservation;
		}

		public void setReservation(Reservation reservation) {
			this.reservation = reservation;
		}

		public List<Reservation> getListReservations() {
			return listReservations;
		}

		public void setListReservations(List<Reservation> listReservations) {
			this.listReservations = listReservations;
		}

			
}