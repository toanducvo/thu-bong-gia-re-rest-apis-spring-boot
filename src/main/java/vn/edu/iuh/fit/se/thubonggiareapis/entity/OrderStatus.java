package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrderStatusPK.class)
@Table(name = "orderStatus")
public class OrderStatus {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Id
	@Column(nullable = false, updatable = false)
	private String status;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false, updatable = false)
	private String statusNote;
}
