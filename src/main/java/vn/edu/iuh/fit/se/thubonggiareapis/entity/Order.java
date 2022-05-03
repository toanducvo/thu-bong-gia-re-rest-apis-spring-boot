package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
//	@Column(nullable = false, updatable = false) //note
//	private String promotionCode;
	
	@ManyToOne
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;
	
	
	@Column(nullable = false, updatable = false)
	private String shippingAddress;
	
	@Column(nullable = false, updatable = false)
	private String shippingNote;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User approvedBy;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public Order() {
		super();
	}

	public Order(long id) {
		super();
		this.id = id;
	}

	public Order(LocalDateTime orderDate, double total, double discount, double shippingCost, double subTotal,
			Promotion promotion, String status, String shippingAddress, String shippingNote, Customer customer,
			User approvedBy, List<OrderDetail> orderDetails) {
		super();
		this.orderDate = orderDate;
		this.total = total;
		this.discount = discount;
		this.shippingCost = shippingCost;
		this.subTotal = subTotal;
		this.promotion = promotion;
		this.shippingAddress = shippingAddress;
		this.shippingNote = shippingNote;
		this.customer = customer;
		this.approvedBy = approvedBy;
		this.orderDetails = orderDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingNote() {
		return shippingNote;
	}

	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", discount=" + discount
				+ ", shippingCost=" + shippingCost + ", subTotal=" + subTotal + ", promotion=" + promotion + ", shippingAddress=" + shippingAddress + ", shippingNote=" + shippingNote + ", customer="
				+ customer.getId() + ", approvedBy=" + approvedBy + "]";
	}

	

	
	
	
}
