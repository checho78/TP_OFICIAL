package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IBrandDao;
import pe.edu.upc.entity.Brand;
import pe.edu.upc.service.IBrandService;

@Named
@RequestScoped
public class BrandServiceImpl implements IBrandService {
	@Inject
	private IBrandDao bD;

	@Override
	public void insert(Brand brand) {
		bD.insert(brand);  	}

	@Override
	public List<Brand> list() {
		return bD.list();
	}

	@Override
	public List<Brand> findByNameBrand(Brand brand) {
		return bD.findByNameBrand(brand);
	}
	
//eliminar
	
	@Override
	public void delete(int id) {
		bD.delete(id);
	}
}