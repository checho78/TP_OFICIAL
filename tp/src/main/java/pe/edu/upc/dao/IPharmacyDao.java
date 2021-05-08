package pe.edu.upc.dao;
import java.util.List;

import pe.edu.upc.entity.Pharmacy;

public interface IPharmacyDao {
	public void insert(Pharmacy p);
	public void delete(int idPharmacy);
	public List<Pharmacy> list();
	public List<Pharmacy> findByNamePharmacy(Pharmacy p);
}