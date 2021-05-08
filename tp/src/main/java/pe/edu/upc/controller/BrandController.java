package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.service.IBrandService;

@Named
@RequestScoped
public class BrandController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	 private IBrandService bService;
	
	
	 private Brand brand;
	
	 List<Brand> listBrands;
	 
	 
	 @PostConstruct
	 public void init()
	 {

		 this.listBrands =  new ArrayList<Brand>();
		 this.brand = new Brand();
		
		 this.list();

	 }
	 
	 public String newBrand() {
			this.setBrand(new Brand());
			return "brand.xhtml";
	 }
	 public void insert() {
		 bService.insert(brand);
			this.clean();
			this.list();
		}
		
		public void list() {
			listBrands = bService.list();
		}
		
		
		public void clean() {
			this.init();
		}
		public void findByName() {
			if (brand.getName().isEmpty())
				this.list();
			else
				listBrands = this.bService.findByNameBrand(this.getBrand());
		}
//eliminar
		public void delete(Brand brand) 
	     {
	    	try {
	    		bService.delete(brand.getId());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	     }

	
	
		
		//SETTERS AND GETTERS
		
		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public List<Brand> getListBrands() {
			return listBrands;
		}

		public void setListBrands(List<Brand> listBrands) {
			this.listBrands = listBrands;
		}
	
		
	
}
	 
	 