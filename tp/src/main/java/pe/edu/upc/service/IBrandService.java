package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	public void insert(Brand  brand);
	public List<Brand> list();
	public List<Brand> findByNameBrand(Brand brand);
	public void delete(int id);
	

}