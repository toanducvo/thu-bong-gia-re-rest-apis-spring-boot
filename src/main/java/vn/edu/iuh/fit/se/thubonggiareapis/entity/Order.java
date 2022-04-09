package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User approvedBy;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime orderDate;
	
	@Column(nullable = false, updatable = false)
	private double total;
	
	@Column(nullable = false, updatable = false)
	private double discount;
	
	@Column(nullable = false, updatable = false)
	private double shippingCost;
	
	@Column(nullable = false, updatable = false)
	private double subTotal;
	
	@Column(nullable = false, updatable = false) //note
	private String promotionCode;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false, updatable = false)
	private String shippingAddress;
	
	@Column(nullable = false, updatable = false)
	private String shippingNote;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderDetails;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderStatus> orderStatus;
	
}
