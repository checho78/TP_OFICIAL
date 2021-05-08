package pe.edu.upc.service;

import java.util.List;
import pe.edu.upc.entity.Pharmacy;


public interface IPharmacyService {

	public void insert(Pharmacy  p);
	public List<Pharmacy> list();
	public List<Pharmacy> findByNamePharmacy(Pharmacy p);
	public void delete(int idPharmacy); 
}