package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(CartDetailPK.class)
@Table(name = "cartDetails")
public class CartDetail {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	private int quantity;
	private double cost;
	private double totalLine;
	
	
	
}
