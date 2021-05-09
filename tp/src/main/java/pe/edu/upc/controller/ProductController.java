package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Pharmacy;
import pe.edu.upc.entity.Product;

import pe.edu.upc.service.IProductService;
import pe.edu.upc.service.IPharmacyService;

@Named
@RequestScoped
public class ProductController implements Serializable{
	public static final long serialVersionUID = 1L;
	

	
	@Inject
	private IProductService pS;
	
	@Inject
	private IPharmacyService phS;
	

	private Product product;
	List<Product> listProducts;
	
	private Pharmacy pharmacy;
	List<Pharmacy> listPharmacies;

	@PostConstruct
	public void init() {
		this.product = new Product();	
		this.pharmacy = new Pharmacy();

		
		this.listProducts = new ArrayList<Product>();
		this.listPharmacies = new ArrayList<Pharmacy>();

		this.list();
		this.listPharmacy();

		}
	
	public String newProduct(){
		this.setProduct(new Product());
		return "product.xhtml";
	}
	
	public void insert() {
		pS.insert(product);
		this.clean();
		this.list();
	}
	
	public void list() {
		listProducts = pS.list();
	}

	
	 public void listPharmacy() {
			listPharmacies = phS.list();
			
		}
		
	
	
	public void clean() {
		this.init();
	}
	
	public void eliminar(Product p) {
		try {
			pS.eliminar(p.getIdProduct());
			this.list();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void findByName() {
		if(product.getName().isEmpty()) {
			this.list();
		}else {
			listProducts = this.pS.fingByNameProduct(this.getProduct());
		}
	}

	
	
	//getters and setters
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public List<Pharmacy> getListPharmacies() {
		return listPharmacies;
	}
	public void setListPharmacies(List<Pharmacy> listPharmacies) {
		this.listPharmacies = listPharmacies;
	}
	
	
	
	

}