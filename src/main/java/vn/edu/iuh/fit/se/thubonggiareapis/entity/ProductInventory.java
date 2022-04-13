package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productInventory")
public class ProductInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, updatable = false)
	private int quantity;
	
	@Column(nullable = false, updatable = false)
	private double cost;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt; 
}
