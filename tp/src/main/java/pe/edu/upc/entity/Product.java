package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@Column(name = "name", length = 30)
	private String name;
	
	@Column(name = "price")
	private Double   price;
	
	@Column(name = "description", length = 100)
	private String description;
	
    @ManyToOne
	@JoinColumn(name="id")
    private Pharmacy pharmacy;
	

	// getters and  setter

	public Product(int idProduct, String name, Double price, String description, Pharmacy pharmacy) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.description = description;
		this.pharmacy = pharmacy;
	

	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
}