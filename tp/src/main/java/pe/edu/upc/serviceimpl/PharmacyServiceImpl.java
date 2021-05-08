package pe.edu.upc.serviceimpl;

import java.util.List;



import javax.inject.Inject;


import pe.edu.upc.dao.IPharmacyDao;
import pe.edu.upc.entity.Pharmacy;
import pe.edu.upc.service.IPharmacyService;


public class PharmacyServiceImpl implements IPharmacyService {

	@Inject
	private IPharmacyDao pD;

	@Override
	public void insert(Pharmacy p) {
		pD.insert(p); 
		
	}

	@Override
	public List<Pharmacy> list() {
		return pD.list();
	}

	@Override
	public List<Pharmacy> findByNamePharmacy(Pharmacy p) {
		
		return pD.findByNamePharmacy(p);
	}
	
	public void delete(int idPharmacy) {
		pD.delete(idPharmacy);
	}

}