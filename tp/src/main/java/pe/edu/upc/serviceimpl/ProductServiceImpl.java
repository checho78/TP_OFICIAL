package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IProductService;

public class ProductServiceImpl implements IProductService{
	
	@Inject
	private IProductDao pD;

	@Override
	public void insert(Product p) {
		pD.insert(p);
	}

	@Override
	public List<Product> list() {
		return pD.list();
	}

	@Override
	public List<Product> fingByNameProduct(Product p) {
		return pD.findByNameProduct(p);
	}
	
	@Override
	public void eliminar(int idproduct) {
		pD.eliminar(idproduct);
	}

}