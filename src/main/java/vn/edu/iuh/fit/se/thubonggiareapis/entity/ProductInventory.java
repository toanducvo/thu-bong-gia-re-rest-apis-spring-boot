package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productInventory")
public class ProductInventory {
	
	private Product product;
	
	@Column(nullable = false, updatable = false)
	private int quantity;
	
	@Column(nullable = false, updatable = false)
	private double cost;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt; 
}
