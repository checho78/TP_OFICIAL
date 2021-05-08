package pe.edu.upc.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Pharmacy;
import pe.edu.upc.service.IPharmacyService;

@Named
@RequestScoped
public class PharmacyController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Inject
	 private IPharmacyService pS;
	 
	 private Pharmacy pharmacy;
	 List<Pharmacy> listPharmacies;
	 
	 @PostConstruct
	 public void init()
	 {
		 this.listPharmacies =  new ArrayList<Pharmacy>();
		 this.pharmacy = new Pharmacy();
		 this.list();
	 }
	 

	 public String newPharmacy() {
			this.setPharmacy (new Pharmacy());
			return "pharmacy.xhtml";
		}
	 public void insert() {
		 pS.insert(pharmacy);
			this.clean();
			this.list();
		}
		
		public void list() {
			listPharmacies = pS.list();
		}
		
		public void clean() {
			this.init();
		}
		public void findByName() {
			if (pharmacy.getName().isEmpty())
				this.list();
			else
				listPharmacies = this.pS.findByNamePharmacy(this.getPharmacy());
		}

		public Pharmacy getPharmacy() {
			return pharmacy;
		}
		
	     public void delete(Pharmacy p) 
	     {
	    	try {
	    		pS.delete(p.getIdPharmacy());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	     }

		public void setPharmacy(Pharmacy pharmacy) {
			this.pharmacy= pharmacy;
		}

		public List<Pharmacy> getListPharmacies() {
			return listPharmacies;
		}

		public void setListPharmacies(List<Pharmacy> listPharmacies) {
			this.listPharmacies = listPharmacies;
		}
	 

}