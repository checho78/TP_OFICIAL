package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IProductDao {
	
	public void insert(Product p);
	public List<Product> list();
	public List<Product> findByNameProduct(Product p);
	public void eliminar(int idproduct);
	
}