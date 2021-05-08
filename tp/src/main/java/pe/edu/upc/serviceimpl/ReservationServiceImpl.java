package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IReservationDao;
import pe.edu.upc.entity.Reservation;
import pe.edu.upc.service.IReservationService;

public class ReservationServiceImpl implements IReservationService{

	@Inject
	private IReservationDao rD;
	
	@Override
	public void insert(Reservation r) {
		rD.insert(r); 
	}

	@Override
	public List<Reservation> list() {
		return rD.list();
	}

	@Override
	public List<Reservation> findByDescriptionReservation(Reservation r) {
		// TODO Auto-generated method stub
		return null;
	}

	

}