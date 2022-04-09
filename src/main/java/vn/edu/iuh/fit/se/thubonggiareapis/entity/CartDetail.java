package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cartDetail")
public class CartDetail {

	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
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
