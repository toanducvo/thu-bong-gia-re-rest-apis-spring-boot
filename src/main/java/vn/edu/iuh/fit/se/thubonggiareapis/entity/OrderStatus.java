package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderStatus")
public class OrderStatus {
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	@Column(nullable = false, updatable = false)
	private String status;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false, updatable = false)
	private String statusNote;
}
