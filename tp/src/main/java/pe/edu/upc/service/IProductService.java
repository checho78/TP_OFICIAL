package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IProductService {
	public void insert(Product p);
	public List<Product> list();
	public List<Product> fingByNameProduct(Product c);
	public void eliminar(int idproduct);
}