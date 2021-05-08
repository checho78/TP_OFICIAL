package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Reservation;

public interface IReservationService {

	public void insert(Reservation r);
	public List<Reservation> list();
	public List<Reservation> findByDescriptionReservation(Reservation r);
	
}