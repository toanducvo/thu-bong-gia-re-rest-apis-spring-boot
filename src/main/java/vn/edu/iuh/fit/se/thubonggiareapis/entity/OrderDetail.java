package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class OrderDetail {
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@Column(nullable = false, updatable = false)
	private int quantity;

	@Column(nullable = false, updatable = false)
	private double cost;
	
	@Column(nullable = false, updatable = false)
	private double totalLine;

}
