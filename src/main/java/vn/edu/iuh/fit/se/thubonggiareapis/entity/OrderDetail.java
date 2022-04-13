package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrderDetailPK.class)
@Table(name = "orderDetails")
public class OrderDetail {
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(nullable = false, updatable = false)
	private int quantity;

	@Column(nullable = false, updatable = false)
	private double cost;
	
	@Column(nullable = false, updatable = false)
	private double totalLine;

}
