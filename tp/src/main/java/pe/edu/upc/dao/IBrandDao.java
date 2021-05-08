package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Brand;

public interface IBrandDao {

	public void insert(Brand brand);
	public List<Brand> list();
	public List<Brand> findByNameBrand(Brand brand);
	public void delete(int id);	


}