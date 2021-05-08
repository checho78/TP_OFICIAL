package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Reservation;

public interface IReservationDao {

	public void insert(Reservation r);
	public List<Reservation> list();
	public List<Reservation> findByDescriptionReservation(Reservation r);
}